package eu.pawelsz.apache.beam.coders;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.CoderRegistry;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;

public class RegisterTupleCoders {
    public static void run(Pipeline p) {
        CoderRegistry cr = p.getCoderRegistry();
        cr.registerCoder(Tuple1.class, Tuple1Coder.class);
        cr.registerCoder(Tuple2.class, Tuple2Coder.class);
        cr.registerCoder(Tuple3.class, Tuple3Coder.class);
    }
}
