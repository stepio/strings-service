package org.stepio.strings.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link LongestWordPair}.
 *
 * @author stepio
 */
public class LongestWordPairTest {

    @Test
    public void getString_withConstructor() throws Exception {
        assertThat(new LongestWordPair(null, null).getString()).isNull();
        assertThat(new LongestWordPair("", null).getString()).isNotNull().isEmpty();
        assertThat(new LongestWordPair("bla-bla-bla@42", null).getString()).isEqualTo("bla-bla-bla@42");
        assertThat(new LongestWordPair("I see you", null).getString()).isEqualTo("I see you");
    }

    @Test
    public void getLongestWordString_withConstructor() throws Exception {
        assertThat(new LongestWordPair(null, null).getLongestWordString()).isEqualTo(null);
        assertThat(new LongestWordPair(null, "").getLongestWordString()).isNotNull().isEqualTo("");
        assertThat(new LongestWordPair(null, "hello").getLongestWordString()).isEqualTo("hello");
        assertThat(new LongestWordPair(null, "surprise").getLongestWordString()).isEqualTo("surprise");
        assertThat(new LongestWordPair(null, "You'll").getLongestWordString()).isEqualTo("You'll");
    }

    @Test
    public void getLongestWord_withConstructor() throws Exception {
        assertThat(new LongestWordPair(null, null).getLongestWord()).isEqualTo(0);
        assertThat(new LongestWordPair(null, "").getLongestWord()).isEqualTo(0);
        assertThat(new LongestWordPair(null, "hello").getLongestWord()).isEqualTo(5);
        assertThat(new LongestWordPair(null, "surprise").getLongestWord()).isEqualTo(8);
        assertThat(new LongestWordPair(null, "You'll").getLongestWord()).isEqualTo(6);
        assertThat(new LongestWordPair(null, "WONDERFUL").getLongestWord()).isEqualTo(9);
    }
}
