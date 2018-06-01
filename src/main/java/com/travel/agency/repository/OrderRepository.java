package com.travel.agency.repository;

import com.travel.agency.Entity.Order;

import java.util.List;
import java.util.Optional;


public interface OrderRepository {
    List<Order> findAll();

    Optional<Order> findById(int id);

    void save(Order order);
}
