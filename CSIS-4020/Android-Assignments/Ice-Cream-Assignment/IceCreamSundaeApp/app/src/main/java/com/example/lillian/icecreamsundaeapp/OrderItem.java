package com.example.lillian.icecreamsundaeapp;

import java.io.Serializable;

/**
 * Created by Lillian on 3/23/17.
 */

public class OrderItem implements Serializable{

    String info;
    String date;
    String flavor;
    String size;
    Double price;

//    public OrderItem(String info) {
//        this.info = info;
//    }

    public OrderItem(String d, String f, String s, Double p) {
        this.date = d;
        this.flavor = f;
        this.size = s;
        this.price = p;
    }

    @Override
    public String toString(){
        return "Date:" + date + "\nFlavor: " + flavor + "\nSize: " + size + "\nCost: $" + price;
    }
}
