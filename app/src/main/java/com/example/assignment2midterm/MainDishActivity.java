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

public class MainDishActivity extends AppCompatActivity {

    ImageView iv_cart;
    Button btn_coq, btn_boeuf, btn_rat, btn_duck, btn_back;
    ArrayList<String> myOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_dish);

        iv_cart= findViewById(R.id.ivCart);
        btn_coq= findViewById(R.id.btnCoq);
        btn_boeuf= findViewById(R.id.btnBoeuf);
        btn_rat= findViewById(R.id.btnRat);
        btn_back = findViewById(R.id.btnBack);
        btn_duck= findViewById(R.id.btnDuck);

        Intent intent = getIntent();
        myOrder = intent.getStringArrayListExtra("myOrder");

        if (myOrder == null) {
            myOrder = new ArrayList<>();
        }

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainDishActivity.this, MainActivity2.class);
                i.putStringArrayListExtra("myOrder", myOrder);
                startActivity(i);
            }
        });

        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainDishActivity.this, CartActivity.class);
                i.putExtra("myOrder", myOrder);
                startActivity(i);
            }
        });

        btn_coq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainDishActivity.this, "Coq au Vin added to cart", Toast.LENGTH_SHORT).show();
                myOrder.add("Coq au Vin - ₱550");
            }
        });
        btn_boeuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainDishActivity.this, "Boeuf Bourguignon added to cart", Toast.LENGTH_SHORT).show();
                myOrder.add("Boeuf Bourguignon - ₱600");
            }
        });
        btn_rat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainDishActivity.this, "Ratatouille added to cart", Toast.LENGTH_SHORT).show();
                myOrder.add("Ratatouille - ₱400");
            }
        });
        btn_duck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainDishActivity.this, "Duck Confit added to cart", Toast.LENGTH_SHORT).show();
                myOrder.add("Duck Confit - ₱700");
            }
        });



    }
}