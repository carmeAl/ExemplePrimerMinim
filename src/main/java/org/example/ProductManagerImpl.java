package org.example;

import java.util.List;

public class ProductManagerImpl implements ProductManager {

    @Override
    public List<Product> productsByPrice() {
        return null;
    }

    @Override
    public List<Product> productsBySales() {
        return null;
    }

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public Order processOrder() {
        return null;
    }

    @Override
    public List<Order> ordersByUser(String userId) {
        return null;
    }

    @Override
    public void addUser(String s, String name, String surname) {

    }

    @Override
    public void addProduct(String productId, String description, double price) {
        Product P=new Product();
        P.ProductConstructor(productId,price,description);

    }

    @Override
    public Product getProduct(String productId) {
        return null;
    }

    @Override
    public int numUsers() {
        return 0;
    }

    @Override
    public int numProducts() {
        return 0;
    }

    @Override
    public int numOrders() {
        return 0;
    }

    @Override
    public int numSales(String b001) {
        return 0;
    }
}
