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

package eu.pawelsz.apache.beam.coders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Source code generator for tuple classes and classes which depend on the arity of tuples.
 */
class TupleCoderGenerator {

  // Parameters for tuple classes

  private static final String ROOT_DIRECTORY = "./src/main/java/";

  private static final String PACKAGE = "eu.pawelsz.apache.beam.coders";

  private static final String BUILDER_SUFFIX = "builder";

  private static final String GEN_TYPE_PREFIX = "T";

  // min. and max. tuple arity
  private static final int FIRST = 1;

  private static final int LAST = 3;


  public static void main(String[] args) throws Exception {
    System.err.println("Current directory " + System.getProperty("user.dir"));
    String rootDir = ROOT_DIRECTORY;
    if (args.length > 0) {
      rootDir = args[0] + "/" + ROOT_DIRECTORY;
    }
    System.err.println("Using root directory: " + rootDir);
    File root = new File(rootDir);

    createTupleClasses(root);
  }

  private static File getPackage(File root, String packageString) {
    File dir = new File(root, packageString.replace('.', '/'));
    if (!dir.exists() && dir.isDirectory()) {
      System.err.println("None existent directory: " + dir.getAbsolutePath());
      System.exit(1);
    }
    return dir;
  }

  private static void createTupleClasses(File root) throws FileNotFoundException {
    File dir = getPackage(root, PACKAGE);

    PrintWriter writer = null;
    for (int i = FIRST; i <= LAST; i++) {
//    for (int i = 4; i <= 4; i++) {
      File tupleFile = new File(dir, "Tuple" + i + "Coder.java");
      writer = new PrintWriter(tupleFile);
      writeTupleCoderClass(writer, i);
      writer.flush();
      writer.close();
    }

    File f = new File(dir, "RegisterTupleCoders.java");
    writer = new PrintWriter(f);
    writeRegistration(writer);
    writer.flush();
    writer.close();
  }

  private static void writeTupleCoderClass(PrintWriter w, int numFields) {
    final String tupleClass = "Tuple" + numFields;
    final String className = tupleClass + "Coder";

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numFields; i++) {
      if (i > 0) {
        sb.append(", ");
      }
      sb.append(GEN_TYPE_PREFIX + i);
    }
    final String types = sb.toString();
    final int maxIdx = numFields - 1;

    // head
    w.print(HEADER);

    // package and imports
    w.println("package " + PACKAGE + ';');
    w.println();
    w.println("import org.apache.beam.sdk.coders.Coder;");
    w.println("import org.apache.beam.sdk.coders.CoderException;");
    w.println("import org.apache.beam.sdk.coders.StructuredCoder;");
    w.println("import org.apache.flink.api.java.tuple." + tupleClass + ";");
    w.println("");
    w.println("import java.io.IOException;");
    w.println("import java.io.InputStream;");
    w.println("import java.io.OutputStream;");
    w.println("import java.util.Arrays;");
    w.println("import java.util.List;");
    w.println("");
    w.println("public class " + className + "<" + types + "> extends StructuredCoder<" + tupleClass
        + "<" + types + ">> {");
    w.println();
    w.println("");
    w.println("  public static <" + types + "> " + className + "<" + types + "> of(");
    for (int i = 0; i < numFields - 1; i++) {
      w.println("      Coder<" + GEN_TYPE_PREFIX + i + "> t" + i + ",");
    }
    w.println("      Coder<" + GEN_TYPE_PREFIX + maxIdx + "> t" + maxIdx + ") {");

    w.print("    return new " + className + "<>(");
    for (int i = 0; i < numFields; i++) {
      if (i > 0) {
        w.print(", ");
      }
      w.print("t" + i);
    }
    w.println(");");
    w.println("  }");
    w.println("");
    w.println("  public static <" + types + "> List<Object> getInstanceComponents(");
    w.println("      " + tupleClass + "<" + types + "> exampleValue) {");
    w.println("    return Arrays.asList(");
    for (int i = 0; i < numFields; i++) {
      if (i > 0) {
        w.println(",");
      }
      w.print("        exampleValue.f" + i);
    }
    w.println(");");
    w.println("  }");
    for (int i = 0; i < numFields; i++) {
      w.println("");
      w.println("  public Coder<" + GEN_TYPE_PREFIX + i + "> getF" + i + "Coder() {");
      w.println("    return t" + i + "Coder;");
      w.println("  }");
    }
    w.println("");
    for (int i = 0; i < numFields; i++) {
      w.println("  private final Coder<" + GEN_TYPE_PREFIX + i + "> t" + i + "Coder;");
    }
    w.println("");

