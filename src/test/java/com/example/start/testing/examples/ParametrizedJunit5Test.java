package com.example.start.testing.examples;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParametrizedJunit5Test {

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 6, -2, 14})
    void isOdd(int number) {
        assertTrue(number % 2 == 0);
    }

    @RepeatedTest(10)
    void repeatedTest() {
        System.out.println("Test is run");
    }

}
