package com.example.a1606020033_phamleminh;

public class ModelContact {
    private int Id;
    private String productname;
    private int price;
    private String description;
    private String producer;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
