package eu.pawelsz.apache.beam.coders;

import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import org.apache.beam.runners.flink.FlinkPipelineOptions;
import org.apache.beam.runners.flink.FlinkRunner;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.ByteCoder;
import org.apache.beam.sdk.coders.ByteStringCoder;
import org.apache.beam.sdk.coders.KvCoder;
import org.apache.beam.sdk.coders.VarLongCoder;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.*;
import org.apache.beam.sdk.transforms.join.CoGbkResult;
import org.apache.beam.sdk.transforms.join.CoGroupByKey;
import org.apache.beam.sdk.transforms.join.KeyedPCollectionTuple;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TupleTag;
import org.apache.flink.api.java.tuple.Tuple2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestPipeline {
  public static Iterable<KV<Tuple2<ByteString, Long>, Long>> Generate(int k1, int k2, int perKey, long val) {
    LinkedList<KV<Tuple2<ByteString, Long>, Long>> ll = new LinkedList<>();
    ArrayList<ByteString> bs = new ArrayList<>(k1);
    for (int i = 0; i < k1; i++) {
      bs.add(ByteString.copyFromUtf8("some long ID:" + i));
    }
    long s = 1463184000000000L;
    for (int h = 0; h < perKey; h++) {
      for (int i = 0; i < k1; i++) {
        for (long j = 0; j < k2; j++) {
          ll.add(KV.of(Tuple2.of(bs.get(i), s+j), val));
        }
      }
    }
    return ll;
  }

  public static class Merge extends DoFn<KV<Tuple2<ByteString, Long>, CoGbkResult>, String> {

    private static final Logger LOG = LoggerFactory.getLogger(Merge.class);

    private final Aggregator<Long, Long> d1Miscount =
            createAggregator("data1 count", Sum.ofLongs());

    private final Aggregator<Long, Long> d2Miscount =
        createAggregator("data2 count", Sum.ofLongs());

    @ProcessElement
    public void processElement(ProcessContext c) throws Exception {
      KV kv = c.element();
      Tuple2<ByteString, Long> key = c.element().getKey();
      CoGbkResult res = c.element().getValue();
      Iterable<Long> d1 = res.getAll(tag1);
      Iterable<Long> d2 = res.getAll(tag2);
      List<Long> locs = Lists.newLinkedList(d1);
      if (locs.size() > 1) {
        d1Miscount.addValue(1L);
      }
      int locId;
      if (locs.size() < 1) {
        d1Miscount.addValue(1L);
      }

      long count = 0;
      for (Long ri : d2) {
        count++;
      }
      c.output(key.f0.toStringUtf8() + "," + key.f1 + "," + count);
//      itemCount.addValue(count);
      if (count == 0) {
        LOG.info("no pings for " + key.f0.toStringUtf8() + " on: " + key.f1);
//      } else if (locId==noLocation) {
//        LOG.info(count+" pings for " + key.f0.toStringUtf8() + " on: " + key.f1 + " marked as no-loc");
        d2Miscount.addValue(1L);
      } else {
        LOG.info(count + " pings for " + key.f0.toStringUtf8() + " on: " + key.f1);
      }
    }
  }

  private static final TupleTag<Long> tag1 = new TupleTag<>();
  private static final TupleTag<Long> tag2 = new TupleTag<>();

  public static void main(String[] args) {
    PipelineOptions options = PipelineOptionsFactory.fromArgs(args).withValidation()
        .as(FlinkPipelineOptions.class);
    options.setRunner(FlinkRunner.class);
    Pipeline p = Pipeline.create(options);
    RegisterTupleCoders.run(p);

    PCollection<KV<Tuple2<ByteString, Long>, Long>> data1 = p.apply(Create.of(Generate(5, 5, 1, 1L))
        .withCoder(
            KvCoder.of(
                Tuple2Coder.of(ByteStringCoder.of(), VarLongCoder.of()),
                VarLongCoder.of())));
    PCollection<KV<Tuple2<ByteString, Long>, Long>> data2 = p.apply(Create.of(Generate(5, 5, 1000, 2)));

    KeyedPCollectionTuple.of(tag1, data1).and(tag2, data2)
        .apply(CoGroupByKey.create())
        .apply(ParDo.of(new Merge()))
        .apply(TextIO.Write.to("/tmp/test-out").withoutSharding());


    p.run();
  }
}
