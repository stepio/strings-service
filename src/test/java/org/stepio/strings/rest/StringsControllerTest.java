package org.stepio.strings.rest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.stepio.strings.model.LongestWordPair;
import org.stepio.strings.model.StringsRequest;
import org.stepio.strings.model.StringsResponse;
import org.stepio.strings.spring.ApplicationTests;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link StringsController}.
 *
 * @author stepio
 */
public class StringsControllerTest extends ApplicationTests {

    protected static final ParameterizedTypeReference<StringsResponse<LongestWordPair>> RESPONSE_LONGEST_WORD_PAIR_TYPE =
            new ParameterizedTypeReference<StringsResponse<LongestWordPair>>() {
            };

    @Autowired
    protected StringsController stringsController;
    protected String stringsUrl;

    @PostConstruct
    public void init() {
        this.stringsUrl = "/v1/strings/sort";
    }

    @Test
    public void stringsController_isNotNullInitialized() {
        assertThat(this.stringsController).isNotNull();
        assertThat(this.stringsController.sorter).isNotNull();
    }

    @Test
    public void sortList_withPredefinedData() {
        List<String> list = new ArrayList<>();
        list.add("Sound boy proceed to blast into the galaxy");
        list.add("Go back rocket man into the sky you'll see");
        list.add("Hear it all the time, come back rewind");
        list.add("Aliens are watching up in the sky");
        list.add("Sound boy process to blast into the galaxy");
        list.add("No one gonna harm you");
        list.add("They all want you to play I watch the birds of prey");
        StringsRequest request = StringsRequest.create(list);
        ResponseEntity<StringsResponse<LongestWordPair>> response = this.restTemplate.exchange(this.stringsUrl, HttpMethod.POST, new HttpEntity<>(request), RESPONSE_LONGEST_WORD_PAIR_TYPE);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        List<LongestWordPair> pairList = response.getBody().getResult();
        assertThat(pairList).isNotEmpty().hasSize(5);
        assertThat(pairList.get(0).getString()).isEqualTo("Aliens are watching up in the sky");
        assertThat(pairList.get(1).getString()).isEqualTo("Sound boy process to blast into the galaxy");
        assertThat(pairList.get(2).getString()).isEqualTo("Sound boy proceed to blast into the galaxy");
        assertThat(pairList.get(3).getString()).isEqualTo("Go back rocket man into the sky you'll see");
        assertThat(pairList.get(4).getString()).isEqualTo("Hear it all the time, come back rewind");
    }

    @Test
    public void handleIllegalArgumentException_withEmptyList() {
        StringsRequest request = StringsRequest.create(Collections.<String>emptyList());
        assertThat(this.restTemplate.exchange(this.stringsUrl, HttpMethod.POST, new HttpEntity<>(request), RESPONSE_LONGEST_WORD_PAIR_TYPE).getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void handleIllegalArgumentException_withEmptyString() {
        StringsRequest request = StringsRequest.create(Collections.singletonList(""));
        assertThat(this.restTemplate.exchange(this.stringsUrl, HttpMethod.POST, new HttpEntity<>(request), RESPONSE_LONGEST_WORD_PAIR_TYPE).getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
