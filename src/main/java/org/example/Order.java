package org.example;

import java.util.List;

public class Order {
    List<LP> lps;
    public Order(String s) {
    }

    public void addLP(int q, String prod) {
        lps.add(new LP(q, prod));
    }

    public LP getLP(int i) {
        return null;
    }
}
