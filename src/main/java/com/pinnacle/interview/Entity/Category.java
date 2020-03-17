package com.pinnacle.interview.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String productType;
    private String productName;

    //Constructor
    public Category(){
    }
    public Category(String productType, String productName){
        this.productType = productType;
        this.productName = productName;
    }

    //Setters
    public void setId(Integer id) {this.id = id;}
    public void setProductType(String productType) {this.productType = productType;}
    public void setProductName(String productName) {this.productName = productName;}

    //Getters
    public Integer getId() {return id;}
    public String getProductType() {return productType;}
    public String getProductName() {return productName;}

}
