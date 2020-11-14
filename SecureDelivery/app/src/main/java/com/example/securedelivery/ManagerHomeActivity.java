package com.example.securedelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ManagerHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_home);
    }

    public void workersList(View view) {
        startActivity(new Intent(ManagerHomeActivity.this, WorkersListActivity.class));
    }

    public void ordersList(View view) {
        Toast.makeText(ManagerHomeActivity.this, "I am here", Toast.LENGTH_SHORT).show();
    }

    public void assignProducts(View view) {
        Toast.makeText(ManagerHomeActivity.this, "I am here", Toast.LENGTH_SHORT).show();
    }

    public void receiveAmount(View view) {
        Toast.makeText(ManagerHomeActivity.this, "I am here", Toast.LENGTH_SHORT).show();
    }

    public void receiveProduct(View view) {
        Toast.makeText(ManagerHomeActivity.this, "I am here", Toast.LENGTH_SHORT).show();
    }

    public void complain(View view) {
        Toast.makeText(ManagerHomeActivity.this, "I am here", Toast.LENGTH_SHORT).show();
    }
}