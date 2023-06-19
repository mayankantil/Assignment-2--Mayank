package com.example.shopping;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Product> productList;
    private List<Product> cartList;
    private List<Product> buyHistory;

    private double cartTotalPrice;
    private TextView cartTextView;
    private EditText userInputEditText;
    private Button manageButton;
    private Button buyButton;

    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInputEditText = findViewById(R.id.user_input_text_view);

        // Initialize product list, cart list, and cart total price
        productList = new ArrayList<>();
        buyHistory = new ArrayList<>();
        cartList = new ArrayList<>();
        cartTotalPrice = 0.0;

        // TODO: Add products to the productList

        ListView productListView = findViewById(R.id.product_list_view);
        cartTextView = findViewById(R.id.cartTextView);
        manageButton = findViewById(R.id.manage_button);
        buyButton = findViewById(R.id.buy_button);

        // TODO: Set up product list adapter for productListView


            productList.add(new Product("Product 1", 10, 5.99));
            productList.add(new Product("Product 2", 5, 9.99));
            productList.add(new Product("Product 3", 8, 3.49));
        // Set the adapter for the product list view
            ProductAdapter productAdapter = new ProductAdapter(this, productList);
            productListView.setAdapter(productAdapter);

        updateCartTextView();

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchProduct = userInputEditText.getText().toString().trim();

                // Check if the searched product exists in the productList
                Product selectedProduct = null;
                for (Product product : productList) {
                    if (product.getTitle().equalsIgnoreCase(searchProduct)) {
                        selectedProduct = product;
                        break;
                    }
                }

                if (selectedProduct != null) {
                    // Add the selected product to the cartList
                    cartList.add(selectedProduct);
                    cartTotalPrice += selectedProduct.getPrice();
                    updateCartTextView();
                    selectedProduct.setQuantity(selectedProduct.getQuantity() - 1);
                    // Notify the productAdapter that the data has changed
                    productAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Product added to cart", Toast.LENGTH_SHORT).show();
                    // Add the purchased product to the buyHistory list
                    Product purchasedProduct = new Product(selectedProduct.getTitle(), 1, selectedProduct.getPrice());
                    buyHistory.add(purchasedProduct);
                } else {
                    Toast.makeText(MainActivity.this, "Product not found", Toast.LENGTH_SHORT).show();
                }
            }
        });



        manageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // This is for Restock
                Intent intent = new Intent(MainActivity.this, manageActivity.class);
                intent.putExtra("productList", new ArrayList<>(productList));

                // This is for History
                intent.putExtra("buyHistory", new ArrayList<>(buyHistory));

                startActivity(intent);
            }
        });



    }

    private void updateCartTextView() {
        StringBuilder cartTextBuilder = new StringBuilder();
        for (Product product : cartList) {
            cartTextBuilder.append(product.getTitle()).append("               quantity 1").append(" - " +
                    "       $").append(product.getPrice()).append("\n");
        }
        cartTextBuilder.append("Total Price: $").append(cartTotalPrice);
        cartTextView.setText(cartTextBuilder.toString());
    }
}
