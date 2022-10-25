package com.example.start.model;

import org.hibernate.loader.collection.OneToManyJoinWalker;

import java.util.ArrayList;

public class Car {
    private String manufacturer;
    private String number;
    private int year;
    private String owner;
    private ArrayList<String> owners = new ArrayList<String>();

    public Car(String manufacturer, String number, int year, String owner) {
        this.manufacturer = manufacturer;
        this.number = number;
        this.year = year;
        this.owner = owner;
        owners.add(owner);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<String> getOwners() {
        return owners;
    }
}
