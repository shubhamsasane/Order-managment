package com.egen.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.ZonedDateTime;
@Entity
public class Payment {
    @Id
    private String payment_id;
    private Double payment_confirmation_number;
    private Double order_payment_amount;
    private String order_payment_method;
    private ZonedDateTime order_payment_date;

    @OneToOne
    private Billing billing;    //Foreign


    public Payment(String payment_id){
        this.payment_id = payment_id;
    }

    public Payment() {

    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public Double getPayment_confirmation_number() {
        return payment_confirmation_number;
    }

    public void setPayment_confirmation_number(Double payment_confirmation_number) {
        this.payment_confirmation_number = payment_confirmation_number;
    }

    public Double getOrder_payment_amount() {
        return order_payment_amount;
    }

    public void setOrder_payment_amount(Double order_payment_amount) {
        this.order_payment_amount = order_payment_amount;
    }

    public String getOrder_payment_method() {
        return order_payment_method;
    }

    public void setOrder_payment_method(String order_payment_method) {
        this.order_payment_method = order_payment_method;
    }

    public ZonedDateTime getOrder_payment_date() {
        return order_payment_date;
    }

    public void setOrder_payment_date(ZonedDateTime order_payment_date) {
        this.order_payment_date = order_payment_date;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }
}
