package com.example.start.task1.Ammunition;/*
1.	Определить иерархию амуниции. Экипировать мотоциклиста. Посчитать стоимость.
 Провести сортировку амуниции на основе веса. Найти элементы амуниции, соответствующие заданному диапазону параметров цены.

 */


public class MotorcycleJacket extends MotorcycleAmmunition {

    private String jacketSize;
    private String color;
    private String jacketMaterial;

    public MotorcycleJacket(String name, String manufacturer, double price, double weight, String jacketSize, String color, String jacketMaterial) {
        super(name, manufacturer, price, weight);
        this.jacketSize = jacketSize;
        this.color = color;
        this.jacketMaterial = jacketMaterial;
    }

    public String getJacketSize() {
        return jacketSize;
    }

    public void setJacketSize(String jacketSize) {
        this.jacketSize = jacketSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getJacketMaterial() {
        return jacketMaterial;
    }

    public void setJacketMaterial(String jacketMaterial) {
        this.jacketMaterial = jacketMaterial;
    }

    @Override
    public String toString() {
        return super.getName() + "- " + super.getManufacturer() + ": " +
                "Price: " + super.getPrice() + " Weight: " + super.getWeight() +
                " JacketSize: " + jacketSize + " Color: " + color + " JacketMaterial: " + jacketMaterial;
    }
}

