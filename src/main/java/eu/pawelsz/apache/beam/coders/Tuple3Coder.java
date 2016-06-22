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
import org.apache.flink.api.java.tuple.Tuple3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class Tuple3Coder<T0, T1, T2> extends StandardCoder<Tuple3<T0, T1, T2>> {


  public static <T0, T1, T2> Tuple3Coder<T0, T1, T2> of(
      Coder<T0> t0,
      Coder<T1> t1,
      Coder<T2> t2) {
    return new Tuple3Coder<>(t0, t1, t2);
  }

  @JsonCreator
  public static Tuple3Coder<?, ?, ?> of(
      @JsonProperty(PropertyNames.COMPONENT_ENCODINGS)
          List<Coder<?>> components) {
    Preconditions.checkArgument(components.size() == 3,
        "Expecting 3 components, got" + components.size());
    return of(
        components.get(0),
        components.get(1),
        components.get(2));
  }

  public static <T0, T1, T2> List<Object> getInstanceComponents(
      Tuple3<T0, T1, T2> exampleValue) {
    return Arrays.asList(
        exampleValue.f0,
        exampleValue.f1,
        exampleValue.f2);
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

  private final Coder<T0> t0Coder;
  private final Coder<T1> t1Coder;
  private final Coder<T2> t2Coder;

  private Tuple3Coder(
      Coder<T0> t0Coder,
      Coder<T1> t1Coder,
      Coder<T2> t2Coder) {
    this.t0Coder = t0Coder;
    this.t1Coder = t1Coder;
    this.t2Coder = t2Coder;
  }

  @Override
  public void encode(Tuple3<T0, T1, T2> tuple, OutputStream outputStream, Context context)
      throws CoderException, IOException {
    if (tuple == null) {
      throw new CoderException("cannot encode a null Tuple3");
    }
    Context nestedContext = context.nested();
    t0Coder.encode(tuple.f0, outputStream, nestedContext);
    t1Coder.encode(tuple.f1, outputStream, nestedContext);
    t2Coder.encode(tuple.f2, outputStream, nestedContext);
  }

  @Override
  public Tuple3<T0, T1, T2> decode(InputStream inputStream, Context context)
      throws CoderException, IOException {
    Context nestedContext = context.nested();
    T0 f0 = t0Coder.decode(inputStream, nestedContext);
    T1 f1 = t1Coder.decode(inputStream, nestedContext);
    T2 f2 = t2Coder.decode(inputStream, nestedContext);
    return Tuple3.of(f0, f1, f2);
  }

  @Override
  public List<? extends Coder<?>> getCoderArguments() {
    return Arrays.asList(t0Coder, t1Coder, t2Coder);  }

  @Override
  public void verifyDeterministic() throws NonDeterministicException {
    verifyDeterministic("Coders must be deterministic", t0Coder, t1Coder, t2Coder);
  }

  @Override
  public boolean consistentWithEquals() {
    return t0Coder.consistentWithEquals()
        && t1Coder.consistentWithEquals()
        && t2Coder.consistentWithEquals();
  }

  @Override
  public Object structuralValue(Tuple3<T0, T1, T2> tuple) throws Exception {
    if (consistentWithEquals()) {
      return tuple;
    } else {
      return Tuple3.of(
        t0Coder.structuralValue(tuple.f0),
        t1Coder.structuralValue(tuple.f1),
        t2Coder.structuralValue(tuple.f2));
    }
  }

  @Override
  public boolean isRegisterByteSizeObserverCheap(Tuple3<T0, T1, T2> tuple, Context context) {
    return t0Coder.isRegisterByteSizeObserverCheap(tuple.f0, context.nested())
        && t1Coder.isRegisterByteSizeObserverCheap(tuple.f1, context.nested())
        && t2Coder.isRegisterByteSizeObserverCheap(tuple.f2, context.nested());
  }

  @Override
  public void registerByteSizeObserver(Tuple3<T0, T1, T2> tuple,
                                       ElementByteSizeObserver observer,
                                       Context context) throws Exception {
    if (tuple == null) {
      throw new CoderException("cannot encode a null Tuple3 ");
    }
    Context nestedContext = context.nested();
    t0Coder.registerByteSizeObserver(tuple.f0, observer, nestedContext);
    t1Coder.registerByteSizeObserver(tuple.f1, observer, nestedContext);
    t2Coder.registerByteSizeObserver(tuple.f2, observer, nestedContext);
  }
}
