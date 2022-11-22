package com.example.autoservice.service.impl;

import com.example.autoservice.model.Order;
import com.example.autoservice.model.Product;
import com.example.autoservice.model.ServiceForCar;
import com.example.autoservice.model.Status;
import com.example.autoservice.repository.OrderRepository;
import com.example.autoservice.service.OrderService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final static double DIAGNOSTIC_PRICE = 500.0;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order addProductToOrder(Long orderId, Product product) {
        Order order = findById(orderId);
        List<Product> products = order.getProducts();
        products.add(product);
        order.setProducts(products);
        return order;
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order orderStatus(Long orderId, Status status) {
        Order order = findById(orderId);
        order.setStatus(status);
        order.setFinishDate(LocalDate.now());
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderPrice(Long orderId) {
        Order order = findById(orderId);
        List<ServiceForCar> services = findById(orderId).getServices();
        List<Product> products = findById(orderId).getProducts();
        double countServices = services.size() == 1 ?
                DIAGNOSTIC_PRICE :
                services.stream().mapToDouble(ServiceForCar::getPrice).sum();
        double countProducts = products.stream().mapToDouble(Product::getPrice).sum();
        order.setPrice((countServices - (services.size() / 100)) + (countProducts - (products.size() / 100)));
        return order;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find order by id " + id));
    }
}