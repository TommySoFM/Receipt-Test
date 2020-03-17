package com.pinnacle.interview.Repository;

import com.pinnacle.interview.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
//    Item findDistinctFirstByProduct_nameEquals(String product_name);
}
