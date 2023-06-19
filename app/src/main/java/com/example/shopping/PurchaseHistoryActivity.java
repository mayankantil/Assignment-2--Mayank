package com.example.shopping;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopping.Product;

import java.text.DecimalFormat;
import java.util.List;

public class PurchaseHistoryActivity extends AppCompatActivity {

    private ListView purchaseHistoryListView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);

        backButton = findViewById(R.id.backButton);

        purchaseHistoryListView = findViewById(R.id.purchaseHistoryListView);

        List<Product> buyHistory = (List<Product>) getIntent().getSerializableExtra("buyHistory");

        PurchaseHistoryAdapter adapter = new PurchaseHistoryAdapter(this, buyHistory);
        purchaseHistoryListView.setAdapter(adapter);
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
