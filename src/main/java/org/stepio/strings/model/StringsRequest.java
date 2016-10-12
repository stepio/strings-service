package org.stepio.strings.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * DTO for retrieving strings from POST request.
 *
 * @author stepio
 */
public class StringsRequest {

    protected List<String> strings;

    protected StringsRequest() {
    }

    public List<String> getStrings() {
        return this.strings;
    }

    /**
     * Creates new instance.
     */
    @JsonCreator
    public static StringsRequest create(@JsonProperty("strings") final List<String> strings) {
        StringsRequest request = new StringsRequest();
        request.strings = strings;
        return request;
    }
}
