package com.pinnacle.interview.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String product_type;
    private String product_name;

    //Constructor
    public Item(){
    }

    //Getters
    public Integer getId() {return id;}
    public String getProduct_type() {return product_type;}
    public String getProduct_name() {return product_name;}

}
