package com.example.start.testing.spy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

class MyInterfaceTest {

    MyInterface myInterface = spy(MyInterface.class);

    @Test
    void someDefaultMethod() {
        String actual = myInterface.someDefaultMethod();
        assertEquals("I'm a default method!", actual);
    }

}