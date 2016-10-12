package org.stepio.strings.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;

/**
 * Basic DTO for sorting strings following the needed algorithm.
 *
 * @author stepio
 */
@EqualsAndHashCode
@JsonDeserialize(builder = StringObject.Builder.class)
public class StringObject {

    protected String string;

    protected StringObject() {
    }

    public String getString() {
        return this.string;
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

        protected final StringObject target = new StringObject();

        public Builder withString(final String string) {
            this.target.string = string;
            return this;
        }

        public StringObject build() {
            return this.target;
        }
    }
}
