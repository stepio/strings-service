package org.stepio.strings.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link ErrorResponse}.
 *
 * @author stepio
 */
public class ErrorResponseTest {

    @Test
    public void getMessage_withBuilder() throws Exception {
        assertThat(ErrorResponse.builder().build().getMessage()).isNull();
        assertThat(ErrorResponse.builder().withMessage("").build().getMessage()).isNotNull().isEmpty();
        assertThat(ErrorResponse.builder().withMessage("bla-bla-bla@42").build().getMessage()).isEqualTo("bla-bla-bla@42");
        assertThat(ErrorResponse.builder().withMessage("Wo-hoo, it's an exception!").build().getMessage()).
                isEqualTo("Wo-hoo, it's an exception!");
    }
}
