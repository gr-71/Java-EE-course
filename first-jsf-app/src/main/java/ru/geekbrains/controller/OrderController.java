package ru.geekbrains.controller;

import ru.geekbrains.persist.Order;
import ru.geekbrains.persist.OrderRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class OrderController implements Serializable {

    @Inject
    private OrderRepository orderRepository;

    private Order order;

    private List<Order> orders;

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        orders = orderRepository.findAll();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String createOrder() {
        this.order = new Order();
        return "/order.xhtml?faces-redirect=true";
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public String editOrder(Order order) {
        this.order = order;
        return "/order.xhtml?faces-redirect=true";
    }

    public void deleteOrder(Order order) {
        orderRepository.deleteById(order.getId());
    }

    public String saveOrder() {
        orderRepository.saveOrUpdate(order);
        return "/order.xhtml?faces-redirect=true";
    }

}
