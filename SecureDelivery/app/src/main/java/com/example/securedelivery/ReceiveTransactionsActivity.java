package com.example.securedelivery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiveTransactionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_transactions);

        receiveTransactions();
    }

    private void receiveTransactions() {
        ListView listView = findViewById(R.id.receiveTransactionListViewId);
        String[] workerName = {"Md Reaz", "Merajul Arefin", "Sadia Jahangir",
                                "Md. Shafiqul Islam", "Nawmi Nujhat", "Munataha Tasnim",
                                "Pranjal Kumar", "Showmik Aziz", "Ashique Mohammad",
                                "Nawmi Nujhat", "Munataha Tasnim", "Mohammad Badiuzzaman"};
        int[] amount = {4000, 1200, 3000, 1200, 4500, 1400, 420, 1235, 12434, 1453, 1235, 9593};

        CustomAdapter customAdapter = new CustomAdapter(ReceiveTransactionsActivity.this, workerName, amount);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(ReceiveTransactionsActivity.this, workerName[position], Toast.LENGTH_SHORT).show();
        });
    }

    class CustomAdapter extends ArrayAdapter<String> {
        Context context;
        String[] workerName;
        int[] amount;

        public CustomAdapter(Context context, String[] workerName, int[] amount) {
            super(context, R.layout.receive_transaction_row, R.id.nameReceiveTransactionTextViewId, workerName);
            this.context = context;
            this.workerName = workerName;
            this.amount = amount;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.receive_transaction_row, parent, false);

            TextView workerNameTextView = view.findViewById(R.id.nameReceiveTransactionTextViewId);
            TextView amountTextView = view.findViewById(R.id.amountReceiveTransactionTextViewId);

            workerNameTextView.setText(workerName[position]);
            amountTextView.setText("Amount: " + Integer.toString(amount[position]));

            return view;
        }
    }
}
