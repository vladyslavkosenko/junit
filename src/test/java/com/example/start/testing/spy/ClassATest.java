package com.example.start.testing.spy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClassATest {

    @Spy
    ClassB classB;
    @InjectMocks
    ClassA classA;

    @Test
    void shouldCallClassB() {
        classA.shouldCallClassB();
        verify(classB).someMethod();
    }
}