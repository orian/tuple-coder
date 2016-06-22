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

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.CoderRegistry;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.api.java.tuple.Tuple5;
import org.apache.flink.api.java.tuple.Tuple6;
import org.apache.flink.api.java.tuple.Tuple7;
import org.apache.flink.api.java.tuple.Tuple8;
import org.apache.flink.api.java.tuple.Tuple9;
import org.apache.flink.api.java.tuple.Tuple10;
import org.apache.flink.api.java.tuple.Tuple11;
import org.apache.flink.api.java.tuple.Tuple12;
import org.apache.flink.api.java.tuple.Tuple13;
import org.apache.flink.api.java.tuple.Tuple14;
import org.apache.flink.api.java.tuple.Tuple15;
import org.apache.flink.api.java.tuple.Tuple16;
import org.apache.flink.api.java.tuple.Tuple17;
import org.apache.flink.api.java.tuple.Tuple18;
import org.apache.flink.api.java.tuple.Tuple19;
import org.apache.flink.api.java.tuple.Tuple20;
import org.apache.flink.api.java.tuple.Tuple21;
import org.apache.flink.api.java.tuple.Tuple22;
import org.apache.flink.api.java.tuple.Tuple23;
import org.apache.flink.api.java.tuple.Tuple24;

public class RegisterTupleCoders {
    public static void run(Pipeline p) {
        CoderRegistry cr = p.getCoderRegistry();
        cr.registerCoder(Tuple1.class, Tuple1Coder.class);
        cr.registerCoder(Tuple2.class, Tuple2Coder.class);
        cr.registerCoder(Tuple3.class, Tuple3Coder.class);
        cr.registerCoder(Tuple4.class, Tuple4Coder.class);
        cr.registerCoder(Tuple5.class, Tuple5Coder.class);
        cr.registerCoder(Tuple6.class, Tuple6Coder.class);
        cr.registerCoder(Tuple7.class, Tuple7Coder.class);
        cr.registerCoder(Tuple8.class, Tuple8Coder.class);
        cr.registerCoder(Tuple9.class, Tuple9Coder.class);
        cr.registerCoder(Tuple10.class, Tuple10Coder.class);
        cr.registerCoder(Tuple11.class, Tuple11Coder.class);
        cr.registerCoder(Tuple12.class, Tuple12Coder.class);
        cr.registerCoder(Tuple13.class, Tuple13Coder.class);
        cr.registerCoder(Tuple14.class, Tuple14Coder.class);
        cr.registerCoder(Tuple15.class, Tuple15Coder.class);
        cr.registerCoder(Tuple16.class, Tuple16Coder.class);
        cr.registerCoder(Tuple17.class, Tuple17Coder.class);
        cr.registerCoder(Tuple18.class, Tuple18Coder.class);
        cr.registerCoder(Tuple19.class, Tuple19Coder.class);
        cr.registerCoder(Tuple20.class, Tuple20Coder.class);
        cr.registerCoder(Tuple21.class, Tuple21Coder.class);
        cr.registerCoder(Tuple22.class, Tuple22Coder.class);
        cr.registerCoder(Tuple23.class, Tuple23Coder.class);
        cr.registerCoder(Tuple24.class, Tuple24Coder.class);
    }
}

