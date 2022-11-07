package com.example.start.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @Test
    void shouldReturnCodeWithWorstBMIWhenCodeListNotEmpty() {
        //given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.8, 60));
        coders.add(new Coder(1.82, 98));
        coders.add(new Coder(1.82, 64.7));
        //when
        Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
        //then
        assertAll(
                () -> assertEquals(1.82, coderWithWorstBMI.getHeight()),
                () -> assertEquals(98.0, coderWithWorstBMI.getWeight())
        );
    }

    @Test
    void findCoderWithWorstBMIWhenThereIsOnlyOneCoderInTheListThenReturnTheCoderWithHighestBMI() {
        //given
        Coder coder = new Coder(1.8, 80);
        //when
        Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(List.of(coder));
        //then
        assertEquals(coder, coderWithWorstBMI);
    }

    @Test
    void findCoderWithWorstBMIWhenCodersListIsEmptyThenReturnNull() {
        //given
        List<Coder> coders = new ArrayList<>();
        //when
        Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
        //then
        assertNull(coderWithWorstBMI);
    }

    @Test
    void isDietRecommendedWhenBmiLessThan25ThenReturnFalse() {
        //give
        double weight = 70;
        double height = 1.75;
        //when
        boolean result = BMICalculator.isDietRecommended(weight, height);
        //then
        assertFalse(result);
    }

    @Test
    void isDietRecommendedWhenBmiGreaterThanOrEqualTo25ThenReturnTrue() {
        //give
        double weight = 89.0;
        double height = 1.72;
        //when
        boolean result = BMICalculator.isDietRecommended(weight, height);
        //then
        assertTrue(result);
    }

    @Test
    void shouldTrowArithmeticExceptionWhenHeightZero() {
        //give
        double weight = 89.0;
        double height = 0.0;
        //when
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
        //then
        assertThrows(ArithmeticException.class, executable);
    }
}