package com.example.start.testing.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleCalculatorServiceTest {

    private SimpleCalculatorService simpleCalculatorService = new SimpleCalculatorService();

    @Test
    public void testMultiply() {
        int result = simpleCalculatorService.multiply(10, 5);
        assertEquals(50, result);
    }

}