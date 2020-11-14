package com.example.securedelivery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

public class AssignProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_products);
    }

    public void chooseWorkers(View view) {
        String[] workerName = {"Md Reaz", "Merajul Arefin", "Sadia Jahangir",
                "Pranjal Kumar", "Showmik Aziz", "Ashique Mohammad",
                "Md. Shafiqul Islam", "Nawmi Nujhat", "Munataha Tasnim", "Mohammad Badiuzzaman"};

        boolean[] checkedWorkers = new boolean[workerName.length];

        ArrayList<String> chosenWorkers = new ArrayList<>();

        AlertDialog.Builder builder = new AlertDialog.Builder(AssignProductsActivity.this);
        builder.setTitle("Choose Workers");
        builder.setMultiChoiceItems(workerName, checkedWorkers, (dialog, which, isChecked) -> {
            if (isChecked) {
                chosenWorkers.add(workerName[which]);
            } else {
                chosenWorkers.remove(workerName[which]);
            }
        });
        builder.setCancelable(false);
        builder.setPositiveButton("OK", (dialog, which) -> {
            for (String name : chosenWorkers) {
                System.out.println(name);
            }
        });
        builder.setNegativeButton("Dismiss", (dialog, which) -> {
            dialog.dismiss();
        });
        builder.setNeutralButton("Clear All", (dialog, which) -> {
            Arrays.fill(checkedWorkers, false);
            chosenWorkers.clear();
        });

        builder.create().show();
    }
}