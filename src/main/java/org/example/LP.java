package org.example;

import java.util.List;

public class LP {
    private int quantity;
    private String productName;

    public LP(int q, String prod) {
        this.quantity=q;
        this.productName=prod;

    }

    public int getQuantity() {
        return this.quantity;
    }
}
