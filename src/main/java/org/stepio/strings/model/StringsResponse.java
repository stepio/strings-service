package org.stepio.strings.model;

import java.util.List;

/**
 * DTO for returning the sorted strings to client.
 *
 * @author stepio
 */
public class StringsResponse {

    protected List<? extends StringObject> result;

    public StringsResponse (final List<? extends StringObject> result) {
        this.result = result;
    }

    public List<? extends StringObject> getStrings() {
        return this.result;
    }
}
