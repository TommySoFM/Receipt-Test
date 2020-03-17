package com.pinnacle.interview.Service;

import com.pinnacle.interview.Entity.Item;
import com.pinnacle.interview.Entity.Receipt;
import com.pinnacle.interview.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Receipt getReceipt(Item[] items){
        double subtotal = 0;
        double tax = 0;

        for(Item item: items){
            tax += taxCalculation(item);
            subtotal += subtotalCalculation(item);
        }

        Receipt receipt = initReceipt(subtotal, tax);
        receipt.setItems(items);
        return receipt;
    }

    public double taxCalculation(Item item){
        String name = item.getName();
        String location = item.getLocation();
        String productType = getProductType(name);
        double price = item.getPrice();
        double quantity = item.getQuantity();

        double productTax = 0;

        if(location.equals("CA")){
            if(!productType.equals("food")){
                productTax = price*0.0975*quantity;
            }
        } else if(location.equals("NY")){
            if(!productType.equals("food") && !productType.equals("clothing")){
                productTax = price*.08875*quantity;
            }
        }
        return Math.ceil(productTax*20)/20;
    }

    public double subtotalCalculation(Item item){
        double price = item.getPrice();
        double quantity = item.getQuantity();
        return price*quantity;
    }

    public String getProductType(String productName){
        String productType = categoryRepository.getFirstByProductNameEquals(productName).getProductType();
        return productType;
    }

    public Receipt initReceipt(double subtotal, double tax){
        double total = tax + subtotal;
        Receipt receipt = new Receipt();

        receipt.setSubtotal(stringAndRound(subtotal));
        receipt.setTax(stringAndRound(tax));
        receipt.setTotal(stringAndRound(total));

        return receipt;
    }

    public String stringAndRound(double value){
        return String.format("%.2f", value);
    }
}
