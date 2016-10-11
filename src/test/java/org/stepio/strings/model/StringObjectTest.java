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
    public void getString_withConstructor() throws Exception {
        assertThat(new StringObject(null).getString()).isNull();
        assertThat(new StringObject("").getString()).isNotNull().isEmpty();
        assertThat(new StringObject("bla-bla-bla@42").getString()).isEqualTo("bla-bla-bla@42");
        assertThat(new StringObject("Who's afraid of big bad wolf?").getString()).isEqualTo("Who's afraid of big bad wolf?");
    }
}
