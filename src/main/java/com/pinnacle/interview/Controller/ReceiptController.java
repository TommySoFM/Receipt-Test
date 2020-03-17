package com.pinnacle.interview.Controller;

import com.pinnacle.interview.Entity.Item;
import com.pinnacle.interview.Entity.Receipt;
import com.pinnacle.interview.Repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;

@RestController
public class ReceiptController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(path="/printReceipt", consumes="application/json",produces="application/json")
    public Receipt receipt(@RequestBody Item[] items){
        Receipt receipt = new Receipt();
        DecimalFormat decimalFormat = new DecimalFormat("####0.00");

        Item[] resultItems = new Item[items.length];
        double subtotal = 0;
        double tax = 0;
        for(Item item: items){
            String name = item.getName();
            double quantity = item.getQuantity();
            double price = item.getPrice();
            String location = item.getLocation();
            String type = categoryRepository.getFirstByProductNameEquals(name).getProductType();

            if(location.equals("CA")){
                if(!type.equals("food")){
                    tax += price*0.0975*quantity;
                }
            } else if(location.equals("NY")){
                if(!type.equals("food") && !type.equals("clothing")){
                    tax += price*.08875*quantity;
                }
            }
            subtotal += price*quantity;
            decimalFormat.format(subtotal);

            System.out.println("Price: "+item.getPrice());
            System.out.println("Current Subtotal: "+subtotal);
            System.out.println("Current Tax: " + tax);
        }
        System.out.println("Final Subtotal: "+subtotal);
        System.out.println("Final Tax: "+tax);

        double texRounded = Math.ceil(tax*20)/20;
        double total = texRounded + subtotal;

        String stringSubtotal = String.format("%.2f", subtotal);
        String stringTax = String.format("%.2f", texRounded);
        String stringTotal = String.format("%.2f", total);

        receipt.setItems(items);
        receipt.setSubtotal(stringSubtotal);
        receipt.setTax(stringTax);
        receipt.setTotal(stringTotal);

        return receipt;
    }
}
