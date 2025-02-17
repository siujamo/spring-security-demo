package io.github.siujamo.playground.boot.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public final class ListUtil {

    private ListUtil() {
    }

    public static <T> List<T> toList(T[] array) {
        return Arrays.stream(array).toList();
    }

    public static <T, E> List<E> toList(T[] array, Function<T, E> mapper) {
        return Arrays.stream(array)
                .map(mapper)
                .toList();
    }

}
