package com.travel.agency.service;

import com.travel.agency.Entity.Order;
import com.travel.agency.Entity.Tour;
import com.travel.agency.controller.OrderDTO;
import com.travel.agency.repository.OrderRepository;
import com.travel.agency.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*сервис для заказов*/
@Service
public class OrderServiceImpl implements OrderService {
    private final TourRepository tourRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(TourRepository tourRepository, OrderRepository orderRepository) {
        this.tourRepository = tourRepository;
        this.orderRepository = orderRepository;
    }

    /*сохранить заказ в репозитории*/
    public void save(OrderDTO orderDTO) {
        Optional<Tour> tour = tourRepository.getById(orderDTO.getTourID());
        if (tour.isPresent()) {
            Order order = new Order();
            order.setClient(orderDTO.getClient());
            order.setTour(tour.get());
            order.setClient(orderDTO.getClient());
            order.setCount(orderDTO.getCount());

            orderRepository.save(order);
        }
    }

    /*найти все заказы*/
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
