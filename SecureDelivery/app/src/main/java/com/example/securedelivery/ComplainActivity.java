package com.example.securedelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ComplainActivity extends AppCompatActivity {

    ListView simpleList;
    String countryList[] = {"Complain name1:Worker1","Complain name2:Worker2","Complain name3:Worker3","Complain name4:Worker4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);

        simpleList = (ListView)findViewById(R.id.simpleListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.acticity_main_list, R.id.textView, countryList);
        simpleList.setAdapter(arrayAdapter);
    }
}