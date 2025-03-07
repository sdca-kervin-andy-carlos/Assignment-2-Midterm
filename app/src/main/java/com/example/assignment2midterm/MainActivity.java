package com.example.assignment2midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_reserve;
    ArrayList<String> myOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

            btn_reserve = findViewById(R.id.btnReserve);

        Intent intent = getIntent();
        myOrder = intent.getStringArrayListExtra("myOrder");

        if (myOrder == null) {
            myOrder = new ArrayList<>();
        }

            btn_reserve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putStringArrayListExtra("myOrder", myOrder);
                    startActivity(i);
                }
        });
    }
}