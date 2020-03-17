package com.pinnacle.interview.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int quantity;
    private double price;
    private String location;

    // Constructors
    public Item(){}
    public Item(String name, int quantity, double price, String location){
        this.name = name;
        this. quantity = quantity;
        this.price = price;
        this.location = location;
    }

    // Setters
    public void setId(Integer id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public void setPrice(double price) {this.price = price;}
    public void setLocation(String location) {this.location = location;}

    // Getters
    public Integer getId() {return id;}
    public String getName() {return name;}
    public int getQuantity() {return quantity;}
    public double getPrice() {return price;}
    public String getLocation() {return location;}
}
