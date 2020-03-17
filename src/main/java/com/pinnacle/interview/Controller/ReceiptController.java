package com.pinnacle.interview.Controller;

import com.pinnacle.interview.Entity.Item;
import com.pinnacle.interview.Entity.Receipt;
import com.pinnacle.interview.Service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @PostMapping(path="/printReceipt", consumes="application/json",produces="application/json")
    public Receipt receipt(@RequestBody Item[] items){
        return receiptService.getReceipt(items);
    }
}
