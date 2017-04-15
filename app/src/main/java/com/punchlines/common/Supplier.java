package com.punchlines.common;

@FunctionalInterface
public interface Supplier<T> {

    T get() throws Exception;

}
