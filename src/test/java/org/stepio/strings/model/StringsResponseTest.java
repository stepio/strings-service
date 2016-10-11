package org.stepio.strings.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link StringsResponse}.
 *
 * @author stepio
 */
public class StringsResponseTest {

    @Test
    public void getStrings_withConstructor() throws Exception {
        assertThat(new StringsResponse(null).getStrings()).isNull();
        assertThat(new StringsResponse(Collections.emptyList()).getStrings()).isNotNull().isEmpty();
        assertThat(new StringsResponse(Collections.singletonList(new StringObject("Hello, world!"))).getStrings())
                .isEqualTo(Collections.singletonList(new StringObject("Hello, world!")));
        List<StringObject> list = new ArrayList<>();
        list.add(new StringObject("See no evil"));
        list.add(new StringObject("Hear no evil"));
        list.add(new StringObject("Speak no evil"));
        assertThat(new StringsResponse(list).getStrings()).isEqualTo(list);
    }
}
