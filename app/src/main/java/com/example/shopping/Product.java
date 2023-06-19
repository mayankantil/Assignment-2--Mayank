package com.example.shopping;

import java.io.Serializable;

public class Product implements Serializable {

    // Declare private fields for the product attributes
    public String title;
    public int stock;
    public double price;
    public int quantity;

    // Create a constructor that takes all the attributes as parameters
    public Product(String title, int stock, double price) {
        this.title = title;
        this.price = price;

        this.quantity = 13; // Set the initial quantity to zero
    }

    // Create getters and setters for each field


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void decreaseStock() {
        if (quantity > 0) {
            quantity--;
        }
    }
}


















