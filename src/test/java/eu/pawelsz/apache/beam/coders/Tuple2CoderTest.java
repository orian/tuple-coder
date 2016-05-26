package eu.pawelsz.apache.beam.coders;

import com.google.protobuf.ByteString;
import org.apache.beam.sdk.coders.ByteStringCoder;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.coders.VarLongCoder;
import org.apache.flink.api.java.tuple.Tuple2;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Tuple2CoderTest {

  @Test
  public void TestSimple() throws Coder.NonDeterministicException, IOException {
    ByteString bs = ByteString.copyFromUtf8("863071015131755-WiFi");
    ByteString bs2 = ByteString.copyFromUtf8("863071015131755-WiFi");

    Long l1 = 1462665600000000L;
    Long l2 = 1463184000000000L;
    Long l3 = 1462665600000000L;
    Long l4 = 1463184000000000L;
    Tuple2 t1 = Tuple2.of(bs,l1);
    Tuple2 t2 = Tuple2.of(bs, l2);
    Tuple2 t3 = Tuple2.of(bs2,l3);
    Tuple2 t4 = Tuple2.of(bs2,l4);

    assertEquals(t1, t1);

    assertEquals(t1, t3);
    assertEquals(t3, t1);

    assertEquals(t2, t4);

    Tuple2Coder<ByteString, Long> coder = Tuple2Coder.of(ByteStringCoder.of(), VarLongCoder.of());
    assertTrue(coder.consistentWithEquals());
    coder.verifyDeterministic();

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    coder.encode(t1, bos, Coder.Context.OUTER);
    byte[] t1enc = bos.toByteArray();
    Tuple2<ByteString, Long> t1tmp = coder.decode(
        new ByteArrayInputStream(t1enc), Coder.Context.OUTER);
    assertEquals(t1, t1tmp);

    bos.reset();
    coder.encode(t3, bos, Coder.Context.OUTER);
    byte[] t3enc = bos.toByteArray();
    assertTrue(Arrays.equals(t1enc, t3enc));
    assertEquals(t1.hashCode(), t3.hashCode());
    assertEquals(t2.hashCode(), t4.hashCode());

  }
}
