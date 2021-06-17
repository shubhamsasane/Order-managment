package com.egen.repository;

import com.egen.model.Orders;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @PersistenceContext
    public EntityManager em;

    //GET all orders
    public List<Orders> getAllOrders(){
        TypedQuery<Orders> query = em.createNamedQuery("Orders.findAll", Orders.class);
        List<Orders> orders = query.getResultList();
        return orders;
    }

    //GET order by ID
    public Orders getOrderById(String eid){
        Orders order = em.find(Orders.class, eid);
        return order;
    }

    //UPDATE order
    public Orders updateOrder(String oid, Orders order){
        Orders orderUpdated = getOrderById(oid);
        if(orderUpdated != null ) {
            order.setId(orderUpdated.getId());
        }
        em.merge(order);
        return order;
    }

    //GET by Time Interval
    public List<Orders> getAllOrdersWithInInterval(Timestamp startTime, Timestamp endTime){
        TypedQuery<Orders> query = em.createNamedQuery("Orders.findByInterval", Orders.class);
        query.setParameter("startDate", "startTime");
        query.setParameter("endDate", "endTime");

        List<Orders> orders = query.getResultList();
        return orders;
    }

    //GET top orders by ZIP
    public List<Orders> top10OrdersWithHighestDollarAmountInZip(String zip){
        TypedQuery<Orders> query  = em.createNamedQuery("Orders.findTopByZip", Orders.class);
        List<Orders> orders = query.getResultList();
        return orders;
    }
    public Orders cancelOrder(Orders order){
        em.persist(order);
        return order;
    }

    //POST order
    public Orders placeOrder(Orders order){
        em.persist(order);
        return order;
    }
}
