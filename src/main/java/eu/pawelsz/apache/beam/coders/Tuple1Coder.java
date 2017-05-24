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
import org.apache.flink.api.java.tuple.Tuple1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class Tuple1Coder<T0> extends StructuredCoder<Tuple1<T0>> {


  public static <T0> Tuple1Coder<T0> of(
      Coder<T0> t0) {
    return new Tuple1Coder<>(t0);
  }

  public static <T0> List<Object> getInstanceComponents(
      Tuple1<T0> exampleValue) {
    return Arrays.asList(
        exampleValue.f0);
  }

  public Coder<T0> getF0Coder() {
    return t0Coder;
  }

  private final Coder<T0> t0Coder;

  private Tuple1Coder(
      Coder<T0> t0Coder) {
    this.t0Coder = t0Coder;
  }

  @Override
  public void encode(Tuple1<T0> tuple, OutputStream outStream)
      throws CoderException, IOException {
    t0Coder.encode(tuple.f0, outStream, Context.NESTED);
  }

  @Override
  public void encode(Tuple1<T0> tuple, OutputStream outStream, Context context)
          throws CoderException, IOException {
    if (tuple == null) {
      throw new CoderException("cannot encode a null Tuple1");
    }
    t0Coder.encode(tuple.f0, outStream, context);
  }

  @Override
  public Tuple1<T0> decode(InputStream inputStream)
      throws CoderException, IOException {
    return decode(inputStream, Context.NESTED);
  }

  @Override
  public Tuple1<T0> decode(InputStream inputStream, Context context)
          throws CoderException, IOException {
    T0 f0 = t0Coder.decode(inputStream, context);
    return Tuple1.of(f0);
  }

  @Override
  public List<? extends Coder<?>> getCoderArguments() {
    return Arrays.asList(t0Coder);  }

  @Override
  public void verifyDeterministic() throws NonDeterministicException {
    verifyDeterministic(t0Coder, "Coder of T0 must be deterministic");
  }

  @Override
  public boolean consistentWithEquals() {
    return t0Coder.consistentWithEquals();
  }

  @Override
  public Object structuralValue(Tuple1<T0> tuple) {
    if (consistentWithEquals()) {
      return tuple;
    } else {
      return Tuple1.of(
        t0Coder.structuralValue(tuple.f0));
    }
  }

  /**
   * Returns whether both keyCoder and valueCoder are considered not expensive.
   */
  @Override
  public boolean isRegisterByteSizeObserverCheap(Tuple1<T0> t) {
    return t0Coder.isRegisterByteSizeObserverCheap(t.f0);
  }

  /**
   * Notifies ElementByteSizeObserver about the byte size of the
   * encoded value using this coder.
   */
  @Override
  public void registerByteSizeObserver(
          Tuple1<T0> t, ElementByteSizeObserver observer)
          throws Exception {
    if (t == null) {
      throw new CoderException("cannot encode a null Tuple2");
    }
    t0Coder.registerByteSizeObserver(t.f0, observer);
  }

  @Override
  public TypeDescriptor<Tuple1<T0>> getEncodedTypeDescriptor() {
    return new TypeDescriptor<Tuple1<T0>>() {}.where(
            new TypeParameter<T0>() {}, t0Coder.getEncodedTypeDescriptor());
  }

}
