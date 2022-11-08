package com.example.start.testing.spy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

class MyAbstractClassTest {

    MyAbstractClass myAbstractClass = spy(MyAbstractClass.class);

    @Test
    void myMethod() {
        String actual = myAbstractClass.myMethod();
        assertEquals("This is myMethod()", actual);
    }

}