package com.example.start.task1.Ammunition;/*
1.	Определить иерархию амуниции. Экипировать мотоциклиста. Посчитать стоимость.
 Провести сортировку амуниции на основе веса. Найти элементы амуниции, соответствующие заданному диапазону параметров цены.


 */

public class MotorcycleTrousers extends MotorcycleAmmunition {

    private String trousersSize;
    private String color;
    private String trousersMaterial;

    public MotorcycleTrousers(String name, String manufacturer, double price, double weight, String trousersSize, String color, String trousersMaterial) {
        super(name, manufacturer, price, weight);
        this.trousersSize = trousersSize;
        this.color = color;
        this.trousersMaterial = trousersMaterial;
    }

    public String getTrousersSize() {
        return trousersSize;
    }

    public void setTrousersSize(String trousersSize) {
        this.trousersSize = trousersSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTrousersMaterial() {
        return trousersMaterial;
    }

    public void setTrousersMaterial(String trousersMaterial) {
        this.trousersMaterial = trousersMaterial;
    }

    @Override
    public String toString() {
        return super.getName() + "- " + super.getManufacturer() + ": " +
                "Price: " + super.getPrice() + " Weight: " + super.getWeight() +
                " TrousersSize: " + trousersSize + " Color: " + color + " TrousersMaterial: " + trousersMaterial;
    }
}
