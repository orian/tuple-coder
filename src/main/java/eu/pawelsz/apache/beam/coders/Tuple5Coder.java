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
import org.apache.flink.api.java.tuple.Tuple5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class Tuple5Coder<T0, T1, T2, T3, T4> extends StructuredCoder<Tuple5<T0, T1, T2, T3, T4>> {


  public static <T0, T1, T2, T3, T4> Tuple5Coder<T0, T1, T2, T3, T4> of(
      Coder<T0> t0,
      Coder<T1> t1,
      Coder<T2> t2,
      Coder<T3> t3,
      Coder<T4> t4) {
    return new Tuple5Coder<>(t0, t1, t2, t3, t4);
  }

  public static <T0, T1, T2, T3, T4> List<Object> getInstanceComponents(
      Tuple5<T0, T1, T2, T3, T4> exampleValue) {
    return Arrays.asList(
        exampleValue.f0,
        exampleValue.f1,
        exampleValue.f2,
        exampleValue.f3,
        exampleValue.f4);
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

  private final Coder<T0> t0Coder;
  private final Coder<T1> t1Coder;
  private final Coder<T2> t2Coder;
  private final Coder<T3> t3Coder;
  private final Coder<T4> t4Coder;

  private Tuple5Coder(
      Coder<T0> t0Coder,
      Coder<T1> t1Coder,
      Coder<T2> t2Coder,
      Coder<T3> t3Coder,
      Coder<T4> t4Coder) {
    this.t0Coder = t0Coder;
    this.t1Coder = t1Coder;
    this.t2Coder = t2Coder;
    this.t3Coder = t3Coder;
    this.t4Coder = t4Coder;
  }

  @Override
  public void encode(Tuple5<T0, T1, T2, T3, T4> tuple, OutputStream outStream)
      throws CoderException, IOException {
    if (tuple == null) {
      throw new CoderException("cannot encode a null Tuple5");
    }
    t0Coder.encode(tuple.f0, outStream);
    t1Coder.encode(tuple.f1, outStream);
    t2Coder.encode(tuple.f2, outStream);
    t3Coder.encode(tuple.f3, outStream);
    t4Coder.encode(tuple.f4, outStream);
  }

  @Override
  public Tuple5<T0, T1, T2, T3, T4> decode(InputStream inputStream)
      throws CoderException, IOException {
    T0 f0 = t0Coder.decode(inputStream);
    T1 f1 = t1Coder.decode(inputStream);
    T2 f2 = t2Coder.decode(inputStream);
    T3 f3 = t3Coder.decode(inputStream);
    T4 f4 = t4Coder.decode(inputStream);
    return Tuple5.of(f0, f1, f2, f3, f4);
  }

  @Override
  public List<? extends Coder<?>> getCoderArguments() {
    return Arrays.asList(t0Coder, t1Coder, t2Coder, t3Coder, t4Coder);  }

  @Override
  public void verifyDeterministic() throws NonDeterministicException {
    verifyDeterministic(t0Coder, "Coder of T0 must be deterministic");
    verifyDeterministic(t1Coder, "Coder of T1 must be deterministic");
    verifyDeterministic(t2Coder, "Coder of T2 must be deterministic");
    verifyDeterministic(t3Coder, "Coder of T3 must be deterministic");
    verifyDeterministic(t4Coder, "Coder of T4 must be deterministic");
  }

  @Override
  public boolean consistentWithEquals() {
    return t0Coder.consistentWithEquals()
        && t1Coder.consistentWithEquals()
        && t2Coder.consistentWithEquals()
        && t3Coder.consistentWithEquals()
        && t4Coder.consistentWithEquals();
  }

  @Override
  public Object structuralValue(Tuple5<T0, T1, T2, T3, T4> tuple) {
    if (consistentWithEquals()) {
      return tuple;
    } else {
      return Tuple5.of(
        t0Coder.structuralValue(tuple.f0),
        t1Coder.structuralValue(tuple.f1),
        t2Coder.structuralValue(tuple.f2),
        t3Coder.structuralValue(tuple.f3),
        t4Coder.structuralValue(tuple.f4));
    }
  }

  @Override
  public boolean isRegisterByteSizeObserverCheap(Tuple5<T0, T1, T2, T3, T4> tuple) {
    return t0Coder.isRegisterByteSizeObserverCheap(tuple.f0)
        && t1Coder.isRegisterByteSizeObserverCheap(tuple.f1)
        && t2Coder.isRegisterByteSizeObserverCheap(tuple.f2)
        && t3Coder.isRegisterByteSizeObserverCheap(tuple.f3)
        && t4Coder.isRegisterByteSizeObserverCheap(tuple.f4);
  }

  @Override
  public void registerByteSizeObserver(Tuple5<T0, T1, T2, T3, T4> tuple,
                                       ElementByteSizeObserver observer) throws Exception {
    if (tuple == null) {
      throw new CoderException("cannot encode a null Tuple5 ");
    }
    t0Coder.registerByteSizeObserver(tuple.f0, observer);
    t1Coder.registerByteSizeObserver(tuple.f1, observer);
    t2Coder.registerByteSizeObserver(tuple.f2, observer);
    t3Coder.registerByteSizeObserver(tuple.f3, observer);
    t4Coder.registerByteSizeObserver(tuple.f4, observer);
  }

  @Override
  public TypeDescriptor<Tuple5<T0, T1, T2, T3, T4>> getEncodedTypeDescriptor() {
    return new TypeDescriptor<Tuple5<T0, T1, T2, T3, T4>>() {}
      .where(new TypeParameter<T0>() {}, t0Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T1>() {}, t1Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T2>() {}, t2Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T3>() {}, t3Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T4>() {}, t4Coder.getEncodedTypeDescriptor());
  }
}
