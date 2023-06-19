package com.example.shopping;

import java.util.ArrayList;
import java.util.List;

    public class ProductsSingleton {
        private static ProductsSingleton instance;
        private List<Product> products;

        private ProductsSingleton() {
            products = new ArrayList<>();
        }

        public static synchronized ProductsSingleton getInstance() {
            if (instance == null) {
                instance = new ProductsSingleton();
            }
            return instance;
        }

        public List<Product> getProductList() {
            return products;
        }
    }


