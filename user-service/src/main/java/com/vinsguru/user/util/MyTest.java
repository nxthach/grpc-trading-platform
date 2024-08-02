package com.vinsguru.user.util;

import java.util.Objects;
import java.util.Optional;

public class MyTest {
    public static void main(String[] args) {
        var ret = Optional.of(7).filter(e -> e > 10)
                .orElse(0);

        System.out.println(ret);
    }
}
