package ru.netology.domain;

public class Smartphone extends Product {
    private String Manufacturer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        Manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }
}
