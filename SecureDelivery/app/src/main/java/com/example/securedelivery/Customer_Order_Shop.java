package com.example.securedelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Customer_Order_Shop extends AppCompatActivity {
    Button shopbtton, cartbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__order__shop);

        shopbtton = (Button)findViewById(R.id.shop);
        shopbtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Customer_Order_Shop.this,CustomerHomeActivity.class));
            }
        });

    }
}