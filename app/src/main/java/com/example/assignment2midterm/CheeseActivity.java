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

public class CheeseActivity extends AppCompatActivity {

    ImageView iv_cart;
    Button btn_brie, btn_camembert, btn_roquefort, btn_comte, btn_back;
    ArrayList<String> myOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cheese);

        iv_cart= findViewById(R.id.ivCart);
        btn_brie= findViewById(R.id.btnBrie);
        btn_camembert= findViewById(R.id.btnCamembert);
        btn_roquefort= findViewById(R.id.btnRoquefort);
        btn_back = findViewById(R.id.btnBack);
        btn_comte= findViewById(R.id.btnComte);

        Intent intent = getIntent();
        myOrder = intent.getStringArrayListExtra("myOrder");

        if (myOrder == null) { // If first category, initialize list
            myOrder = new ArrayList<>();
        }

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheeseActivity.this, MainActivity2.class);
                i.putStringArrayListExtra("myOrder", myOrder);
                startActivity(i);
            }
        });

        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheeseActivity.this, CartActivity.class);
                i.putExtra("myOrder", myOrder);
                startActivity(i);
            }
        });

        btn_brie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CheeseActivity.this, "Brie added to cart", Toast.LENGTH_SHORT).show();
                myOrder.add("Brie - ₱400");
            }
        });
        btn_camembert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CheeseActivity.this, "Camembert added to cart", Toast.LENGTH_SHORT).show();
                myOrder.add("Camembert - ₱420");
            }
        });
        btn_roquefort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CheeseActivity.this, "Roquefort added to cart", Toast.LENGTH_SHORT).show();
                myOrder.add("Roquefort - ₱500");
            }
        });
        btn_comte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CheeseActivity.this, "Comté added to cart", Toast.LENGTH_SHORT).show();
                myOrder.add("Comté - ₱450");
            }
        });




    }
}