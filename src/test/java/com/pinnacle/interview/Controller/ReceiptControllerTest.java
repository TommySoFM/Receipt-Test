package com.pinnacle.interview.Controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pinnacle.interview.Entity.Item;
import com.pinnacle.interview.Service.ReceiptService;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReceiptController.class)
public class ReceiptControllerTest {
    private MockMvc mvc;

    @Autowired
    private ReceiptController receiptController;

    @MockBean
    private ReceiptService service;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(this.receiptController).build();
    }

    private Item case1_1 = new Item("book", 1, 17.99, "CA");
    private Item case1_2 = new Item("potato chips", 1, 3.99, "CA");
    Item[] case1 = new Item[]{case1_1, case1_2};

    @Test
    public void testReceipt() throws Exception {
        mvc.perform(post("/printReceipt")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(new JSONArray(case1))))
            .andExpect(status().isOk())
            .andReturn();
    }

}
