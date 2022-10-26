package com.example.start.task1.Ammunition;
/*
Определить иерархию амуниции. Экипировать мотоциклиста. Посчитать стоимость.
 Провести сортировку амуниции на основе веса. Найти элементы амуниции, соответствующие заданному диапазону параметров цены.
 */


public abstract class MotorcycleAmmunition<t> {

    private String name;
    private String manufacturer;
    private double price;
    private double weight;

    public MotorcycleAmmunition(String name, String manufacturer, double price, double weight) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + ": " + manufacturer + ": " + "Price: " + price + " Weight: " + weight;
    }

    public boolean isPricePositive(){

        if(this.price > 0 ){
            return true;
        }
        return false;
    }

    public boolean isWeightPositive(){

        if(this.weight > 0 ){
            return true;
        }
        return false;
    }
}
