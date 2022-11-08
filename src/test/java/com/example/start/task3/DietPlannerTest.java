package com.example.start.task3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DietPlannerTest {
    DietPlanner dietPlanner;

    @BeforeEach
    void setup() {
        this.dietPlanner = new DietPlanner(20, 30, 50);
    }
    @AfterEach
    void afterEach(){
        System.out.println("A unite yest was finished");
    }

    @Test
    void should_ReturnCorrectDietPlan_When_CorrectCoder() {
        //given
        Coder coder = new Coder(1.8, 75.0, 26, Gender.MALE);
        DietPlan expected = new DietPlan(2190, 110, 73, 274);
        //when
        DietPlan actual = dietPlanner.calculateDiet(coder);
        //then
        //assertEquals(expected, actual);
        assertAll(
                () -> assertEquals(expected.getCalories(), actual.getCalories()),
                () -> assertEquals(expected.getProtein(), actual.getProtein()),
                () -> assertEquals(expected.getFat(), actual.getFat()),
                () -> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate())
        );
    }

    @Test
    void calculateDietWhenCoderIsMaleThenReturnCorrectCalories() {
        //given
        Coder coder = mock(Coder.class);
        when(coder.getGender()).thenReturn(Gender.MALE);
        when(coder.getWeight()).thenReturn(80.0);
        when(coder.getHeight()).thenReturn(1.80);
        when(coder.getAge()).thenReturn(30);
        DietPlan expected = new DietPlan(2240, 110, 73, 274);

        //DietPlanner dietPlanner = new DietPlanner(30, 30, 40);

        //when
        DietPlan dietPlan = dietPlanner.calculateDiet(coder);
        //then
        assertEquals(expected.getCalories(), dietPlan.getCalories());
    }

    @Test
    void calculateDietWhenCoderIsFemaleThenReturnCorrectCalories() {
        Coder coder = mock(Coder.class);
        when(coder.getGender()).thenReturn(Gender.FEMALE);
        when(coder.getWeight()).thenReturn(60.0);
        when(coder.getHeight()).thenReturn(1.65);
        when(coder.getAge()).thenReturn(25);

       // DietPlanner dietPlanner = new DietPlanner(30, 30, 40);

        DietPlan dietPlan = dietPlanner.calculateDiet(coder);

        assertEquals(1713, dietPlan.getCalories());
    }
}