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
    public void getMessage_withConstructor() throws Exception {
        assertThat(new ErrorResponse(null).getMessage()).isNull();
        assertThat(new ErrorResponse("").getMessage()).isNotNull().isEmpty();
        assertThat(new ErrorResponse("bla-bla-bla@42").getMessage()).isEqualTo("bla-bla-bla@42");
        assertThat(new ErrorResponse("Wo-hoo, it's an exception!").getMessage()).isEqualTo("Wo-hoo, it's an exception!");
    }
}
