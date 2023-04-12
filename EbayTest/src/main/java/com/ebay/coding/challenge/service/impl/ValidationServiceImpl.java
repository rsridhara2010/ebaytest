package com.ebay.coding.challenge.service.impl;

import com.ebay.coding.challenge.model.Condition;
import com.ebay.coding.challenge.model.Item;
import com.ebay.coding.challenge.model.ValidationError;
import com.ebay.coding.challenge.service.ValidationServiceI;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ValidationServiceImpl implements ValidationServiceI {
    @Override
    public List<ValidationError> validate(Item item) {
        var validationsErrors = new ArrayList<ValidationError>();
        if(item.getCondition().equals(Condition.USED.toString())){
            return validationsErrors;
        }
        item.getItemSpecifics().stream().forEach(p-> {
                    try {
                        p.normalize();
                    } catch (InterruptedException ie) {
                        checkInterrupted(validationsErrors);
                    }
                });
        validateQuantity(item,validationsErrors);
        validatePrice(item,validationsErrors);

        return validationsErrors;
    }

    private void checkInterrupted(List<ValidationError> validationsErrors){
        ValidationError error = new ValidationError();
        error.setCode(1);
        error.setMessage("Item Specific Interrupted");
        validationsErrors.add(error);
    }

    private void validateQuantity(Item item, List<ValidationError> validationsErrors){
        if (item.getQuantity() < 0 ){
            ValidationError error = new ValidationError();
            error.setCode(1);
            error.setMessage("Invalid Qty");
            validationsErrors.add(error);
        }
    }

    private void validatePrice(Item item, List<ValidationError> validationsErrors){
        if (item.getPrice().compareTo(new BigDecimal(0)) < 0 ){
            ValidationError error = new ValidationError();
            error.setCode(2);
            error.setMessage("Invalid Price");
            validationsErrors.add(error);
        }
    }
}
