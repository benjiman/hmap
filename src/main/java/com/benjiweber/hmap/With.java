package com.benjiweber.hmap;

import java.util.function.Consumer;

public class With {
    static <T> void with(T t, Consumer<T> action) {
        action.accept(t);
    }
}
