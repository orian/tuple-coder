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

import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.coders.CoderException;
import org.apache.beam.sdk.coders.StructuredCoder;
import org.apache.beam.sdk.util.common.ElementByteSizeObserver;
import org.apache.beam.sdk.values.TypeDescriptor;
import org.apache.beam.sdk.values.TypeParameter;
import org.apache.flink.api.java.tuple.Tuple2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class Tuple2Coder<T0, T1> extends StructuredCoder<Tuple2<T0, T1>> {


  public static <T0, T1> Tuple2Coder<T0, T1> of(
      Coder<T0> t0,
      Coder<T1> t1) {
    return new Tuple2Coder<>(t0, t1);
  }

  public static <T0, T1> List<Object> getInstanceComponents(
      Tuple2<T0, T1> exampleValue) {
    return Arrays.asList(
        exampleValue.f0,
        exampleValue.f1);
  }

  public Coder<T0> getF0Coder() {
    return t0Coder;
  }

  public Coder<T1> getF1Coder() {
    return t1Coder;
  }

  private final Coder<T0> t0Coder;
  private final Coder<T1> t1Coder;

  private Tuple2Coder(
      Coder<T0> t0Coder,
      Coder<T1> t1Coder) {
    this.t0Coder = t0Coder;
    this.t1Coder = t1Coder;
  }

  @Override
  public void encode(Tuple2<T0, T1> tuple, OutputStream outStream)
      throws CoderException, IOException {
    if (tuple == null) {
      throw new CoderException("cannot encode a null Tuple2");
    }
    t0Coder.encode(tuple.f0, outStream);
    t1Coder.encode(tuple.f1, outStream);
  }

  @Override
  public Tuple2<T0, T1> decode(InputStream inputStream)
      throws CoderException, IOException {
    T0 f0 = t0Coder.decode(inputStream);
    T1 f1 = t1Coder.decode(inputStream);
    return Tuple2.of(f0, f1);
  }

  @Override
  public List<? extends Coder<?>> getCoderArguments() {
    return Arrays.asList(t0Coder, t1Coder);  }

  @Override
  public void verifyDeterministic() throws NonDeterministicException {
    verifyDeterministic(t0Coder, "Coder of T0 must be deterministic");
    verifyDeterministic(t1Coder, "Coder of T1 must be deterministic");
  }

  @Override
  public boolean consistentWithEquals() {
    return t0Coder.consistentWithEquals()
        && t1Coder.consistentWithEquals();
  }

  @Override
  public Object structuralValue(Tuple2<T0, T1> tuple) {
    if (consistentWithEquals()) {
      return tuple;
    } else {
      return Tuple2.of(
        t0Coder.structuralValue(tuple.f0),
        t1Coder.structuralValue(tuple.f1));
    }
  }

  /**
   * Returns whether both keyCoder and valueCoder are considered not expensive.
   */
  @Override
  public boolean isRegisterByteSizeObserverCheap(Tuple2<T0, T1> t) {
    return t0Coder.isRegisterByteSizeObserverCheap(t.f0)
            && t1Coder.isRegisterByteSizeObserverCheap(t.f1);
  }

  /**
   * Notifies ElementByteSizeObserver about the byte size of the
   * encoded value using this coder.
   */
  @Override
  public void registerByteSizeObserver(
          Tuple2<T0, T1> t, ElementByteSizeObserver observer)
          throws Exception {
    if (t == null) {
      throw new CoderException("cannot encode a null Tuple2");
    }
    t0Coder.registerByteSizeObserver(t.f0, observer);
    t1Coder.registerByteSizeObserver(t.f1, observer);
  }

  @Override
  public TypeDescriptor<Tuple2<T0, T1>> getEncodedTypeDescriptor() {
    return new TypeDescriptor<Tuple2<T0, T1>>() {}.where(
            new TypeParameter<T0>() {}, t0Coder.getEncodedTypeDescriptor())
            .where(new TypeParameter<T1>() {}, t1Coder.getEncodedTypeDescriptor());
  }

}
