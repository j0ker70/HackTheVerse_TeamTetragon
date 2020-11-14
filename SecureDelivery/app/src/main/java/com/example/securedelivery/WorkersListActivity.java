package com.example.securedelivery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class WorkersListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workers_list);

        produceList();
    }

    private void produceList() {
        ListView listView = findViewById(R.id.workerListViewId);
        String workerName[] = {"Md Reaz", "Merajul Arefin", "Sadia Jahangir",
                                "Pranjal Kumar", "Showmik Aziz", "Ashique Mohammad",
                                "Md. Shafiqul Islam", "Nawmi Nujhat", "Munataha Tasnim", "Mohammad Badiuzzaman"};

        double rating[] = {12.68, 13.25, 20.13, 25.95, 17.42, 28.53, 11.68, 22.63, 24.12, 19.82};


        CustomAdapter customAdapter = new CustomAdapter(WorkersListActivity.this, workerName, rating);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(WorkersListActivity.this, workerName[position], Toast.LENGTH_SHORT).show();
        });

    }

    class CustomAdapter extends ArrayAdapter<String> {
        Context context;
        String rNames[];
        double rRatings[];


        public CustomAdapter(Context context, String names[], double ratings[]) {
            super(context, R.layout.row, R.id.workerNameTextViewId, names);
            this.context = context;
            this.rNames = names;
            this.rRatings = ratings;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.row, parent, false);

            TextView myNames = view.findViewById(R.id.workerNameTextViewId);
            TextView myRatings = view.findViewById(R.id.workerRatingTextViewId);

            myNames.setText(rNames[position]);
            myRatings.setText(Double.toString(rRatings[position]));

            return view;
        }
    }
}