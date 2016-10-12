package org.stepio.strings.sort;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.stepio.strings.model.LongestWordPair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sorting implementation according to the requested algorithm.
 *
 * @author stepio
 */
@Component
public class LongestWordSorter implements StringSorter<LongestWordPair> {

    @Value("${result.size:5}")
    protected int resultSize;

    public String getLongestWord(String string) {
        Assert.hasText(string, "Empty text is not supported as it's not comparable");
        return Arrays.asList(string.split("\\s")).stream()
                .sorted(Comparator.comparing(String::length, Comparator.reverseOrder()).thenComparing(Comparator.reverseOrder()))
                .findFirst().get();
    }

    @Override
    public LongestWordPair transform(String string) {
        Assert.hasText(string, "Empty text is not supported as it's not comparable");
        LongestWordPair.Builder builder = LongestWordPair.builder();
        builder.withString(string);
        String longestWord = this.getLongestWord(string);
        builder.withLongestWordString(longestWord);
        builder.withLongestWord(longestWord.length());
        return builder.build();
    }

    @Override
    public List<LongestWordPair> sort(final List<String> list) {
        Assert.notEmpty(list, "Empty list is not supported as it's not sortable");
        return list.stream().map(this::transform)
                .sorted(Comparator.comparing(LongestWordPair::getLongestWord, Comparator.reverseOrder()).thenComparing(LongestWordPair::getLongestWordString, Comparator.reverseOrder()))
                .limit(this.resultSize).collect(Collectors.toList());
    }
}
