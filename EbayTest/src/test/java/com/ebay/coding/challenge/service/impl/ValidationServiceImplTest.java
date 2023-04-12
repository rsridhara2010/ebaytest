package com.ebay.coding.challenge.service.impl;

import com.ebay.coding.challenge.model.Condition;
import com.ebay.coding.challenge.model.Item;
import com.ebay.coding.challenge.model.ItemSpecific;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationServiceImplTest {
    @Autowired
    ValidationServiceImpl validationService;
    @Test
    public void testValidationReturnsErrors(){
        Item item = new Item();

        item.setDescription("Nike Shoes");
        item.setCondition("NEW");
        item.setPrice(new BigDecimal("-1"));
        ItemSpecific itemSpecific = new ItemSpecific("Nike Shoes");
        var itemSpecifics = new ArrayList<ItemSpecific>();
        itemSpecifics.add(itemSpecific);
        item.setItemSpecifics(itemSpecifics);
        item.setQuantity(-1);
        var errors = validationService.validate(item);
        assertEquals (errors.isEmpty(),false);

    }

    @Test
    public void testValidationReturnsNoErrors(){
        Item item = new Item();

        item.setDescription("Nike Shoes");
        item.setCondition("USED");
        item.setPrice(new BigDecimal("-1"));
        ItemSpecific itemSpecific = new ItemSpecific("Nike Shoes");
        var itemSpecifics = new ArrayList<ItemSpecific>();
        itemSpecifics.add(itemSpecific);
        item.setItemSpecifics(itemSpecifics);
        item.setQuantity(-1);
        var errors = validationService.validate(item);
        assertEquals (errors.isEmpty(),true);

    }

}
