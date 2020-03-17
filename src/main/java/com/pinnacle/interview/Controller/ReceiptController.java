package com.pinnacle.interview.Controller;

import com.pinnacle.interview.Entity.Item;
import com.pinnacle.interview.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReceiptController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/all")
    public List<Item> getAll(){
        return itemRepository.findAll();
    }
}
