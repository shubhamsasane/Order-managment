package com.egen.service;

import com.egen.model.Orders;
import com.egen.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderRepository orderRepository;

    //GET all the orders
    @Override
    @Transactional
    public List<Orders> getAllOrders(){
        List<Orders> orders = orderRepository.getAllOrders();
        return orders;
    }

    //GET order by iD
    @Transactional
    public Orders getOrderById(String eid){
        Orders order = orderRepository.getOrderById(eid);
        return order;
    }

    //POST order
    @Transactional
    public Orders placeOrder(Orders order){
        orderRepository.placeOrder(order);
        return order;
    }
    //GET order by Time interval
    @Transactional
    public List<Orders> getAllOrdersWithInInterval(Timestamp startTime, Timestamp endTime){
        List<Orders> orders = orderRepository.getAllOrdersWithInInterval(startTime, endTime);
        return orders;
    }

    //UPDATE order
    @Transactional
    public Orders updateOrder(String oid, Orders order){
        orderRepository.updateOrder(oid, order);
        return order;
    }

}