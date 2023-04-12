package com.ebay.coding.challenge.model;

public enum Condition {
    USED("USED"), NEW("NEW");

    public final String label;


    Condition(String c){
        label= c;
    }
    @Override
    public String toString() { return this.label; };
}
