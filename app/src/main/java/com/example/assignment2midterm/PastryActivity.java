package com.example.assignment2midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class PastryActivity extends AppCompatActivity {

    ImageView iv_cart;
    Button btn_croissant, btn_eclair, btn_macaron, btn_tartetatin, btn_back;
    ArrayList<String> myOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pastry);

        iv_cart= findViewById(R.id.ivCart);
        btn_croissant= findViewById(R.id.btnCroissant);
        btn_eclair= findViewById(R.id.btnEclair);
        btn_macaron= findViewById(R.id.btnMacaron);
        btn_back = findViewById(R.id.btnBack);
        btn_tartetatin= findViewById(R.id.btnTarteTatin);

        Intent intent = getIntent();
        myOrder = intent.getStringArrayListExtra("myOrder");

        if (myOrder == null) { // If first category, initialize list
            myOrder = new ArrayList<>();
        }

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PastryActivity.this, MainActivity2.class);
                i.putStringArrayListExtra("myOrder", myOrder);
                startActivity(i);
            }
        });

        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PastryActivity.this, CartActivity.class);
                i.putExtra("myOrder", myOrder);
                startActivity(i);
            }
        });

        btn_croissant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PastryActivity.this, "Croissant added to cart", Toast.LENGTH_SHORT).show();
                myOrder.add("Croissant - ₱150");
            }
        });
        btn_eclair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PastryActivity.this, "Éclair added to cart", Toast.LENGTH_SHORT).show();
                myOrder.add("Éclair - ₱180");
            }
        });
        btn_macaron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PastryActivity.this, "Macaron added to cart", Toast.LENGTH_SHORT).show();
                myOrder.add("Macaron - ₱200");
            }
        });
        btn_tartetatin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PastryActivity.this, "Tarte Tatin added to cart", Toast.LENGTH_SHORT).show();
                myOrder.add("Tarte Tatin - ₱250");
            }
        });




    }
}