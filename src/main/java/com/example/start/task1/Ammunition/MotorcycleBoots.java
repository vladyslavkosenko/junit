package com.example.start.task1.Ammunition;


public class MotorcycleBoots extends MotorcycleAmmunition {

    private int bootsSize;
    private String lacing;
    private String color;

    public MotorcycleBoots(String name, String manufacturer, double price, double weight, int bootsSize, String lacing, String color) {
        super(name, manufacturer, price, weight);
        this.bootsSize = bootsSize;
        this.lacing = lacing;
        this.color = color;
    }

    public int getBootsSize() {
        return bootsSize;
    }

    public void setBootsSize(int bootsSize) {
        this.bootsSize = bootsSize;
    }

    public String getLacing() {
        return lacing;
    }

    public void setLacing(String lacing) {
        this.lacing = lacing;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.getName() + "- " + super.getManufacturer() + ": " +
                "Price: " + super.getPrice() + " Weight: " + super.getWeight() +
                " BootsSize: " + bootsSize + " Lacing: " + lacing + " Color: " + color;
    }

    public boolean isThisSizeForAnAdult(){

        if(this.bootsSize > 40 ){
            return true;
        }
        return false;
    }

}
