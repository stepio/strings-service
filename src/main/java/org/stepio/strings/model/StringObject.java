package org.stepio.strings.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Basic DTO for sorting strings following the needed algorithm.
 *
 * @author stepio
 */
@EqualsAndHashCode
@ToString
public class StringObject {

    protected String string;

    public StringObject(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}
