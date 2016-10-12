package org.stepio.strings.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * DTO for handling errors, allows sending messages to client.
 *
 * @author stepio
 */
@JsonDeserialize(builder = ErrorResponse.Builder.class)
public class ErrorResponse {

    protected String message;

    protected ErrorResponse() {
    }

    public String getMessage() {
        return this.message;
    }

    /**
     * Creates new builder.
     *
     * @return builder
     */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        protected final ErrorResponse target = new ErrorResponse();

        public Builder withMessage(final String message) {
            this.target.message = message;
            return this;
        }

        public ErrorResponse build() {
            return this.target;
        }
    }
}
