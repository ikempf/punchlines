package com.punchlines.common;


public class Exceptions {

    public static<T> T unsafe(Supplier<T> checked) {
        try {
            return checked.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}