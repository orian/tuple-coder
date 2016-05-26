package eu.pawelsz.apache.beam.coders;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.coders.CoderException;
import org.apache.beam.sdk.coders.StandardCoder;
import org.apache.beam.sdk.util.PropertyNames;
import org.apache.beam.sdk.util.common.ElementByteSizeObserver;
import org.apache.flink.api.java.tuple.Tuple1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class Tuple1Coder<T0> extends StandardCoder<Tuple1<T0>> {
    public static <T0> Tuple1Coder<T0> of(Coder<T0> t0) {
        return new Tuple1Coder(t0);
    }

    @JsonCreator
    public static Tuple1Coder<?> of(
            @JsonProperty(PropertyNames.COMPONENT_ENCODINGS)
                List<Coder<?>> components) {
        Preconditions.checkArgument(components.size() == 1,
                "Expecting 1 components, got " + components.size());
        return of(components.get(0));
    }

    public static <T0> List<Object> getInstanceComponents(
            Tuple1<T0> exampleValue) {
        return Arrays.asList(exampleValue.f0);
    }

    public Coder<T0> getF0Coder() {
        return t0Coder;
    }

    private final Coder<T0> t0Coder;

    private Tuple1Coder(Coder<T0> t0Coder) {
        this.t0Coder = t0Coder;
    }

    @Override
    public void encode(Tuple1<T0> tuple, OutputStream outputStream, Context context) throws CoderException, IOException {
        if (tuple == null) {
            throw new CoderException("cannot encode a null Tuple1");
        }
        Context nestedContext = context.nested();
        t0Coder.encode(tuple.f0, outputStream, nestedContext);
    }

    @Override
    public Tuple1<T0> decode(InputStream inputStream, Context context) throws CoderException, IOException {
        Context nestedContext = context.nested();
        T0 t0 = t0Coder.decode(inputStream, nestedContext);
        return Tuple1.of(t0);
    }

    @Override
    public List<? extends Coder<?>> getCoderArguments() {
        return Arrays.asList(t0Coder);
    }

    @Override
    public void verifyDeterministic() throws NonDeterministicException {
        verifyDeterministic("T0 coder must be deterministic", getF0Coder());
    }

    @Override
    public boolean consistentWithEquals() {
        return t0Coder.consistentWithEquals();
    }

    @Override
    public Object structuralValue(Tuple1<T0> tuple1) throws Exception {
        if (consistentWithEquals()) {
            return tuple1;
        } else {
            return Tuple1.<T0>of((T0) t0Coder.structuralValue(tuple1.f0));
        }
    }

    @Override
    public boolean isRegisterByteSizeObserverCheap(Tuple1<T0> tuple1, Context context) {
        return t0Coder.isRegisterByteSizeObserverCheap(tuple1.f0, context.nested());
    }

    @Override
    public void registerByteSizeObserver(Tuple1<T0> tuple1,
                                         ElementByteSizeObserver observer,
                                         Context context) throws Exception {
        if (tuple1 == null) {
            throw new CoderException("cannot encode a null Tuple1");
        }
        t0Coder.registerByteSizeObserver(
                tuple1.f0, observer, context.nested());
    }
}
