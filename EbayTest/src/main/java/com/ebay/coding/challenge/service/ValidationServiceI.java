package com.ebay.coding.challenge.service;

import com.ebay.coding.challenge.model.Item;
import com.ebay.coding.challenge.model.ValidationError;

import java.util.List;

public interface ValidationServiceI {
    List<ValidationError> validate(Item item) throws java.lang.InterruptedException;
}
