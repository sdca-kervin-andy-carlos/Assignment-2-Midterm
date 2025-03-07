package com.example.assignment2midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Button btn_back;
    ImageView iv_cheese, iv_pastry, iv_maindish, iv_cart;
    ArrayList<String> myOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        btn_back = findViewById(R.id.btnBack);
        iv_cheese = findViewById(R.id.ivCheese);
        iv_pastry = findViewById(R.id.ivPastry);
        iv_maindish= findViewById(R.id.ivMainDish);
        iv_cart= findViewById(R.id.ivCart);

        Intent intent = getIntent();
        myOrder = intent.getStringArrayListExtra("myOrder");

        if (myOrder == null) {
            myOrder = new ArrayList<>();
        }

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                i.putStringArrayListExtra("myOrder", myOrder);
                startActivity(i);
            }
        });
        iv_cheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, CheeseActivity.class);
                i.putStringArrayListExtra("myOrder", myOrder);
                startActivity(i);
            }
        });
        iv_pastry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, PastryActivity.class);
                i.putStringArrayListExtra("myOrder", myOrder);
                startActivity(i);
            }
        });
        iv_maindish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, MainDishActivity.class);
                i.putStringArrayListExtra("myOrder", myOrder);
                startActivity(i);
            }
        });

        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, CartActivity.class);
                i.putExtra("myOrder", myOrder);
                startActivity(i);
            }
        });


    }
}