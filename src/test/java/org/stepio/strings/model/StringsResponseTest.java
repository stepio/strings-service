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
    public void getResult_withCreator() throws Exception {
        List<LongestWordPair> list = null;
        assertThat(StringsResponse.create(list).getResult()).isNull();
        list = Collections.emptyList();
        assertThat(StringsResponse.create(list).getResult()).isNotNull().isEmpty();
        list = Collections.singletonList(LongestWordPair.builder().withString("Hello, world!").build());
        assertThat(StringsResponse.create(list).getResult()).isEqualTo(list);
        list = new ArrayList<>();
        list.add(LongestWordPair.builder().withString("See no evil").build());
        list.add(LongestWordPair.builder().withString("Hear no evil").build());
        list.add(LongestWordPair.builder().withString("Speak no evil").build());
        assertThat(StringsResponse.create(list).getResult()).isEqualTo(list);
    }
}
