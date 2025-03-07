package com.example.assignment2midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    Button btn_menu;
    ListView lv_order;
    ArrayList<String> orders;
    TextView tv_total;
    int totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        lv_order = findViewById(R.id.lvOrders);
        btn_menu = findViewById(R.id.btnMenu);
        tv_total = findViewById(R.id.tvTotal);

        Intent intent = getIntent();
        orders = intent.getStringArrayListExtra("myOrder");

        if (orders == null) { // If first category, initialize list
            orders = new ArrayList<>();
        }

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(CartActivity.this, android.R.layout.simple_list_item_1, orders);
        lv_order.setAdapter(myAdapter);

        for (String order : orders) {
            totalPrice += extractPrice(order);
        }
        tv_total.setText("Total: ₱" + totalPrice);


        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartActivity.this, MainActivity2.class);
                i.putStringArrayListExtra("myOrder", orders);
                startActivity(i);
            }
        });


    }

    private int extractPrice(String item) {
        try {
            String[] parts = item.split(" - ₱");  // Splitting the string at " - ₱"
            return Integer.parseInt(parts[1]); // Convert price to integer
        } catch (Exception e) {
            return 0;  // Return 0 if there's an error
        }
    }
}