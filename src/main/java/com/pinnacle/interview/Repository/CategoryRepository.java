package com.pinnacle.interview.Repository;

import com.pinnacle.interview.Entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category getFirstByProductNameEquals(String product_name);
}
