package com.pinnacle.interview.Service;

import com.pinnacle.interview.Entity.Category;
import com.pinnacle.interview.Entity.Item;
import com.pinnacle.interview.Entity.Receipt;
import com.pinnacle.interview.Repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReceiptService.class)
public class ReceiptServiceTest {

    @Autowired
    private ReceiptService service;

    @MockBean
    private CategoryRepository repository;

    private Category book = new Category("stationary", "book");
    private Category pencil = new Category("stationary", "pencil");
    private Category shirt = new Category("clothing", "shirt");
    private Category chips = new Category("food", "potato chips");

    private Item case1_1 = new Item("book", 1, 17.99, "CA");
    private Item case1_2 = new Item("potato chips", 1, 3.99, "CA");
    Item[] case1 = new Item[]{case1_1, case1_2};

    private Item case2_1 = new Item("book", 1, 17.99, "NY");
    private Item case2_2 = new Item("pencil", 3, 2.99, "NY");
    Item[] case2 = new Item[]{case2_1, case2_2};

    private Item case3_1 = new Item("pencil", 2, 2.99, "NY");
    private Item case3_2 = new Item("shirt", 1, 29.99, "NY");
    Item[] case3 = new Item[]{case3_1, case3_2};

    @Test
    public void testGetReceipt_1(){
        when(repository.getFirstByProductNameEquals("book")).thenReturn(book);
        when(repository.getFirstByProductNameEquals("potato chips")).thenReturn(chips);
        Receipt result_case1 = service.getReceipt(case1);
        assertEquals("21.98", result_case1.getSubtotal());
        assertEquals("1.80", result_case1.getTax());
        assertEquals("23.78", result_case1.getTotal());
    }

    @Test
    public void testGetReceipt_2(){
        when(repository.getFirstByProductNameEquals("book")).thenReturn(book);
        when(repository.getFirstByProductNameEquals("pencil")).thenReturn(pencil);
        Receipt result_case2 = service.getReceipt(case2);
        assertEquals("26.96", result_case2.getSubtotal());
        assertEquals("2.40", result_case2.getTax());
        assertEquals("29.36", result_case2.getTotal());
    }

    @Test
    public void testGetReceipt_3(){
        when(repository.getFirstByProductNameEquals("pencil")).thenReturn(pencil);
        when(repository.getFirstByProductNameEquals("shirt")).thenReturn(shirt);
        Receipt result_case3 = service.getReceipt(case3);
        assertEquals("35.97", result_case3.getSubtotal());
        assertEquals("0.55", result_case3.getTax());
        assertEquals("36.52", result_case3.getTotal());
    }

}
