/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


// --------------------------------------------------------------
//  THIS IS A GENERATED SOURCE FILE. DO NOT EDIT!
//  GENERATED FROM eu.pawelsz.apache.beam.coders.TupleCoderGenerator.
// --------------------------------------------------------------


package eu.pawelsz.apache.beam.coders;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.coders.CoderException;
import org.apache.beam.sdk.coders.StandardCoder;
import org.apache.beam.sdk.util.PropertyNames;
import org.apache.beam.sdk.util.common.ElementByteSizeObserver;
import org.apache.flink.api.java.tuple.Tuple7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class Tuple7Coder<T0, T1, T2, T3, T4, T5, T6> extends StandardCoder<Tuple7<T0, T1, T2, T3, T4, T5, T6>> {


  public static <T0, T1, T2, T3, T4, T5, T6> Tuple7Coder<T0, T1, T2, T3, T4, T5, T6> of(
      Coder<T0> t0,
      Coder<T1> t1,
      Coder<T2> t2,
      Coder<T3> t3,
      Coder<T4> t4,
      Coder<T5> t5,
      Coder<T6> t6) {
    return new Tuple7Coder<>(t0, t1, t2, t3, t4, t5, t6);
  }

  @JsonCreator
  public static Tuple7Coder<?, ?, ?, ?, ?, ?, ?> of(
      @JsonProperty(PropertyNames.COMPONENT_ENCODINGS)
          List<Coder<?>> components) {
    Preconditions.checkArgument(components.size() == 7,
        "Expecting 7 components, got" + components.size());
    return of(
        components.get(0),
        components.get(1),
        components.get(2),
        components.get(3),
        components.get(4),
        components.get(5),
        components.get(6));
  }

  public static <T0, T1, T2, T3, T4, T5, T6> List<Object> getInstanceComponents(
      Tuple7<T0, T1, T2, T3, T4, T5, T6> exampleValue) {
    return Arrays.asList(
        exampleValue.f0,
        exampleValue.f1,
        exampleValue.f2,
        exampleValue.f3,
        exampleValue.f4,
        exampleValue.f5,
        exampleValue.f6);
  }

  public Coder<T0> getF0Coder() {
    return t0Coder;
  }

  public Coder<T1> getF1Coder() {
    return t1Coder;
  }

  public Coder<T2> getF2Coder() {
    return t2Coder;
  }

  public Coder<T3> getF3Coder() {
    return t3Coder;
  }

  public Coder<T4> getF4Coder() {
    return t4Coder;
  }

  public Coder<T5> getF5Coder() {
    return t5Coder;
  }

  public Coder<T6> getF6Coder() {
    return t6Coder;
  }

  private final Coder<T0> t0Coder;
  private final Coder<T1> t1Coder;
  private final Coder<T2> t2Coder;
  private final Coder<T3> t3Coder;
  private final Coder<T4> t4Coder;
  private final Coder<T5> t5Coder;
  private final Coder<T6> t6Coder;

  private Tuple7Coder(
      Coder<T0> t0Coder,
      Coder<T1> t1Coder,
      Coder<T2> t2Coder,
      Coder<T3> t3Coder,
      Coder<T4> t4Coder,
      Coder<T5> t5Coder,
      Coder<T6> t6Coder) {
    this.t0Coder = t0Coder;
    this.t1Coder = t1Coder;
    this.t2Coder = t2Coder;
    this.t3Coder = t3Coder;
    this.t4Coder = t4Coder;
    this.t5Coder = t5Coder;
    this.t6Coder = t6Coder;
  }

  @Override
  public void encode(Tuple7<T0, T1, T2, T3, T4, T5, T6> tuple, OutputStream outputStream, Context context)
      throws CoderException, IOException {
    if (tuple == null) {
      throw new CoderException("cannot encode a null Tuple7");
    }
    Context nestedContext = context.nested();
    t0Coder.encode(tuple.f0, outputStream, nestedContext);
    t1Coder.encode(tuple.f1, outputStream, nestedContext);
    t2Coder.encode(tuple.f2, outputStream, nestedContext);
    t3Coder.encode(tuple.f3, outputStream, nestedContext);
    t4Coder.encode(tuple.f4, outputStream, nestedContext);
    t5Coder.encode(tuple.f5, outputStream, nestedContext);
    t6Coder.encode(tuple.f6, outputStream, nestedContext);
  }

  @Override
  public Tuple7<T0, T1, T2, T3, T4, T5, T6> decode(InputStream inputStream, Context context)
      throws CoderException, IOException {
    Context nestedContext = context.nested();
    T0 f0 = t0Coder.decode(inputStream, nestedContext);
    T1 f1 = t1Coder.decode(inputStream, nestedContext);
    T2 f2 = t2Coder.decode(inputStream, nestedContext);
    T3 f3 = t3Coder.decode(inputStream, nestedContext);
    T4 f4 = t4Coder.decode(inputStream, nestedContext);
    T5 f5 = t5Coder.decode(inputStream, nestedContext);
    T6 f6 = t6Coder.decode(inputStream, nestedContext);
    return Tuple7.of(f0, f1, f2, f3, f4, f5, f6);
  }

  @Override
  public List<? extends Coder<?>> getCoderArguments() {
    return Arrays.asList(t0Coder, t1Coder, t2Coder, t3Coder, t4Coder, t5Coder, t6Coder);  }

  @Override
  public void verifyDeterministic() throws NonDeterministicException {
    verifyDeterministic("Coders must be deterministic", t0Coder, t1Coder, t2Coder, t3Coder, t4Coder, t5Coder, t6Coder);
  }

  @Override
  public boolean consistentWithEquals() {
    return t0Coder.consistentWithEquals()
        && t1Coder.consistentWithEquals()
        && t2Coder.consistentWithEquals()
        && t3Coder.consistentWithEquals()
        && t4Coder.consistentWithEquals()
        && t5Coder.consistentWithEquals()
        && t6Coder.consistentWithEquals();
  }

  @Override
  public Object structuralValue(Tuple7<T0, T1, T2, T3, T4, T5, T6> tuple) throws Exception {
    if (consistentWithEquals()) {
      return tuple;
    } else {
      return Tuple7.of(
        t0Coder.structuralValue(tuple.f0),
        t1Coder.structuralValue(tuple.f1),
        t2Coder.structuralValue(tuple.f2),
        t3Coder.structuralValue(tuple.f3),
        t4Coder.structuralValue(tuple.f4),
        t5Coder.structuralValue(tuple.f5),
        t6Coder.structuralValue(tuple.f6));
    }
  }

  @Override
  public boolean isRegisterByteSizeObserverCheap(Tuple7<T0, T1, T2, T3, T4, T5, T6> tuple, Context context) {
    return t0Coder.isRegisterByteSizeObserverCheap(tuple.f0, context.nested())
        && t1Coder.isRegisterByteSizeObserverCheap(tuple.f1, context.nested())
        && t2Coder.isRegisterByteSizeObserverCheap(tuple.f2, context.nested())
        && t3Coder.isRegisterByteSizeObserverCheap(tuple.f3, context.nested())
        && t4Coder.isRegisterByteSizeObserverCheap(tuple.f4, context.nested())
        && t5Coder.isRegisterByteSizeObserverCheap(tuple.f5, context.nested())
        && t6Coder.isRegisterByteSizeObserverCheap(tuple.f6, context.nested());
  }

  @Override
  public void registerByteSizeObserver(Tuple7<T0, T1, T2, T3, T4, T5, T6> tuple,
                                       ElementByteSizeObserver observer,
                                       Context context) throws Exception {
    if (tuple == null) {
      throw new CoderException("cannot encode a null Tuple7 ");
    }
    Context nestedContext = context.nested();
    t0Coder.registerByteSizeObserver(tuple.f0, observer, nestedContext);
    t1Coder.registerByteSizeObserver(tuple.f1, observer, nestedContext);
    t2Coder.registerByteSizeObserver(tuple.f2, observer, nestedContext);
    t3Coder.registerByteSizeObserver(tuple.f3, observer, nestedContext);
    t4Coder.registerByteSizeObserver(tuple.f4, observer, nestedContext);
    t5Coder.registerByteSizeObserver(tuple.f5, observer, nestedContext);
    t6Coder.registerByteSizeObserver(tuple.f6, observer, nestedContext);
  }
}
