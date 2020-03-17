package com.pinnacle.interview.Entity;

public class Item {

    private String name;
    private int quantity;
    private double price;
    private String location;

    public Item(String name, int quantity, double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Setters
    public void setName(String name) {this.name = name;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public void setPrice(double price) {this.price = price;}
    public void setLocation(String location) {this.location = location;}

    // Getters
    public String getName() {return name;}
    public int getQuantity() {return quantity;}
    public double getPrice() {return price;}
    public String getLocation() {return location;}
}
