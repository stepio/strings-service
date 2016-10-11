package org.stepio.strings.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link StringsRequest}.
 *
 * @author stepio
 */
public class StringsRequestTest {

    @Test
    public void getStrings_withSetter() throws Exception {
        StringsRequest request = new StringsRequest();
        assertThat(request.getStrings()).isNull();
        request.setStrings(null);
        assertThat(request.getStrings()).isNull();
        request.setStrings(Collections.emptyList());
        assertThat(request.getStrings()).isNotNull().isEmpty();
        request.setStrings(Collections.singletonList("Hello, world!"));
        assertThat(request.getStrings()).isEqualTo(Collections.singletonList("Hello, world!"));
        List<String> list = new ArrayList<>();
        list.add("See no evil");
        list.add("Hear no evil");
        list.add("Speak no evil");
        request.setStrings(list);
        assertThat(request.getStrings()).isEqualTo(list);
    }
}

