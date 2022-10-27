package com.example.start.model;

import com.example.start.task.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    //@ValueSource(strings = {"ABC-123", "DEF-456", "DFG-434"})
    //@NullSource
    //@EmptySource
    @CsvSource({"'ABC', 'ABC'","'ABD', 'ABD'"})
    void testSetNumberMultipleValues(String number, String x){
        car.setNumber(number);
        assertEquals(x, car.getNumber());
    }

    @ParameterizedTest
    @CsvSource({"1, 5", "8, 12", "32, 36"})
    void testInt( int input, int output){
        assertEquals(car.testInt(input), output);
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