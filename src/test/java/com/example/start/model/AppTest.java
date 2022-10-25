package com.example.start.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    @DisplayName("Should return 0 when n is 0")
    void fWhenNIs0() {
        assertEquals(0, App.f(0));
    }

    @Test
    @DisplayName("Should return 1 when n is 1")
    void fWhenNIs1() {
        assertEquals(1, App.f(1));
    }
}