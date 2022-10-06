package org.example;

public class Product {
    private String Id;
    private double Price;
    private String Description;
    private int NumSales;

    public Product ProductConstructor(String id, double price, String description){
        Product P=new Product();
        this.Id=id;
        this.Price=price;
        this.Description=description;
        return  P;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setDescription(String description) {
        Description = description;
    }
    public void setNumSales(int numSales){this.NumSales=numSales;}


    public String getProductId() {
        return this.Id;
    }

    public double getPrice() {
        return this.Price;
    }

    public String getDescription() {
        return this.Description;
    }

    public int getNumSales() {
        return this.NumSales;
    }


}
