package com.pinnacle.interview.Entity;

public class Receipt {
    private Item[] items;
    private String subtotal;
    private String tax;
    private String total;

    // Setters
    public void setItems(Item[] items) {this.items = items;}
    public void setSubtotal(String subtotal) {this.subtotal = subtotal;}
    public void setTax(String tax) {this.tax = tax;}
    public void setTotal(String total) {this.total = total;}

    // Getters
    public Item[] getItems() {return items;}
    public String getSubtotal() {return subtotal;}
    public String getTax() {return tax;}
    public String getTotal() {return total;}
}
