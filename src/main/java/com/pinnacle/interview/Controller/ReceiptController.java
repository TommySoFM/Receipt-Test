package com.pinnacle.interview.Controller;

import com.pinnacle.interview.Entity.Item;
import com.pinnacle.interview.Entity.ItemWrapper;
import com.pinnacle.interview.Repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReceiptController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(path="/printReceipt", consumes="application/json",produces="application/json")
    public String receipt(@RequestBody Item[] items){
        for(Item item: items){
            logger.warn(item.getName());
        }
        return "OK";
    }
}
