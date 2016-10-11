package org.stepio.strings.model;

import java.util.List;

/**
 * DTO for retrieving strings from POST request.
 *
 * @author stepio
 */
public class StringsRequest {

    protected List<String> strings;

    public List<String> getStrings() {
        return this.strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}
