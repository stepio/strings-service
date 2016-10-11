package org.stepio.strings.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * DTO for sorting strings according to the longest word in the string.
 *
 * @author stepio
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LongestWordPair extends StringObject {

    @JsonIgnore
    protected String longestWordString;
    protected int longestWord;

    public LongestWordPair(String string, String longestWordString) {
        super(string);
        this.longestWordString = longestWordString;
        if (this.longestWordString != null) {
            this.longestWord = this.longestWordString.length();
        }
    }

    public String getLongestWordString() {
        return this.longestWordString;
    }

    public int getLongestWord() {
        return this.longestWord;
    }
}
