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
import org.apache.flink.api.java.tuple.Tuple11;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class Tuple11Coder<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> extends StructuredCoder<Tuple11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> {


  public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Tuple11Coder<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> of(
      Coder<T0> t0,
      Coder<T1> t1,
      Coder<T2> t2,
      Coder<T3> t3,
      Coder<T4> t4,
      Coder<T5> t5,
      Coder<T6> t6,
      Coder<T7> t7,
      Coder<T8> t8,
      Coder<T9> t9,
      Coder<T10> t10) {
    return new Tuple11Coder<>(t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> List<Object> getInstanceComponents(
      Tuple11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> exampleValue) {
    return Arrays.asList(
        exampleValue.f0,
        exampleValue.f1,
        exampleValue.f2,
        exampleValue.f3,
        exampleValue.f4,
        exampleValue.f5,
        exampleValue.f6,
        exampleValue.f7,
        exampleValue.f8,
        exampleValue.f9,
        exampleValue.f10);
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

  public Coder<T7> getF7Coder() {
    return t7Coder;
  }

  public Coder<T8> getF8Coder() {
    return t8Coder;
  }

  public Coder<T9> getF9Coder() {
    return t9Coder;
  }

  public Coder<T10> getF10Coder() {
    return t10Coder;
  }

  private final Coder<T0> t0Coder;
  private final Coder<T1> t1Coder;
  private final Coder<T2> t2Coder;
  private final Coder<T3> t3Coder;
  private final Coder<T4> t4Coder;
  private final Coder<T5> t5Coder;
  private final Coder<T6> t6Coder;
  private final Coder<T7> t7Coder;
  private final Coder<T8> t8Coder;
  private final Coder<T9> t9Coder;
  private final Coder<T10> t10Coder;

  private Tuple11Coder(
      Coder<T0> t0Coder,
      Coder<T1> t1Coder,
      Coder<T2> t2Coder,
      Coder<T3> t3Coder,
      Coder<T4> t4Coder,
      Coder<T5> t5Coder,
      Coder<T6> t6Coder,
      Coder<T7> t7Coder,
      Coder<T8> t8Coder,
      Coder<T9> t9Coder,
      Coder<T10> t10Coder) {
    this.t0Coder = t0Coder;
    this.t1Coder = t1Coder;
    this.t2Coder = t2Coder;
    this.t3Coder = t3Coder;
    this.t4Coder = t4Coder;
    this.t5Coder = t5Coder;
    this.t6Coder = t6Coder;
    this.t7Coder = t7Coder;
    this.t8Coder = t8Coder;
    this.t9Coder = t9Coder;
    this.t10Coder = t10Coder;
  }

  @Override
  public void encode(Tuple11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> tuple, OutputStream outStream)
      throws CoderException, IOException {
    if (tuple == null) {
      throw new CoderException("cannot encode a null Tuple11");
    }
    t0Coder.encode(tuple.f0, outStream);
    t1Coder.encode(tuple.f1, outStream);
    t2Coder.encode(tuple.f2, outStream);
    t3Coder.encode(tuple.f3, outStream);
    t4Coder.encode(tuple.f4, outStream);
    t5Coder.encode(tuple.f5, outStream);
    t6Coder.encode(tuple.f6, outStream);
    t7Coder.encode(tuple.f7, outStream);
    t8Coder.encode(tuple.f8, outStream);
    t9Coder.encode(tuple.f9, outStream);
    t10Coder.encode(tuple.f10, outStream);
  }

  @Override
  public Tuple11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> decode(InputStream inputStream)
      throws CoderException, IOException {
    T0 f0 = t0Coder.decode(inputStream);
    T1 f1 = t1Coder.decode(inputStream);
    T2 f2 = t2Coder.decode(inputStream);
    T3 f3 = t3Coder.decode(inputStream);
    T4 f4 = t4Coder.decode(inputStream);
    T5 f5 = t5Coder.decode(inputStream);
    T6 f6 = t6Coder.decode(inputStream);
    T7 f7 = t7Coder.decode(inputStream);
    T8 f8 = t8Coder.decode(inputStream);
    T9 f9 = t9Coder.decode(inputStream);
    T10 f10 = t10Coder.decode(inputStream);
    return Tuple11.of(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10);
  }

  @Override
  public List<? extends Coder<?>> getCoderArguments() {
    return Arrays.asList(t0Coder, t1Coder, t2Coder, t3Coder, t4Coder, t5Coder, t6Coder, t7Coder, t8Coder, t9Coder, t10Coder);  }

  @Override
  public void verifyDeterministic() throws NonDeterministicException {
    verifyDeterministic(t0Coder, "Coder of T0 must be deterministic");
    verifyDeterministic(t1Coder, "Coder of T1 must be deterministic");
    verifyDeterministic(t2Coder, "Coder of T2 must be deterministic");
    verifyDeterministic(t3Coder, "Coder of T3 must be deterministic");
    verifyDeterministic(t4Coder, "Coder of T4 must be deterministic");
    verifyDeterministic(t5Coder, "Coder of T5 must be deterministic");
    verifyDeterministic(t6Coder, "Coder of T6 must be deterministic");
    verifyDeterministic(t7Coder, "Coder of T7 must be deterministic");
    verifyDeterministic(t8Coder, "Coder of T8 must be deterministic");
    verifyDeterministic(t9Coder, "Coder of T9 must be deterministic");
    verifyDeterministic(t10Coder, "Coder of T10 must be deterministic");
  }

  @Override
  public boolean consistentWithEquals() {
    return t0Coder.consistentWithEquals()
        && t1Coder.consistentWithEquals()
        && t2Coder.consistentWithEquals()
        && t3Coder.consistentWithEquals()
        && t4Coder.consistentWithEquals()
        && t5Coder.consistentWithEquals()
        && t6Coder.consistentWithEquals()
        && t7Coder.consistentWithEquals()
        && t8Coder.consistentWithEquals()
        && t9Coder.consistentWithEquals()
        && t10Coder.consistentWithEquals();
  }

  @Override
  public Object structuralValue(Tuple11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> tuple) {
    if (consistentWithEquals()) {
      return tuple;
    } else {
      return Tuple11.of(
        t0Coder.structuralValue(tuple.f0),
        t1Coder.structuralValue(tuple.f1),
        t2Coder.structuralValue(tuple.f2),
        t3Coder.structuralValue(tuple.f3),
        t4Coder.structuralValue(tuple.f4),
        t5Coder.structuralValue(tuple.f5),
        t6Coder.structuralValue(tuple.f6),
        t7Coder.structuralValue(tuple.f7),
        t8Coder.structuralValue(tuple.f8),
        t9Coder.structuralValue(tuple.f9),
        t10Coder.structuralValue(tuple.f10));
    }
  }

  @Override
  public boolean isRegisterByteSizeObserverCheap(Tuple11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> tuple) {
    return t0Coder.isRegisterByteSizeObserverCheap(tuple.f0)
        && t1Coder.isRegisterByteSizeObserverCheap(tuple.f1)
        && t2Coder.isRegisterByteSizeObserverCheap(tuple.f2)
        && t3Coder.isRegisterByteSizeObserverCheap(tuple.f3)
        && t4Coder.isRegisterByteSizeObserverCheap(tuple.f4)
        && t5Coder.isRegisterByteSizeObserverCheap(tuple.f5)
        && t6Coder.isRegisterByteSizeObserverCheap(tuple.f6)
        && t7Coder.isRegisterByteSizeObserverCheap(tuple.f7)
        && t8Coder.isRegisterByteSizeObserverCheap(tuple.f8)
        && t9Coder.isRegisterByteSizeObserverCheap(tuple.f9)
        && t10Coder.isRegisterByteSizeObserverCheap(tuple.f10);
  }

  @Override
  public void registerByteSizeObserver(Tuple11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> tuple,
                                       ElementByteSizeObserver observer) throws Exception {
    if (tuple == null) {
      throw new CoderException("cannot encode a null Tuple11 ");
    }
    t0Coder.registerByteSizeObserver(tuple.f0, observer);
    t1Coder.registerByteSizeObserver(tuple.f1, observer);
    t2Coder.registerByteSizeObserver(tuple.f2, observer);
    t3Coder.registerByteSizeObserver(tuple.f3, observer);
    t4Coder.registerByteSizeObserver(tuple.f4, observer);
    t5Coder.registerByteSizeObserver(tuple.f5, observer);
    t6Coder.registerByteSizeObserver(tuple.f6, observer);
    t7Coder.registerByteSizeObserver(tuple.f7, observer);
    t8Coder.registerByteSizeObserver(tuple.f8, observer);
    t9Coder.registerByteSizeObserver(tuple.f9, observer);
    t10Coder.registerByteSizeObserver(tuple.f10, observer);
  }

  @Override
  public TypeDescriptor<Tuple11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> getEncodedTypeDescriptor() {
    return new TypeDescriptor<Tuple11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>() {}
      .where(new TypeParameter<T0>() {}, t0Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T1>() {}, t1Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T2>() {}, t2Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T3>() {}, t3Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T4>() {}, t4Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T5>() {}, t5Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T6>() {}, t6Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T7>() {}, t7Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T8>() {}, t8Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T9>() {}, t9Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T10>() {}, t10Coder.getEncodedTypeDescriptor());
  }
}
