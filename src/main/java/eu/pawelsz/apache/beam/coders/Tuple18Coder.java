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
import org.apache.flink.api.java.tuple.Tuple18;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class Tuple18Coder<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> extends StandardCoder<Tuple18<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>> {


  public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> Tuple18Coder<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> of(
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
      Coder<T17> t17) {
    return new Tuple18Coder<>(t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17);
  }

  @JsonCreator
  public static Tuple18Coder<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> of(
      @JsonProperty(PropertyNames.COMPONENT_ENCODINGS)
          List<Coder<?>> components) {
    Preconditions.checkArgument(components.size() == 18,
        "Expecting 18 components, got" + components.size());
    return of(
        components.get(0),
        components.get(1),
        components.get(2),
        components.get(3),
        components.get(4),
        components.get(5),
        components.get(6),
        components.get(7),
        components.get(8),
        components.get(9),
        components.get(10),
        components.get(11),
        components.get(12),
        components.get(13),
        components.get(14),
        components.get(15),
        components.get(16),
        components.get(17));
  }

  public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> List<Object> getInstanceComponents(
      Tuple18<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> exampleValue) {
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
        exampleValue.f17);
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

  private Tuple18Coder(
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
      Coder<T17> t17Coder) {
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
  }

  @Override
  public void encode(Tuple18<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> tuple, OutputStream outputStream, Context context)
      throws CoderException, IOException {
    if (tuple == null) {
      throw new CoderException("cannot encode a null Tuple18");
    }
    Context nestedContext = context.nested();
    t0Coder.encode(tuple.f0, outputStream, nestedContext);
    t1Coder.encode(tuple.f1, outputStream, nestedContext);
    t2Coder.encode(tuple.f2, outputStream, nestedContext);
    t3Coder.encode(tuple.f3, outputStream, nestedContext);
    t4Coder.encode(tuple.f4, outputStream, nestedContext);
    t5Coder.encode(tuple.f5, outputStream, nestedContext);
    t6Coder.encode(tuple.f6, outputStream, nestedContext);
    t7Coder.encode(tuple.f7, outputStream, nestedContext);
    t8Coder.encode(tuple.f8, outputStream, nestedContext);
    t9Coder.encode(tuple.f9, outputStream, nestedContext);
    t10Coder.encode(tuple.f10, outputStream, nestedContext);
    t11Coder.encode(tuple.f11, outputStream, nestedContext);
    t12Coder.encode(tuple.f12, outputStream, nestedContext);
    t13Coder.encode(tuple.f13, outputStream, nestedContext);
    t14Coder.encode(tuple.f14, outputStream, nestedContext);
    t15Coder.encode(tuple.f15, outputStream, nestedContext);
    t16Coder.encode(tuple.f16, outputStream, nestedContext);
    t17Coder.encode(tuple.f17, outputStream, nestedContext);
  }

  @Override
  public Tuple18<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> decode(InputStream inputStream, Context context)
      throws CoderException, IOException {
    Context nestedContext = context.nested();
    T0 f0 = t0Coder.decode(inputStream, nestedContext);
    T1 f1 = t1Coder.decode(inputStream, nestedContext);
    T2 f2 = t2Coder.decode(inputStream, nestedContext);
    T3 f3 = t3Coder.decode(inputStream, nestedContext);
    T4 f4 = t4Coder.decode(inputStream, nestedContext);
    T5 f5 = t5Coder.decode(inputStream, nestedContext);
    T6 f6 = t6Coder.decode(inputStream, nestedContext);
    T7 f7 = t7Coder.decode(inputStream, nestedContext);
    T8 f8 = t8Coder.decode(inputStream, nestedContext);
    T9 f9 = t9Coder.decode(inputStream, nestedContext);
    T10 f10 = t10Coder.decode(inputStream, nestedContext);
    T11 f11 = t11Coder.decode(inputStream, nestedContext);
    T12 f12 = t12Coder.decode(inputStream, nestedContext);
    T13 f13 = t13Coder.decode(inputStream, nestedContext);
    T14 f14 = t14Coder.decode(inputStream, nestedContext);
    T15 f15 = t15Coder.decode(inputStream, nestedContext);
    T16 f16 = t16Coder.decode(inputStream, nestedContext);
    T17 f17 = t17Coder.decode(inputStream, nestedContext);
    return Tuple18.of(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17);
  }

  @Override
  public List<? extends Coder<?>> getCoderArguments() {
    return Arrays.asList(t0Coder, t1Coder, t2Coder, t3Coder, t4Coder, t5Coder, t6Coder, t7Coder, t8Coder, t9Coder, t10Coder, t11Coder, t12Coder, t13Coder, t14Coder, t15Coder, t16Coder, t17Coder);  }

  @Override
  public void verifyDeterministic() throws NonDeterministicException {
    verifyDeterministic("Coders must be deterministic", t0Coder, t1Coder, t2Coder, t3Coder, t4Coder, t5Coder, t6Coder, t7Coder, t8Coder, t9Coder, t10Coder, t11Coder, t12Coder, t13Coder, t14Coder, t15Coder, t16Coder, t17Coder);
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
        && t17Coder.consistentWithEquals();
  }

  @Override
  public Object structuralValue(Tuple18<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> tuple) throws Exception {
    if (consistentWithEquals()) {
      return tuple;
    } else {
      return Tuple18.of(
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
        t17Coder.structuralValue(tuple.f17));
    }
  }

  @Override
  public boolean isRegisterByteSizeObserverCheap(Tuple18<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> tuple, Context context) {
    return t0Coder.isRegisterByteSizeObserverCheap(tuple.f0, context.nested())
        && t1Coder.isRegisterByteSizeObserverCheap(tuple.f1, context.nested())
        && t2Coder.isRegisterByteSizeObserverCheap(tuple.f2, context.nested())
        && t3Coder.isRegisterByteSizeObserverCheap(tuple.f3, context.nested())
        && t4Coder.isRegisterByteSizeObserverCheap(tuple.f4, context.nested())
        && t5Coder.isRegisterByteSizeObserverCheap(tuple.f5, context.nested())
        && t6Coder.isRegisterByteSizeObserverCheap(tuple.f6, context.nested())
        && t7Coder.isRegisterByteSizeObserverCheap(tuple.f7, context.nested())
        && t8Coder.isRegisterByteSizeObserverCheap(tuple.f8, context.nested())
        && t9Coder.isRegisterByteSizeObserverCheap(tuple.f9, context.nested())
        && t10Coder.isRegisterByteSizeObserverCheap(tuple.f10, context.nested())
        && t11Coder.isRegisterByteSizeObserverCheap(tuple.f11, context.nested())
        && t12Coder.isRegisterByteSizeObserverCheap(tuple.f12, context.nested())
        && t13Coder.isRegisterByteSizeObserverCheap(tuple.f13, context.nested())
        && t14Coder.isRegisterByteSizeObserverCheap(tuple.f14, context.nested())
        && t15Coder.isRegisterByteSizeObserverCheap(tuple.f15, context.nested())
        && t16Coder.isRegisterByteSizeObserverCheap(tuple.f16, context.nested())
        && t17Coder.isRegisterByteSizeObserverCheap(tuple.f17, context.nested());
  }

  @Override
  public void registerByteSizeObserver(Tuple18<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> tuple,
                                       ElementByteSizeObserver observer,
                                       Context context) throws Exception {
    if (tuple == null) {
      throw new CoderException("cannot encode a null Tuple18 ");
    }
    Context nestedContext = context.nested();
    t0Coder.registerByteSizeObserver(tuple.f0, observer, nestedContext);
    t1Coder.registerByteSizeObserver(tuple.f1, observer, nestedContext);
    t2Coder.registerByteSizeObserver(tuple.f2, observer, nestedContext);
    t3Coder.registerByteSizeObserver(tuple.f3, observer, nestedContext);
    t4Coder.registerByteSizeObserver(tuple.f4, observer, nestedContext);
    t5Coder.registerByteSizeObserver(tuple.f5, observer, nestedContext);
    t6Coder.registerByteSizeObserver(tuple.f6, observer, nestedContext);
    t7Coder.registerByteSizeObserver(tuple.f7, observer, nestedContext);
    t8Coder.registerByteSizeObserver(tuple.f8, observer, nestedContext);
    t9Coder.registerByteSizeObserver(tuple.f9, observer, nestedContext);
    t10Coder.registerByteSizeObserver(tuple.f10, observer, nestedContext);
    t11Coder.registerByteSizeObserver(tuple.f11, observer, nestedContext);
    t12Coder.registerByteSizeObserver(tuple.f12, observer, nestedContext);
    t13Coder.registerByteSizeObserver(tuple.f13, observer, nestedContext);
    t14Coder.registerByteSizeObserver(tuple.f14, observer, nestedContext);
    t15Coder.registerByteSizeObserver(tuple.f15, observer, nestedContext);
    t16Coder.registerByteSizeObserver(tuple.f16, observer, nestedContext);
    t17Coder.registerByteSizeObserver(tuple.f17, observer, nestedContext);
  }
}
