package com.example.start.testing.spy;

public class ClassA {

    private ClassB classB;

    public ClassA(ClassB classB) {
        this.classB = classB;
    }

    public void shouldCallClassB() {
        System.out.println("I'm called in ClassA.");
        classB.someMethod();
    }

}