    w.println("  private " + className + "(");
    for (int i = 0; i < numFields; i++) {
      if (i > 0) {
        w.println(",");
      }
      w.print("      Coder<" + GEN_TYPE_PREFIX + i + "> t" + i + "Coder");
    }
    w.println(") {");
    for (int i = 0; i < numFields; i++) {
      w.println("    this.t" + i + "Coder = t" + i + "Coder;");
    }
    w.println("  }");
    w.println("");
    w.println("  @Override");
    w.println("  public void encode(" + tupleClass + "<" + types + "> tuple, OutputStream outStream)");
    w.println("      throws CoderException, IOException {");
    w.println("    if (tuple == null) {");
    w.println("      throw new CoderException(\"cannot encode a null " + tupleClass + "\");");
    w.println("    }");
    for (int i = 0; i < numFields; i++) {
      w.println("    t" + i + "Coder.encode(tuple.f" + i + ", outStream);");
    }
    w.println("  }");
    w.println("");
    w.println("  @Override");
    w.println("  public " + tupleClass + "<" + types + "> decode(InputStream inputStream)");
    w.println("      throws CoderException, IOException {");
    for (int i = 0; i < numFields; i++) {
      w.println("    " + GEN_TYPE_PREFIX + i + " f" + i + " = t" + i + "Coder.decode(inputStream);");
    }
    w.print("    return " + tupleClass + ".of(");
    for (int i = 0; i < numFields; i++) {
      if (i > 0) {
        w.print(", ");
      }
      w.print("f" + i);
    }
    w.println(");");
    w.println("  }");
    w.println("");
    w.println("  @Override");
    w.println("  public List<? extends Coder<?>> getCoderArguments() {");
    w.print("    return Arrays.asList(");
    for (int i = 0; i < numFields; i++) {
      if (i > 0) {
        w.print(", ");
      }
      w.print("t" + i + "Coder");
    }
    w.print(");");
    w.println("  }");
    w.println("");
    w.println("  @Override");
    w.println("  public void verifyDeterministic() throws NonDeterministicException {");
    for (int i = 0; i < numFields; i++) {
      w.println("    verifyDeterministic(t"+i+"Coder, \"Coder of T" + i + " must be deterministic\");");
    }
    w.println("  }");
    w.println("");
    w.println("  @Override");
    w.println("  public boolean consistentWithEquals() {");
    w.print("    return");
    for (int i = 0; i < numFields; i++) {
      if (i > 0) {
        w.print("\n        &&");
      }
      w.print(" t" + i + "Coder.consistentWithEquals()");
    }
    w.println(";");
    w.println("  }");
    w.println("");
    w.println("  @Override");
    w.println("  public Object structuralValue(" + tupleClass + "<" + types + "> tuple) {");
    w.println("    if (consistentWithEquals()) {");
    w.println("      return tuple;");
    w.println("    } else {");
    w.println("      return " + tupleClass + ".of(");
    for (int i = 0; i < numFields; i++) {
      if (i > 0) {
        w.println(",");
      }
      w.print("        t" + i + "Coder.structuralValue(tuple.f" + i + ")");
    }
    w.println(");");
    w.println("    }");
    w.println("  }");
    w.println("");
    w.println("}");
  }

  private static void writeRegistration(PrintWriter w) {
    w.print(HEADER);

    w.println("package " + PACKAGE + ";");
    w.println("");
    w.println("import org.apache.beam.sdk.Pipeline;");
    w.println("import org.apache.beam.sdk.coders.CoderProviders;");
    w.println("import org.apache.beam.sdk.coders.CoderRegistry;");
    for (int i = FIRST; i < LAST; i++) {
      w.println("import org.apache.flink.api.java.tuple.Tuple" + i + ";");
    }
    w.println("");
    w.println("public class RegisterTupleCoders {");
    w.println("    public static void run(Pipeline p) {");
    w.println("        CoderRegistry cr = p.getCoderRegistry();");
    for (int i = FIRST; i < LAST; i++) {
      w.println("        cr.registerCoderProvider(CoderProviders.fromStaticMethods(Tuple"+i+".class, Tuple"+i+"Coder.class));");
    }
    w.println("    }");
    w.println("}");
    w.println("");
  }

  private static String HEADER =
      "/*\n"
          + " * Licensed to the Apache Software Foundation (ASF) under one\n"
          + " * or more contributor license agreements.  See the NOTICE file\n"
          + " * distributed with this work for additional information\n"
          + " * regarding copyright ownership.  The ASF licenses this file\n"
          + " * to you under the Apache License, Version 2.0 (the\n"
          + " * \"License\"); you may not use this file except in compliance\n"
          + " * with the License.  You may obtain a copy of the License at\n"
          + " *\n"
          + " *     http://www.apache.org/licenses/LICENSE-2.0\n"
          + " *\n"
          + " * Unless required by applicable law or agreed to in writing, software\n"
          + " * distributed under the License is distributed on an \"AS IS\" BASIS,\n"
          + " * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
          + " * See the License for the specific language governing permissions and\n"
          + " * limitations under the License.\n"
          + " */" +
          "\n" +
          "\n" +
          "\n" +
          "// --------------------------------------------------------------\n" +
          "//  THIS IS A GENERATED SOURCE FILE. DO NOT EDIT!\n" +
          "//  GENERATED FROM " + TupleCoderGenerator.class.getName() + ".\n" +
          "// --------------------------------------------------------------\n\n\n";
}
