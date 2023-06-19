package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class restock extends AppCompatActivity {

        // Declare variables for the views
        ListView listView;
        Intent intent;
        EditText inputField;
        Button okButton;
        Button backButton;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_restock);
            ArrayList<Product> productList = (ArrayList<Product>) getIntent().getSerializableExtra("productList");


            // Find the views by id
            listView = findViewById(R.id.list_view);
            inputField = findViewById(R.id.input_field);
            okButton = findViewById(R.id.ok_button);
            backButton = findViewById(R.id.back_button);

            // Create an ArrayList of Product objects with dummy data
//            ArrayList<Product> products = new ArrayList<>();
//        intent.putExtra("arraylist", products);
//        startActivity(intent);



//        products.add(new Product( "Product 1", 5,19.99));
//        products.add(new Product("Product 2", 6,29.99));
//        products.add(new Product( "Product 3", 7,39.99));
//        products.add(new Product( "Product 4", 5,49.99));
//        products.add(new Product("Product 5", 10,59.99));

            // Create a ProductAdapter object and pass the ArrayList of products
            ProductAdapter adapter = new ProductAdapter(this, productList);

            // Set the adapter to the ListView
            listView.setAdapter(adapter);

            // Add a listener to the OK button
            okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Get the input value from the EditText
                    String input = inputField.getText().toString();

                    // Check if the input is not empty
                    if (!input.isEmpty()) {
                        // Parse the input as an integer
                        int newStock = Integer.parseInt(input);

                        // Loop through the products and update their quantities with the new stock value
                        for (Product product : productList) {
                            product.setQuantity(newStock);
                        }

                        // Notify the adapter that the data has changed
                        adapter.notifyDataSetChanged();
                    }
                }
            });

            // Add a listener to the Back button
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Finish the activity and go back to the previous one
                    Intent intent = new Intent(restock.this, MainActivity.class);
                    startActivity(intent);

                    finish();
                }
            });
        }
    }





