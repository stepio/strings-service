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
    public void getString_withBuilder() throws Exception {
        assertThat(LongestWordPair.builder().build().getString()).isNull();
        assertThat(LongestWordPair.builder().withString("").build().getString()).isNotNull().isEmpty();
        assertThat(LongestWordPair.builder().withString("bla-bla-bla@42").build().getString()).isEqualTo("bla-bla-bla@42");
        assertThat(LongestWordPair.builder().withString("I see you").build().getString()).isEqualTo("I see you");
    }

    @Test
    public void getLongestWordString_withBuilder() throws Exception {
        assertThat(LongestWordPair.builder().build().getLongestWordString()).isNull();
        assertThat(LongestWordPair.builder().withLongestWordString("").build().getLongestWordString()).isNotNull().isEmpty();
        assertThat(LongestWordPair.builder().withLongestWordString("hello").build().getLongestWordString()).isEqualTo("hello");
        assertThat(LongestWordPair.builder().withLongestWordString("surprise").build().getLongestWordString()).isEqualTo("surprise");
        assertThat(LongestWordPair.builder().withLongestWordString("You'll").build().getLongestWordString()).isEqualTo("You'll");
    }

    @Test
    public void getLongestWord_withBuilder() throws Exception {
        assertThat(LongestWordPair.builder().build().getLongestWord()).isEqualTo(0);
        assertThat(LongestWordPair.builder().withLongestWord(0).build().getLongestWord()).isEqualTo(0);
        assertThat(LongestWordPair.builder().withLongestWord(5).build().getLongestWord()).isEqualTo(5);
        assertThat(LongestWordPair.builder().withLongestWord(8).build().getLongestWord()).isEqualTo(8);
        assertThat(LongestWordPair.builder().withLongestWord(6).build().getLongestWord()).isEqualTo(6);
    }
}
