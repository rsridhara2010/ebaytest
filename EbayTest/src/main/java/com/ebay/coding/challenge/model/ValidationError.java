package com.ebay.coding.challenge.model;

import lombok.Data;

@Data
public class ValidationError {
    String message;
    int code;
}
