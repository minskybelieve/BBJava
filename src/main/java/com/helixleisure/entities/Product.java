package com.helixleisure.entities;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;
    @Column(name="quantity")
    private int quantity;
    @Column(name="saleamount")
    private double sale_amount;

    public Product() {
        id = 0L;
        name = "";
        quantity = 0;
        sale_amount = 0.0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSale_amount() {
        return sale_amount;
    }

    public void setSale_amount(double sale_amount) {
        this.sale_amount = sale_amount;
    }
}
