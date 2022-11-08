package com.example.start.testing.calculator;

import org.springframework.stereotype.Service;

@Service
public class SimpleCalculatorService implements CalculatorService {

    @Override
    public int multiply(int multiplicand, int multiplier) {
        return multiplicand * multiplier;
    }

    @Override
    public int divide(int dividend, int divisor) {
        return dividend / divisor;
    }
}
