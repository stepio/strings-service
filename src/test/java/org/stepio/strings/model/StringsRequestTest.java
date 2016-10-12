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
    public void getStrings_withBuilder() throws Exception {
        assertThat(StringsRequest.create(null).getStrings()).isNull();
        List<String> list = Collections.emptyList();
        assertThat(StringsRequest.create(list).getStrings()).isNotNull().isEmpty();
        list = Collections.singletonList("Hello, world!");
        assertThat(StringsRequest.create(list).getStrings()).isEqualTo(list);
        list = new ArrayList<>();
        list.add("See no evil");
        list.add("Hear no evil");
        list.add("Speak no evil");
        assertThat(StringsRequest.create(list).getStrings()).isEqualTo(list);
    }
}
