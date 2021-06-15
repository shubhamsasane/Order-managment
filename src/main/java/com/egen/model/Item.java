package com.egen.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Item {
    @Id
    private String item_id;
    private String item_name;
    private int item_qty;
    private Double item_unit_price;

//    @OneToOne
//    private Order order_id; //Foreign

    public Item(){}
    public Item(String item_id){
        this.item_id = item_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_qty() {
        return item_qty;
    }

    public void setItem_qty(int item_qty) {
        this.item_qty = item_qty;
    }

    public Double getItem_unit_price() {
        return item_unit_price;
    }

    public void setItem_unit_price(Double item_unit_price) {
        this.item_unit_price = item_unit_price;
    }

//    public Order getOrder_id() {
//        return order_id;
//    }
//
//    public void setOrder_id(Order order_id) {
//        this.order_id = order_id;
//    }
}
