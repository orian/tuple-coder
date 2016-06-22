package eu.pawelsz.apache.beam.coders;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import org.apache.beam.sdk.coders.*;
import org.apache.beam.sdk.testing.CoderProperties;
import org.apache.beam.sdk.util.CoderUtils;
import org.apache.flink.api.java.tuple.Tuple2;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(JUnit4.class)
public class Tuple2CoderTest {

  @Test
  public void TestSimple() throws Coder.NonDeterministicException, IOException {
    ByteString bs = ByteString.copyFromUtf8("863071015131755-WiFi");
    ByteString bs2 = ByteString.copyFromUtf8("863071015131755-WiFi");

    Long l1 = 1462665600000000L;
    Long l2 = 1463184000000000L;
    Long l3 = 1462665600000000L;
    Long l4 = 1463184000000000L;
    Tuple2 t1 = Tuple2.of(bs, l1);
    Tuple2 t2 = Tuple2.of(bs, l2);
    Tuple2 t3 = Tuple2.of(bs2, l3);
    Tuple2 t4 = Tuple2.of(bs2, l4);

    assertEquals(t1, t1);

    assertEquals(t1, t3);
    assertEquals(t3, t1);

    assertEquals(t2, t4);

    Tuple2Coder<ByteString, Long> coder = Tuple2Coder.of(ByteStringCoder.of(), VarLongCoder.of());
    assertTrue(coder.consistentWithEquals());
    coder.verifyDeterministic();

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    coder.encode(t1, bos, Coder.Context.OUTER);
    byte[] t1enc = bos.toByteArray();
    Tuple2<ByteString, Long> t1tmp = coder.decode(
        new ByteArrayInputStream(t1enc), Coder.Context.OUTER);
    assertEquals(t1, t1tmp);

    bos.reset();
    coder.encode(t3, bos, Coder.Context.OUTER);
    byte[] t3enc = bos.toByteArray();
    assertTrue(Arrays.equals(t1enc, t3enc));
    assertEquals(t1.hashCode(), t3.hashCode());
    assertEquals(t2.hashCode(), t4.hashCode());

    assertNotNull(Tuple2Coder.of(
        Lists.newArrayList((Coder)VarIntCoder.of(), (Coder)ByteStringCoder.of())));
  }

  private static final Map<Coder<?>, Iterable<?>> TEST_DATA =
      new ImmutableMap.Builder<Coder<?>, Iterable<?>>()
          .put(VarIntCoder.of(),
              Arrays.asList(-1, 0, 1, 13, Integer.MAX_VALUE, Integer.MIN_VALUE))
          .put(BigEndianLongCoder.of(),
              Arrays.asList(-1L, 0L, 1L, 13L, Long.MAX_VALUE, Long.MIN_VALUE))
          .put(StringUtf8Coder.of(),
              Arrays.asList("", "hello", "goodbye", "1"))
          .put(Tuple2Coder.of(StringUtf8Coder.of(), VarIntCoder.of()),
              Arrays.asList(
                  Tuple2.of("", -1),
                  Tuple2.of("hello", 0),
                  Tuple2.of("goodbye", Integer.MAX_VALUE)))
          .put(ListCoder.of(VarLongCoder.of()),
              Arrays.asList(
                  Arrays.asList(1L, 2L, 3L),
                  Collections.emptyList()))
          .build();

  @Test
  public void testDecodeEncodeEqual() throws Exception {
    for (Map.Entry<Coder<?>, Iterable<?>> entry : TEST_DATA.entrySet()) {
      // The coder and corresponding values must be the same type.
      // If someone messes this up in the above test data, the test
      // will fail anyhow (unless the coder magically works on data
      // it does not understand).
      @SuppressWarnings("unchecked")
      Coder<Object> coder = (Coder<Object>) entry.getKey();
      Iterable<?> values = entry.getValue();
      for (Object value : values) {
        CoderProperties.coderDecodeEncodeEqual(coder, value);
      }
    }
  }

  // If this changes, it implies the binary format has changed!
  private static final String EXPECTED_ENCODING_ID = "";

  @Test
  public void testEncodingId() throws Exception {
    CoderProperties.coderHasEncodingId(
        Tuple2Coder.of(VarIntCoder.of(), VarIntCoder.of()),
        EXPECTED_ENCODING_ID);
  }

  /**
   * Homogeneously typed test value for ease of use with the wire format test utility.
   */
  private static final Coder<Tuple2<String, Integer>> TEST_CODER =
      Tuple2Coder.of(StringUtf8Coder.of(), VarIntCoder.of());

  private static final List<Tuple2<String, Integer>> TEST_VALUES = Arrays.asList(
      Tuple2.of("", -1),
      Tuple2.of("hello", 0),
      Tuple2.of("goodbye", Integer.MAX_VALUE));

  /**
   * Generated data to check that the wire format has not changed. To regenerate, see
   * {@link org.apache.beam.sdk.coders.PrintBase64Encodings}.
   */
  private static final List<String> TEST_ENCODINGS = Arrays.asList(
      "AP____8P",
      "BWhlbGxvAA",
      "B2dvb2RieWX_____Bw");

  @Test
  public void testWireFormatEncode() throws Exception {
    CoderProperties.coderEncodesBase64(TEST_CODER, TEST_VALUES, TEST_ENCODINGS);
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void encodeNullThrowsCoderException() throws Exception {
    thrown.expect(CoderException.class);
    thrown.expectMessage("cannot encode a null Tuple2");

    CoderUtils.encodeToBase64(TEST_CODER, null);
  }
}
