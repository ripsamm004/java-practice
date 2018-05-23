package com.memory;

import java.util.stream.Stream;

/**
 * Created by shiful on 16/05/2018.
 */



class Test{
    static int total = 10;
    public void call() {
        int total = 5;
        System.out.println(this.total);
    }

    public static void main (String args[]) {
        System.out.println(Stream.of("green", "yellow", "blue")
                .max((s1, s2) -> s1.compareTo(s2))
                .filter(s -> s.endsWith("n"))
                .orElse("yellow"));
    }
}