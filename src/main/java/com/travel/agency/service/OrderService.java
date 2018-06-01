package com.travel.agency.service;

import com.travel.agency.Entity.Order;
import com.travel.agency.controller.OrderDTO;

import java.util.List;

public interface OrderService {
    void save(OrderDTO orderDTO);

    List<Order> findAll();
}
