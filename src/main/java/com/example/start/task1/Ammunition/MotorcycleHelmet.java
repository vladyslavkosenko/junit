package com.example.start.task1.Ammunition;

/*
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
public class MotorcycleHelmet extends MotorcycleAmmunition {

    private String eyeProtectionMaterial;
    private String helmMaterial;

    public MotorcycleHelmet(String name, String manufacturer, double price, double weight, String eyeProtectionMaterial, String material) {
        super(name, manufacturer, price, weight);
        this.eyeProtectionMaterial = eyeProtectionMaterial;
        this.helmMaterial = material;
    }

    public String getEyeProtectionMaterial() {
        return eyeProtectionMaterial;
    }

    public void setEyeProtectionMaterial(String eyeProtectionMaterial) {
        this.eyeProtectionMaterial = eyeProtectionMaterial;
    }

    public String getHelmMaterial() {
        return helmMaterial;
    }

    public void setHelmMaterial(String helmMaterial) {
        this.helmMaterial = helmMaterial;
    }


    @Override
    public String toString() {
        return super.getName() + "- " + super.getManufacturer() + ": " +
                "Price: " + super.getPrice() + " Weight: " + super.getWeight() +
                " EyeProtectionMaterial: " + eyeProtectionMaterial
                + " HelmMaterial: " + helmMaterial;
    }


}


