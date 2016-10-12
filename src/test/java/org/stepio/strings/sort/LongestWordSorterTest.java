package org.stepio.strings.sort;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.stepio.strings.model.LongestWordPair;
import org.stepio.strings.spring.ApplicationTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link LongestWordSorter}.
 *
 * @author stepio
 */
public class LongestWordSorterTest extends ApplicationTests {

    @Autowired
    private LongestWordSorter sorter;

    @Test
    public void resultSize_isEqualTo5() {
        assertThat(this.sorter.resultSize).isEqualTo(5);
    }

    @Test
    public void getLongestWord_withEmpty() {
        assertThatThrownBy(() -> this.sorter.getLongestWord(null))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Empty text is not supported as it's not comparable");
        assertThatThrownBy(() -> this.sorter.getLongestWord(""))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Empty text is not supported as it's not comparable");
    }

    @Test
    public void getLongestWord_withDummy() {
        assertThat(this.sorter.getLongestWord("bla-bla-bla")).isEqualTo("bla-bla-bla");
        assertThat(this.sorter.getLongestWord("Sound boy proceed to blast into the galaxy")).isEqualTo("proceed");
        assertThat(this.sorter.getLongestWord("Go back rocket man into the sky you'll see")).isEqualTo("you'll");
        assertThat(this.sorter.getLongestWord("Hear it all the time, come back rewind")).isEqualTo("rewind");
        assertThat(this.sorter.getLongestWord("Aliens are watching up in the sky")).isEqualTo("watching");
        assertThat(this.sorter.getLongestWord("Sound boy process to blast into the galaxy")).isEqualTo("process");
        assertThat(this.sorter.getLongestWord("No one gonna harm you")).isEqualTo("gonna");
        assertThat(this.sorter.getLongestWord("They all want you to play I watch the birds of prey")).isEqualTo("watch");
    }

    @Test
    public void transform_withEmpty() {
        assertThatThrownBy(() -> this.sorter.transform(null))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Empty text is not supported as it's not comparable");
        assertThatThrownBy(() -> this.sorter.transform(""))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Empty text is not supported as it's not comparable");
    }

    @Test
    public void transform_withDummy() {
        assertThat(this.sorter.transform("Sound boy proceed to blast into the galaxy"))
                .isEqualTo(LongestWordPair.builder().withString("Sound boy proceed to blast into the galaxy").withLongestWordString("proceed").withLongestWord(7).build());
        assertThat(this.sorter.transform("Go back rocket man into the sky you'll see"))
                .isEqualTo(LongestWordPair.builder().withString("Go back rocket man into the sky you'll see").withLongestWordString("you'll").withLongestWord(6).build());
        assertThat(this.sorter.transform("Hear it all the time, come back rewind"))
                .isEqualTo(LongestWordPair.builder().withString("Hear it all the time, come back rewind").withLongestWordString("rewind").withLongestWord(6).build());
        assertThat(this.sorter.transform("Aliens are watching up in the sky"))
                .isEqualTo(LongestWordPair.builder().withString("Aliens are watching up in the sky").withLongestWordString("watching").withLongestWord(8).build());
        assertThat(this.sorter.transform("Sound boy process to blast into the galaxy"))
                .isEqualTo(LongestWordPair.builder().withString("Sound boy process to blast into the galaxy").withLongestWordString("process").withLongestWord(7).build());
        assertThat(this.sorter.transform("No one gonna harm you"))
                .isEqualTo(LongestWordPair.builder().withString("No one gonna harm you").withLongestWordString("gonna").withLongestWord(5).build());
        assertThat(this.sorter.transform("They all want you to play I watch the birds of prey"))
                .isEqualTo(LongestWordPair.builder().withString("They all want you to play I watch the birds of prey").withLongestWordString("watch").withLongestWord(5).build());
    }

    @Test
    public void sort_withEmpty() {
        assertThatThrownBy(() -> this.sorter.sort(null))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Empty list is not supported as it's not sortable");
        assertThatThrownBy(() -> this.sorter.sort(Collections.<String>emptyList()))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Empty list is not supported as it's not sortable");
        assertThatThrownBy(() -> this.sorter.sort(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Empty list is not supported as it's not sortable");
    }

    @Test
    public void sort_withDummy() {
        List<String> list = new ArrayList<>();
        list.add("Sound boy proceed to blast into the galaxy");
        list.add("Go back rocket man into the sky you'll see");
        list.add("Hear it all the time, come back rewind");
        list.add("Aliens are watching up in the sky");
        list.add("Sound boy process to blast into the galaxy");
        list.add("No one gonna harm you");
        list.add("They all want you to play I watch the birds of prey");
        List<LongestWordPair> pairList = this.sorter.sort(list);
        assertThat(pairList).isNotEmpty().hasSize(5);
        assertThat(pairList.get(0).getString()).isEqualTo("Aliens are watching up in the sky");
        assertThat(pairList.get(1).getString()).isEqualTo("Sound boy process to blast into the galaxy");
        assertThat(pairList.get(2).getString()).isEqualTo("Sound boy proceed to blast into the galaxy");
        assertThat(pairList.get(3).getString()).isEqualTo("Go back rocket man into the sky you'll see");
        assertThat(pairList.get(4).getString()).isEqualTo("Hear it all the time, come back rewind");
    }
}
