package com.example.start.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;
    @BeforeEach
    public void createCar(){
        car = new Car("Shkoda", "ABC", 2019, "Dmitrij");
    }

    @Test
    void getManufacturer() {
        assertEquals("Shkoda", car.getManufacturer());
    }

    @Test
    void getNumber() {
        assertEquals("ABC", car.getNumber());
    }

    @Test
    void setNumber() {
        car.setNumber("1232");
        assertEquals("1232", car.getNumber());

    }

    @Test
    void getYear() {
        assertEquals(2019, car.getYear());
    }

    @Test
    void getOwner() {
        assertEquals("Dmitrij", car.getOwner());
    }

    @Test
    void setOwner() {
        car.setOwner("Ivan");
        assertEquals("Ivan", car.getOwner());
    }
}