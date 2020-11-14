package com.example.securedelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

class Match {
    public static int WORKER = 1, MANAGER = 2, CUSTOMER = 3;
    public static int getMatch (String a, String b) {
        String worker_name = "worker";
        String manager_name = "manager";
        String customer_name = "customer";
        String worker_pass = "pass_w";
        String manager_pass = "pass_m";
        String customer_pass = "pass_c";
        if (a.equals(worker_name) && b.equals(worker_pass)) {
            return WORKER;
        } else if (a.equals(manager_name) && b.equals(manager_pass)) {
            return MANAGER;
        } else if (a.equals(customer_name) && b.equals(customer_pass)) {
            return CUSTOMER;
        }
        return 0;
    }
}

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void login(View view) {
        EditText usernameEditText = findViewById(R.id.usernameEditTextId);
        EditText passwordEditText = findViewById(R.id.passwordEditTextId);

        int match = Match.getMatch(usernameEditText.getText().toString(),
                                    passwordEditText.getText().toString());
        if (match == 0) {
            Toast.makeText(LoginActivity.this,
                    "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
        } else if (match == Match.WORKER) {
            startActivity(new Intent(LoginActivity.this, WorkerHomeActivity.class));
        } else if (match == Match.MANAGER) {
            startActivity(new Intent(LoginActivity.this, ManagerHomeActivity.class));
        } else {
            startActivity(new Intent(LoginActivity.this, CustomerHomeActivity.class));
        }
    }
}