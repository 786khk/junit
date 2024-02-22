package com.example.junit;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedSourceTest {

    @ParameterizedTest(name = "과일이름 테스트")
    @MethodSource({"provideStringStream"})
    void methodSourceTest(String fruits) {
        assertAll(()->{
            Assertions.assertThat(fruits).isNotBlank();
            Assertions.assertThat(fruits).isInstanceOf(String.class);
        });
    }
    
    private static Stream<String> provideStringStream() { // 
        return Stream.of("apple", "orange");
    }

    @ParameterizedTest(name = "과일이름 테스트")
    @ValueSource(strings = {"apple","orange"})
    void valueSourceTest(String fruits) {
        assertAll(()->{
            Assertions.assertThat(fruits).isNotBlank();
            Assertions.assertThat(fruits).isInstanceOf(String.class);
        });
    }
}
