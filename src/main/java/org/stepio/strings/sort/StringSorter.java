package org.stepio.strings.sort;

import org.stepio.strings.model.StringObject;

import java.util.List;

/**
 * Generic interface to define the sorting mechanism.
 *
 * @author stepio
 */
public interface StringSorter<T extends StringObject> {

    T transform(final String string);

    List<T> sort(final List<String> list);
}
