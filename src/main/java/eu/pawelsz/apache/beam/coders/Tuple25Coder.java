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
import org.apache.flink.api.java.tuple.Tuple25;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class Tuple25Coder<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24> extends StructuredCoder<Tuple25<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24>> {


  public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24> Tuple25Coder<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24> of(
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
      Coder<T10> t10,
      Coder<T11> t11,
      Coder<T12> t12,
      Coder<T13> t13,
      Coder<T14> t14,
      Coder<T15> t15,
      Coder<T16> t16,
      Coder<T17> t17,
      Coder<T18> t18,
      Coder<T19> t19,
      Coder<T20> t20,
      Coder<T21> t21,
      Coder<T22> t22,
      Coder<T23> t23,
      Coder<T24> t24) {
    return new Tuple25Coder<>(t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23, t24);
  }

  public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24> List<Object> getInstanceComponents(
      Tuple25<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24> exampleValue) {
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
        exampleValue.f10,
        exampleValue.f11,
        exampleValue.f12,
        exampleValue.f13,
        exampleValue.f14,
        exampleValue.f15,
        exampleValue.f16,
        exampleValue.f17,
        exampleValue.f18,
        exampleValue.f19,
        exampleValue.f20,
        exampleValue.f21,
        exampleValue.f22,
        exampleValue.f23,
        exampleValue.f24);
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

  public Coder<T11> getF11Coder() {
    return t11Coder;
  }

  public Coder<T12> getF12Coder() {
    return t12Coder;
  }

  public Coder<T13> getF13Coder() {
    return t13Coder;
  }

  public Coder<T14> getF14Coder() {
    return t14Coder;
  }

  public Coder<T15> getF15Coder() {
    return t15Coder;
  }

  public Coder<T16> getF16Coder() {
    return t16Coder;
  }

  public Coder<T17> getF17Coder() {
    return t17Coder;
  }

  public Coder<T18> getF18Coder() {
    return t18Coder;
  }

  public Coder<T19> getF19Coder() {
    return t19Coder;
  }

  public Coder<T20> getF20Coder() {
    return t20Coder;
  }

  public Coder<T21> getF21Coder() {
    return t21Coder;
  }

  public Coder<T22> getF22Coder() {
    return t22Coder;
  }

  public Coder<T23> getF23Coder() {
    return t23Coder;
  }

  public Coder<T24> getF24Coder() {
    return t24Coder;
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
  private final Coder<T11> t11Coder;
  private final Coder<T12> t12Coder;
  private final Coder<T13> t13Coder;
  private final Coder<T14> t14Coder;
  private final Coder<T15> t15Coder;
  private final Coder<T16> t16Coder;
  private final Coder<T17> t17Coder;
  private final Coder<T18> t18Coder;
  private final Coder<T19> t19Coder;
  private final Coder<T20> t20Coder;
  private final Coder<T21> t21Coder;
  private final Coder<T22> t22Coder;
  private final Coder<T23> t23Coder;
  private final Coder<T24> t24Coder;

  private Tuple25Coder(
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
      Coder<T10> t10Coder,
      Coder<T11> t11Coder,
      Coder<T12> t12Coder,
      Coder<T13> t13Coder,
      Coder<T14> t14Coder,
      Coder<T15> t15Coder,
      Coder<T16> t16Coder,
      Coder<T17> t17Coder,
      Coder<T18> t18Coder,
      Coder<T19> t19Coder,
      Coder<T20> t20Coder,
      Coder<T21> t21Coder,
      Coder<T22> t22Coder,
      Coder<T23> t23Coder,
      Coder<T24> t24Coder) {
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
    this.t11Coder = t11Coder;
    this.t12Coder = t12Coder;
    this.t13Coder = t13Coder;
    this.t14Coder = t14Coder;
    this.t15Coder = t15Coder;
    this.t16Coder = t16Coder;
    this.t17Coder = t17Coder;
    this.t18Coder = t18Coder;
    this.t19Coder = t19Coder;
    this.t20Coder = t20Coder;
    this.t21Coder = t21Coder;
    this.t22Coder = t22Coder;
    this.t23Coder = t23Coder;
    this.t24Coder = t24Coder;
  }

  @Override
  public void encode(Tuple25<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24> tuple, OutputStream outStream)
      throws CoderException, IOException {
    if (tuple == null) {
      throw new CoderException("cannot encode a null Tuple25");
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
    t11Coder.encode(tuple.f11, outStream);
    t12Coder.encode(tuple.f12, outStream);
    t13Coder.encode(tuple.f13, outStream);
    t14Coder.encode(tuple.f14, outStream);
    t15Coder.encode(tuple.f15, outStream);
    t16Coder.encode(tuple.f16, outStream);
    t17Coder.encode(tuple.f17, outStream);
    t18Coder.encode(tuple.f18, outStream);
    t19Coder.encode(tuple.f19, outStream);
    t20Coder.encode(tuple.f20, outStream);
    t21Coder.encode(tuple.f21, outStream);
    t22Coder.encode(tuple.f22, outStream);
    t23Coder.encode(tuple.f23, outStream);
    t24Coder.encode(tuple.f24, outStream);
  }

  @Override
  public Tuple25<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24> decode(InputStream inputStream)
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
    T11 f11 = t11Coder.decode(inputStream);
    T12 f12 = t12Coder.decode(inputStream);
    T13 f13 = t13Coder.decode(inputStream);
    T14 f14 = t14Coder.decode(inputStream);
    T15 f15 = t15Coder.decode(inputStream);
    T16 f16 = t16Coder.decode(inputStream);
    T17 f17 = t17Coder.decode(inputStream);
    T18 f18 = t18Coder.decode(inputStream);
    T19 f19 = t19Coder.decode(inputStream);
    T20 f20 = t20Coder.decode(inputStream);
    T21 f21 = t21Coder.decode(inputStream);
    T22 f22 = t22Coder.decode(inputStream);
    T23 f23 = t23Coder.decode(inputStream);
    T24 f24 = t24Coder.decode(inputStream);
    return Tuple25.of(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24);
  }

  @Override
  public List<? extends Coder<?>> getCoderArguments() {
    return Arrays.asList(t0Coder, t1Coder, t2Coder, t3Coder, t4Coder, t5Coder, t6Coder, t7Coder, t8Coder, t9Coder, t10Coder, t11Coder, t12Coder, t13Coder, t14Coder, t15Coder, t16Coder, t17Coder, t18Coder, t19Coder, t20Coder, t21Coder, t22Coder, t23Coder, t24Coder);  }

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
    verifyDeterministic(t11Coder, "Coder of T11 must be deterministic");
    verifyDeterministic(t12Coder, "Coder of T12 must be deterministic");
    verifyDeterministic(t13Coder, "Coder of T13 must be deterministic");
    verifyDeterministic(t14Coder, "Coder of T14 must be deterministic");
    verifyDeterministic(t15Coder, "Coder of T15 must be deterministic");
    verifyDeterministic(t16Coder, "Coder of T16 must be deterministic");
    verifyDeterministic(t17Coder, "Coder of T17 must be deterministic");
    verifyDeterministic(t18Coder, "Coder of T18 must be deterministic");
    verifyDeterministic(t19Coder, "Coder of T19 must be deterministic");
    verifyDeterministic(t20Coder, "Coder of T20 must be deterministic");
    verifyDeterministic(t21Coder, "Coder of T21 must be deterministic");
    verifyDeterministic(t22Coder, "Coder of T22 must be deterministic");
    verifyDeterministic(t23Coder, "Coder of T23 must be deterministic");
    verifyDeterministic(t24Coder, "Coder of T24 must be deterministic");
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
        && t10Coder.consistentWithEquals()
        && t11Coder.consistentWithEquals()
        && t12Coder.consistentWithEquals()
        && t13Coder.consistentWithEquals()
        && t14Coder.consistentWithEquals()
        && t15Coder.consistentWithEquals()
        && t16Coder.consistentWithEquals()
        && t17Coder.consistentWithEquals()
        && t18Coder.consistentWithEquals()
        && t19Coder.consistentWithEquals()
        && t20Coder.consistentWithEquals()
        && t21Coder.consistentWithEquals()
        && t22Coder.consistentWithEquals()
        && t23Coder.consistentWithEquals()
        && t24Coder.consistentWithEquals();
  }

  @Override
  public Object structuralValue(Tuple25<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24> tuple) {
    if (consistentWithEquals()) {
      return tuple;
    } else {
      return Tuple25.of(
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
        t10Coder.structuralValue(tuple.f10),
        t11Coder.structuralValue(tuple.f11),
        t12Coder.structuralValue(tuple.f12),
        t13Coder.structuralValue(tuple.f13),
        t14Coder.structuralValue(tuple.f14),
        t15Coder.structuralValue(tuple.f15),
        t16Coder.structuralValue(tuple.f16),
        t17Coder.structuralValue(tuple.f17),
        t18Coder.structuralValue(tuple.f18),
        t19Coder.structuralValue(tuple.f19),
        t20Coder.structuralValue(tuple.f20),
        t21Coder.structuralValue(tuple.f21),
        t22Coder.structuralValue(tuple.f22),
        t23Coder.structuralValue(tuple.f23),
        t24Coder.structuralValue(tuple.f24));
    }
  }

  @Override
  public boolean isRegisterByteSizeObserverCheap(Tuple25<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24> tuple) {
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
        && t10Coder.isRegisterByteSizeObserverCheap(tuple.f10)
        && t11Coder.isRegisterByteSizeObserverCheap(tuple.f11)
        && t12Coder.isRegisterByteSizeObserverCheap(tuple.f12)
        && t13Coder.isRegisterByteSizeObserverCheap(tuple.f13)
        && t14Coder.isRegisterByteSizeObserverCheap(tuple.f14)
        && t15Coder.isRegisterByteSizeObserverCheap(tuple.f15)
        && t16Coder.isRegisterByteSizeObserverCheap(tuple.f16)
        && t17Coder.isRegisterByteSizeObserverCheap(tuple.f17)
        && t18Coder.isRegisterByteSizeObserverCheap(tuple.f18)
        && t19Coder.isRegisterByteSizeObserverCheap(tuple.f19)
        && t20Coder.isRegisterByteSizeObserverCheap(tuple.f20)
        && t21Coder.isRegisterByteSizeObserverCheap(tuple.f21)
        && t22Coder.isRegisterByteSizeObserverCheap(tuple.f22)
        && t23Coder.isRegisterByteSizeObserverCheap(tuple.f23)
        && t24Coder.isRegisterByteSizeObserverCheap(tuple.f24);
  }

  @Override
  public void registerByteSizeObserver(Tuple25<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24> tuple,
                                       ElementByteSizeObserver observer) throws Exception {
    if (tuple == null) {
      throw new CoderException("cannot encode a null Tuple25 ");
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
    t11Coder.registerByteSizeObserver(tuple.f11, observer);
    t12Coder.registerByteSizeObserver(tuple.f12, observer);
    t13Coder.registerByteSizeObserver(tuple.f13, observer);
    t14Coder.registerByteSizeObserver(tuple.f14, observer);
    t15Coder.registerByteSizeObserver(tuple.f15, observer);
    t16Coder.registerByteSizeObserver(tuple.f16, observer);
    t17Coder.registerByteSizeObserver(tuple.f17, observer);
    t18Coder.registerByteSizeObserver(tuple.f18, observer);
    t19Coder.registerByteSizeObserver(tuple.f19, observer);
    t20Coder.registerByteSizeObserver(tuple.f20, observer);
    t21Coder.registerByteSizeObserver(tuple.f21, observer);
    t22Coder.registerByteSizeObserver(tuple.f22, observer);
    t23Coder.registerByteSizeObserver(tuple.f23, observer);
    t24Coder.registerByteSizeObserver(tuple.f24, observer);
  }

  @Override
  public TypeDescriptor<Tuple25<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24>> getEncodedTypeDescriptor() {
    return new TypeDescriptor<Tuple25<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24>>() {}
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
      .where(new TypeParameter<T10>() {}, t10Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T11>() {}, t11Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T12>() {}, t12Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T13>() {}, t13Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T14>() {}, t14Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T15>() {}, t15Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T16>() {}, t16Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T17>() {}, t17Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T18>() {}, t18Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T19>() {}, t19Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T20>() {}, t20Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T21>() {}, t21Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T22>() {}, t22Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T23>() {}, t23Coder.getEncodedTypeDescriptor())
      .where(new TypeParameter<T24>() {}, t24Coder.getEncodedTypeDescriptor());
  }
}
