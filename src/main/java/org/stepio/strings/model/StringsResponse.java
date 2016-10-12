package org.stepio.strings.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO for returning the sorted strings to client.
 *
 * @author stepio
 */
public class StringsResponse<T extends StringObject> {

    protected List<T> result;

    protected StringsResponse() {
        this.result = new ArrayList<>();
    }

    public List<T> getResult() {
        return this.result;
    }

    /**
     * Creates new instance.
     */
    @JsonCreator
    public static <T extends StringObject> StringsResponse<T> create(@JsonProperty("result") final List<T> result) {
        StringsResponse<T> response = new StringsResponse<>();
        response.result = result;
        return response;
    }
}
