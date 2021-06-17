package com.egen.service;

import com.egen.model.Orders;
import com.egen.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
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

    //GET top orders by ZIP
    @Transactional
    public List<Orders> top10OrdersWithHighestDollarAmountInZip(String zip){
        List<Orders> orders = orderRepository.top10OrdersWithHighestDollarAmountInZip(zip);
        return orders;
    }

    @Transactional
    public Orders cancelOrder(Orders order){
        orderRepository.cancelOrder(order);
        return order;
    }


    //UPDATE order
    @Transactional
    public Orders updateOrder(String oid, Orders order){
        orderRepository.updateOrder(oid, order);
        return order;
    }

}