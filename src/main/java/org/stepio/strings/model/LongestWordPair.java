package org.stepio.strings.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;

/**
 * DTO for sorting strings according to the longest word in the string.
 *
 * @author stepio
 */
@EqualsAndHashCode(callSuper = true)
@JsonDeserialize(builder = LongestWordPair.Builder.class)
public class LongestWordPair extends StringObject {

    @JsonIgnore
    protected String longestWordString;
    protected int longestWord;

    protected LongestWordPair() {
    }

    public String getLongestWordString() {
        return this.longestWordString;
    }

    public int getLongestWord() {
        return this.longestWord;
    }

    /**
     * Creates new builder.
     *
     * @return builder
     */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends StringObject.Builder {

        protected final LongestWordPair target = new LongestWordPair();

        public Builder withString(final String string) {
            this.target.string = string;
            return this;
        }

        public Builder withLongestWordString(final String longestWordString) {
            this.target.longestWordString = longestWordString;
            return this;
        }

        public Builder withLongestWord(final int longestWord) {
            this.target.longestWord = longestWord;
            return this;
        }

        public LongestWordPair build() {
            return this.target;
        }
    }
}
