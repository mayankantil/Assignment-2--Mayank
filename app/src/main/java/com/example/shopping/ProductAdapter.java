package com.example.shopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    // Constructor that takes a context and a list of products
    public ProductAdapter(@NonNull Context context, @NonNull List<Product> products) {
        super(context, 0, products);
    }

    // Override the getView method to return a custom view for each item
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the product at the current position
        Product product = getItem(position);

        // Declare a ViewHolder object
        ViewHolder viewHolder;

        // Check if the convertView is null
        if (convertView == null) {
            // If null, inflate a new view from the product_item layout
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_item, parent, false);

            // Create a new ViewHolder object and assign its views
            viewHolder = new ViewHolder();
            viewHolder.title = convertView.findViewById(R.id.title);
            viewHolder.price = convertView.findViewById(R.id.price);
            viewHolder.stock = convertView.findViewById(R.id.stock);
//            viewHolder.description = convertView.findViewById(R.id.description);
//            viewHolder.ratingBar = convertView.findViewById(R.id.ratingBar);

            // Set the tag of the convertView to the viewHolder
            convertView.setTag(viewHolder);
        } else {
            // If not null, get the viewHolder from the tag of the convertView
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set the picture, title, price, description, and rating of the viewHolder from the product object
        viewHolder.title.setText(product.getTitle());
        viewHolder.price.setText("price: " + "$"+ product.getPrice());
        viewHolder.stock.setText("stock" + product.getQuantity());
        // Return the convertView
        return convertView;
    }

    // A static class that holds the views of each item
    static class ViewHolder {
        TextView title;
        TextView stock;
        TextView price;

    }
}







































//package com.example.shopping;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import java.util.List;
//
//public class ProductAdapter extends ArrayAdapter<Product> {
//
//    // Constructor that takes a context and a list of products
//    public ProductAdapter(@NonNull Context context, @NonNull List<Product> products) {
//        super(context, 0, products);
//    }
//
//    // Override the getView method to return a custom view for each item
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        // Get the product at the current position
//        Product product = getItem(position);
//
//        // Declare a ViewHolder object
//        ViewHolder viewHolder;
//
//        // Check if the convertView is null
//        if (convertView == null) {
//            // If null, inflate a new view from the product_item layout
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_item, parent, false);
//
//            // Create a new ViewHolder object and assign its views
//            viewHolder = new ViewHolder();
//            viewHolder.title = convertView.findViewById(R.id.title);
//            viewHolder.stock = convertView.findViewById(R.id.stock);
//            viewHolder.price = convertView.findViewById(R.id.price);
//
//
//            // Set the tag of the convertView to the viewHolder
//            convertView.setTag(viewHolder);
//        } else {
//            // If not null, get the viewHolder from the tag of the convertView
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//
//        // Set the  title, quantity,  price, of the viewHolder from the product object
//        viewHolder.title.setText(product.getTitle());
//        viewHolder.stock.setText(product.getStock());
////        viewHolder.price.setText(product.getPrice());
//
//
//        return convertView;
//    }
//
//    // A static class that holds the views of each item
//    static class ViewHolder {
//        TextView title;
//        TextView stock;
//        TextView price;
//    }
//}
