package com.ebay.coding.challenge.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Item {
    String siteId;
    String categoryId;
    String title;
    String condition;
    BigDecimal price;
    int quantity;
    List<String> imageURL;
    List<ItemSpecific> itemSpecifics;
    String description;
}
