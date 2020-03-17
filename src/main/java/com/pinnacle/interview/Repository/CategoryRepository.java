package com.pinnacle.interview.Repository;

import com.pinnacle.interview.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
//    Item findDistinctFirstByProduct_nameEquals(String product_name);
}
