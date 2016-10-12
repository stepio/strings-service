package org.stepio.strings.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link StringObject}.
 *
 * @author stepio
 */
public class StringObjectTest {

    @Test
    public void getString_withBuilder() throws Exception {
        assertThat(StringObject.builder().build().getString()).isNull();
        assertThat(StringObject.builder().withString("").build().getString()).isNotNull().isEmpty();
        assertThat(StringObject.builder().withString("bla-bla-bla@42").build().getString()).isEqualTo("bla-bla-bla@42");
        assertThat(StringObject.builder().withString("Who's afraid of big bad wolf?").build().getString()).isEqualTo("Who's afraid of big bad wolf?");
    }
}
