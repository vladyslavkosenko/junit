package com.example.start.task1.Ammunition;/*
1.	Определить иерархию амуниции. Экипировать мотоциклиста. Посчитать стоимость.
 Провести сортировку амуниции на основе веса. Найти элементы амуниции, соответствующие заданному диапазону параметров цены.
Амуниция  -   имя, цена, вес,
//тип защиты (слабозащищенная, с противоударными элементами и цельнозащитная.) проверка уровня защиты в зависимости от веса
Шлем
Перчатки
Куртка
Брюки
Ботинки

 */

public class MotorcycleGloves extends MotorcycleAmmunition {

    private String glovesSize;
    private String glovesMaterial;

    public MotorcycleGloves(String name, String manufacturer, double price, double weight, String glovesSize, String glovesMaterial) {
        super(name, manufacturer, price, weight);
        this.glovesSize = glovesSize;
        this.glovesMaterial = glovesMaterial;
    }

    public String getGlovesSize() {
        return glovesSize;
    }

    public void setGlovesSize(String glovesSize) {
        this.glovesSize = glovesSize;
    }

    public String getGlovesMaterial() {
        return glovesMaterial;
    }

    public void setGlovesMaterial(String glovesMaterial) {
        this.glovesMaterial = glovesMaterial;
    }

    @Override
    public String toString() {
        return super.getName() + "- " + super.getManufacturer() + ": " +
                "Price: " + super.getPrice() + " Weight: " + super.getWeight() +
                " GlovesSize: " + glovesSize + " GlovesMaterial: " + glovesMaterial;
    }
}
