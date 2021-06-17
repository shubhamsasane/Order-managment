package com.egen.controller;

import com.egen.model.Orders;
import com.egen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    public OrderService orderService;

    //Get all the orders
    @RequestMapping(method = RequestMethod.GET)
    public List<Orders> getAllOrders(){
        List<Orders> orders = orderService.getAllOrders();
        return orders;
    }

    //Get order by ID
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Orders getOrderById(@PathVariable("id") String oid){
        Orders order = orderService.getOrderById(oid);
        return order;
    }

    //GET by Time Interval
    @RequestMapping(method = RequestMethod.GET, value = "interval")
    public List<Orders> getAllOrdersWithInInterval(@RequestBody Timestamp startTime,@RequestBody Timestamp endTime){
        List<Orders> orders = orderService.getAllOrdersWithInInterval(startTime, endTime);
        return orders;
    }

    public ResponseEntity<List<Orders>> top10OrdersWithHighestDollarAmountInZip(String zip){
        //TODO
        return null;
    }

    //POST order
    @RequestMapping(method = RequestMethod.POST)
    public Orders placeOrder(@RequestBody Orders order){
        orderService.placeOrder(order);
        return order;
    }

    public ResponseEntity<Orders> cancelOrder(Orders order){
        return null;
    }

    //UPDATE order
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Orders updateOrder(@PathVariable("id") String oid, @RequestBody  Orders order){
        orderService.updateOrder(oid, order);
        return order;
    }


}
