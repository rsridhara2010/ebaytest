package com.ebay.coding.challenge.model;


public class ItemSpecific {

    String name;
    public ItemSpecific(String n){
        name = n;
    }
    public void normalize() throws java.lang.InterruptedException{
        StringBuilder sb = new StringBuilder();
        sb.append(name.charAt(0));
        sb = sb.append(sb.toString().toUpperCase());
        sb.append(name.substring(1).toLowerCase());
        Thread.sleep(1000);
        name= sb.toString();
    }
}
