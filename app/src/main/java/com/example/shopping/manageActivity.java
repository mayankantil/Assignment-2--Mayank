package com.example.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class manageActivity extends AppCompatActivity {
    private Button historyButton;
    private Button restockButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);


        List<Product> productList = (List<Product>) getIntent().getSerializableExtra("productList");
        List<Product> buyHistory = (List<Product>) getIntent().getSerializableExtra("buyHistory");


        historyButton = findViewById(R.id.historyButton);
        restockButton = findViewById(R.id.restockButton);
        backButton = findViewById(R.id.backButton);

        historyButton.setOnClickListener(v -> {
            //
            Intent intent = new Intent(manageActivity.this, PurchaseHistoryActivity.class);
            intent.putExtra("buyHistory", new ArrayList<>(buyHistory));
            startActivity(intent);
        });





        restockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manageActivity.this, restock.class);
                intent.putExtra("productList", new ArrayList<>(productList));
                startActivity(intent);
//                startActivity(new Intent(manageActivity.this,restock.class));
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the Back button click event
                onBackPressed();
            }
        });
    }
    public void onBackPressed() {
        finish();
    }
}
