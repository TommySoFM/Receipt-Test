package com.pinnacle.interview.Repository;

import com.pinnacle.interview.Entity.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    private Category book = new Category("stationary", "book");
    private Category pencil = new Category("stationary", "pencil");
    private Category shirt = new Category("clothing", "shirt");
    private Category chips = new Category("food", "potato chips");

    @Before
    public void init() {
        categoryRepository.save(book);
        categoryRepository.save(pencil);
        categoryRepository.save(shirt);
        categoryRepository.save(chips);
    }

    @Test
    public void testFindTypeByName(){
        Category catOfBook = getCatByName("book");
        Category catOfPencil = getCatByName("pencil");
        Category catOfSuit = getCatByName("shirt");
        Category catOfChips = getCatByName("potato chips");

        assertEquals("stationary", catOfBook.getProductType());
        assertEquals("stationary", catOfPencil.getProductType());
        assertEquals("clothing", catOfSuit.getProductType());
        assertEquals("food", catOfChips.getProductType());
    }

    public Category getCatByName(String name){
        return categoryRepository.getFirstByProductNameEquals(name);
    }
}


