package org.example;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class ProductManagerImpl implements ProductManager {
    private List<Order> listOrders;
    private List<User> listUsers;

    private List<Product> listProducts;

    public ProductManagerImpl() {
        this.listOrders = new ArrayList<Order>();
        this.listUsers = new ArrayList<User>();
        this.listProducts = new ArrayList<Product>();

    }

    @Override
    public List<Product> productsByPrice() {
        List<Product> list = this.listProducts;
        list.sort((Product p1, Product p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        return list;
    }

    @Override
    public List<Product> productsBySales() {
        List<Product> list = this.listProducts;
        list.sort((Product p1, Product p2) -> Double.compare(p1.getNumSales(), p2.getNumSales()));
        return list;
    }

    @Override
    public void addOrder(Order order) {
        listOrders.add(order);
    }

    @Override
    public Order processOrder() {
        //Coger la primera orden de la lista
        Order order = listOrders.get(0);

        //Seccion para meter la orden en la lista de ordenes que tiene el usuario
        String idUser = order.getIdUser();
        //Empezamos bucle para encontrar el indice del usuario de la orden
        boolean encontrado = false;
        int k = 0;
        while ((!encontrado) && (k < listUsers.size())) {
            if (listUsers.get(k).getId() == idUser) {
                encontrado = true;
            } else {
                k++;
            }
        }
        //Pedimos la lista de ordenes vieja
        List<Order> listOrdersActual = listUsers.get(k).getUserOrders();
        //Añadimos la orden nueva a la lista de ordenes
        listOrdersActual.add(order);
        //Subimos la lista de ordenes nueva al usuario
        listUsers.get(k).setUserOrders(listOrdersActual);

        //Un for para extraer de la orden cada LP
        for (int i = 0; i < order.lps.size(); i++) {
            //Obtenemos la id del producto en cada una de las LP
            String id = order.lps.get(i).getId();
            //Obtenemos la cantidad pedida del producto en cada una de las LP
            int quantity = order.lps.get(i).getQuantity();
            //Procedemos a buscar el producto en la lista de productos
            encontrado = false;
            int j = 0;
            while ((!encontrado) && (j < listProducts.size())) { //la segunda condicion es para que no se cree un bucle infinito en caso de que no exista
                if (listProducts.get(j).getProductId() == id) {
                    encontrado = true;
                } else {
                    j++;
                }
            }
            if (encontrado) {
                int NumSaleActual = listProducts.get(j).getNumSales();
                listProducts.get(j).setNumSales(NumSaleActual + quantity);
            }

        }
        return listOrders.remove(0);
    }

    @Override
    public List<Order> ordersByUser(String userId) {
        boolean encontrado = false;
        int k = 0;
        while ((!encontrado) && (k < listUsers.size())) {
            if (listUsers.get(k).getId() == userId) {
                encontrado = true;
            } else {
                k++;
            }
        }


        return listUsers.get(k).getUserOrders();
    }

    @Override
    public void addUser(String id, String name, String lastName) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setLastName(lastName);
        listUsers.add(user);

    }

    @Override
    public void addProduct(String productId, String description, double price) {
        Product P = new Product();
        P.ProductConstructor(productId, price, description);
        listProducts.add(P);

    }

    @Override
    public Product getProduct(String productId) {
        return null;
    }

    @Override
    public int numUsers() {
        return listUsers.size();
    }

    @Override
    public int numProducts() {
        return listProducts.size();
    }

    @Override
    public int numOrders() {
        return listOrders.size();
    }

    @Override
    public int numSales(String idProduct) {
        int NumSaleActual = 0;
        boolean encontrado = false;
        int j = 0;
        while ((!encontrado) && (j < listProducts.size())) { //la segunda condicion es para que no se cree un bucle infinito en caso de que no exista
            if (listProducts.get(j).getProductId() == idProduct) {
                encontrado = true;
            } else {
                j++;
            }
        }
        if (encontrado) {
            NumSaleActual = listProducts.get(j).getNumSales();
        }
        return NumSaleActual;
    }
}
