package com.example.start.model;

import com.example.start.task.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

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
    @Test
    void getListOfOwners(){
        assertArrayEquals(new String[]{"Dmitrij"},car.getOwners().toArray());
    }
    @Test
    void getListOfTwoOwners(){
        car.setOwner("Ivan");
        assertArrayEquals(new String[]{"Dmitrij", "Ivan"}, car.getOwners().toArray());
    }
    //Доступ к приватному методу без аргумента
    @Test
    public void testPrivateMethod(){
        try {
            Method method = Car.class.getDeclaredMethod("testMethod" , null);
            method.setAccessible(true);
            assertEquals("abc",method.invoke(car).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //Доступ к приватному методу с аргументом
    @Test
    public void testPrivateMethodWithArgument(){
        try {
            Method method = Car.class.getDeclaredMethod("testMethod" , String.class);
            method.setAccessible(true);
            assertEquals("abc",method.invoke(car, "abd" ).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}