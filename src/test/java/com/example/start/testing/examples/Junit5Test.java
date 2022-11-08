package com.example.start.testing.examples;

import org.junit.jupiter.api.*;

import static org.junit.Assert.fail;

class Junit5Test {

    @BeforeAll
    static void beforeClass() {
        System.out.println("Before all");
    }

    @BeforeEach
    void before() {
        System.out.println("Before");
    }

    @AfterEach
    void after() {
        System.out.println("After");
    }

    @AfterAll
    static void afterClass() {
        System.out.println("After all");
    }

    @Test
    void greenTest() {
        System.out.println("This is a green test");
    }

    @Test
    @Disabled
    void redTest() {
        System.out.println("This is a red test");
        fail("I have to fail!");
    }

}
