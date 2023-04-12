package com.ebay.coding.challenge.controller;

import com.ebay.coding.challenge.model.Item;
import com.ebay.coding.challenge.service.impl.ValidationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenge")
public class ValidationController {

    @Autowired
    ValidationServiceImpl validationService;

    @PostMapping("/validate")
    public ResponseEntity<?> validateItem(@RequestBody Item item){
        HttpStatus status = HttpStatus.OK;
        var errors = validationService.validate(item);
        return errors.isEmpty() ?
                new ResponseEntity<>(errors,status) :
            new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
    }
}
