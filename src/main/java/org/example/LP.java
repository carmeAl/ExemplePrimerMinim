package org.example;

import java.util.List;

public class LP {
    private int quantity;
    private String productId;

    public LP(int q, String prod) {
        this.quantity = q;
        this.productId = prod;

    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getId() {
        return this.productId;
    }
}
