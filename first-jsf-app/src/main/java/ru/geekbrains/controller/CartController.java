package ru.geekbrains.controller;

import ru.geekbrains.persist.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class CartController implements Serializable {

    private Map<Long, Product> productMap = new HashMap<>();

    public void addToCart(Product product) {
        productMap.put(product.getId(),product);
    }

    public void removeFromCart(Product product) {
        productMap.remove(product.getId());
    }

    public int productMapSize(){
        return productMap.size();
    }

    public List<Product> getProducts(){
        return productMap
                .entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }
}
