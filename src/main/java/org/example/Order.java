package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String idUser;
    List<LP> lps;

    public String getIdUser() {
        return idUser;
    }

    public Order(String id) {
        lps = new ArrayList<LP>();
        this.idUser = id;
    }

    public void addLP(int q, String prod) {
        lps.add(new LP(q, prod));
    }

    public LP getLP(int i) {
        return lps.get(i);
    }
}
