package com.example.securedelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CustomerHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);
    }

    public void placeordercamera(View view) {
        Toast.makeText(CustomerHomeActivity.this, "camera ordered", Toast.LENGTH_SHORT).show();
    }

    public void placeorderphone(View view) {
        Toast.makeText(CustomerHomeActivity.this, "phone ordered", Toast.LENGTH_SHORT).show();
    }

    public void placeordermouse(View view) {
        Toast.makeText(CustomerHomeActivity.this, "mouse ordered", Toast.LENGTH_SHORT).show();
    }

    public void placeorderSoundBox(View view) {
        Toast.makeText(CustomerHomeActivity.this, "soundbox ordered", Toast.LENGTH_SHORT).show();
    }

    public void placeorderheadphone(View view) {
        Toast.makeText(CustomerHomeActivity.this, "headphone ordered", Toast.LENGTH_SHORT).show();
    }

    public void placeorderwatch(View view) {
        Toast.makeText(CustomerHomeActivity.this, "watch ordered", Toast.LENGTH_SHORT).show();
    }
}