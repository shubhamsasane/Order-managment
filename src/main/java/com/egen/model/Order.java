package com.egen.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
public class Order {
    @Id
    private String id;
    private String customer_id;
    private Double order_total;
    private Double order_subtotal;
    private Double order_tax;
    private String order_status;
    private ZonedDateTime creation_time;
    private ZonedDateTime modification_time;

    @OneToMany
    private List<Item> items;

    @OneToMany
    private List<Payment> payments;

    @OneToOne
    private Shipping shipping;

    public Order(){}
    public Order(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public Double getOrder_total() {
        return order_total;
    }

    public void setOrder_total(Double order_total) {
        this.order_total = order_total;
    }

    public Double getOrder_subtotal() {
        return order_subtotal;
    }

    public void setOrder_subtotal(Double order_subtotal) {
        this.order_subtotal = order_subtotal;
    }

    public Double getOrder_tax() {
        return order_tax;
    }

    public void setOrder_tax(Double order_tax) {
        this.order_tax = order_tax;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public ZonedDateTime getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(ZonedDateTime creation_time) {
        this.creation_time = creation_time;
    }

    public ZonedDateTime getModification_time() {
        return modification_time;
    }

    public void setModification_time(ZonedDateTime modification_time) {
        this.modification_time = modification_time;
    }
}
