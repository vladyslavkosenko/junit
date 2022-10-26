//package com.example.start.task;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//class CarTest {
//
//    @Test
//    @DisplayName("Should return abc when no parameter is passed")
//    void testMethodWhenNoParameterIsPassed() {
//        Car car = new Car("BMW", "123", 2000, "John");
//        assertEquals("abc", car.testMethod());
//    }
//
//    @Test
//    @DisplayName("Should return the parameter when a parameter is passed")
//    void testMethodWhenAParameterIsPassed() {
//        Car car = mock(Car.class);
//        when(car.testMethod("abc")).thenReturn("abc");
//        assertEquals("abc", car.testMethod("abc"));
//    }
//}