package com.example.securedelivery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class OrdersListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_list);

        produceOrderList();
    }

    private void produceOrderList() {
        ListView listView = findViewById(R.id.ordersListViewId);
        String[] productNames = {"Air Conditioner", "Iphone", "One Plus 8", "Redmi Earphone",
                "PlayStation 5", "WebCam", "Keyboard", "MakeUp Box", "LightSabre", "Helmet"};

        String[] address = {"Mirpur-2", "Uttara", "Basabo", "Lalbag", "Shahbag", "Mohammadpur",
                "Mirpur-1", "Gulisthan", "Dhanmondi", "Azimpur"};

        int[] price = {50000, 80000, 64000, 850, 120000, 2400, 600, 3500, 69000, 1500};

        CustomAdapter customAdapter = new CustomAdapter(OrdersListActivity.this,
                                        productNames, address, price);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(OrdersListActivity.this, productNames[position], Toast.LENGTH_SHORT).show();
        });
    }

    class CustomAdapter extends ArrayAdapter<String> {
        Context context;
        String[] productNames, address;
        int[] price;

        public CustomAdapter(Context context, String[] productNames, String[] address, int[] price) {
            super(context, R.layout.order_row, R.id.orderNameTextViewId, productNames);
            this.context = context;
            this.productNames = productNames;
            this.address = address;
            this.price = price;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().
                                            getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.order_row, parent, false);

            TextView nameTextView = view.findViewById(R.id.orderNameTextViewId);
            TextView addressTextView = view.findViewById(R.id.orderAddressTextViewId);
            TextView priceTextView = view.findViewById(R.id.orderPriceTextViewId);


            nameTextView.setText(productNames[position]);
            addressTextView.setText("Address: " + address[position]);
            priceTextView.setText("Price: " + Integer.toString(price[position]) + "৳");

            return view;
        }
    }
}