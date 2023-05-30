package com.jeanne.lowcode.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Pattern;

@SpringBootTest
class PatternTest {

    @Test
    void testPattern() {
        Pattern compile = Pattern.compile("src/utils/index.ts");
//        boolean matches = compile.matches("src/utils/index.ts");
//        System.out.println(matches);


    }

}
