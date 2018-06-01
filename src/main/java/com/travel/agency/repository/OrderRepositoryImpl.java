package com.travel.agency.repository;

import com.travel.agency.Entity.Order;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/*репоситорий для доступа к данным о заказах*/
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private static AtomicInteger idGenerator = new AtomicInteger(1);

    private List<Order> orders = new LinkedList<>();

    /*получить все заказы*/
    public List<Order> findAll() {
        return Collections.unmodifiableList(orders);
    }

    /*найти заказ по id*/
    public Optional<Order> findById(int id) {
        return orders.stream()
                .filter(o -> o.getId() == id)
                .findFirst();
    }

    /*сохранить заказ в репозитории*/
    public void save(Order order) {
        order.setId(idGenerator.getAndIncrement());
        orders.add(order);
    }

}
