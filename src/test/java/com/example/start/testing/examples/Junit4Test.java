package com.example.start.testing.examples;

import org.junit.*;

import static org.junit.Assert.fail;

public class Junit4Test {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class");
    }

    @Before
    public void before() {
        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class");
    }

    @Test
    public void greenTest() {
        System.out.println("This is a green test");
    }

    @Test
    @Ignore
    public void redTest() {
        System.out.println("This is a red test");
        fail("I have to fail!");
    }

}
