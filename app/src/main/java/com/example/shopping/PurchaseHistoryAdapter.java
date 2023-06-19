package com.example.shopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PurchaseHistoryAdapter extends ArrayAdapter<Product> {

    private Context context;
    private List<Product> buyHistory;

    public PurchaseHistoryAdapter(Context context, List<Product> buyHistory) {
        super(context, 0, buyHistory);
        this.context = context;
        this.buyHistory = buyHistory;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_purchase_history, parent, false);
        }

        Product product = buyHistory.get(position);

        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView stockTextView = view.findViewById(R.id.stockTextView);
        TextView priceTextView = view.findViewById(R.id.priceTextView);

        titleTextView.setText(product.getTitle());
        stockTextView.setText("Stock: " + " 1");
        priceTextView.setText("Price: $" + product.getPrice());

        return view;
    }
}
