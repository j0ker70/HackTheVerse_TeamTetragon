package com.example.securedelivery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Order_List_for_Workers_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__list_for__workers_);
        worker_delivery_OrderList();
    }

    private void worker_delivery_OrderList() {
        ListView listView = findViewById(R.id.workers_delivery_orders_ListViewId);
        String[] orderID = {"Order No - 1021", "Order No - 3001", "Order No - 4356", "Order No - 3217",
                "Order No - 2489", "Order No - 6712", "Order No - 5738", "Order No - 8076", "Order No - 7629",
                "Order No - 4981"};

        String[] address = {"Mirpur-2", "Uttara", "Basabo", "Lalbag", "Shahbag", "Mohammadpur",
                "Mirpur-1", "Gulisthan", "Dhanmondi", "Azimpur"};

        int[] price = {50000, 80000, 64000, 850, 120000, 2400, 600, 3500, 69000, 1500};
     //   int[] OTP = {265478, 162876, 981027, 652871, 682719, 378291, 871965, 209817, 519065, 420981};
        String[] OTP = {"1", "2", "3", "4", "5", "6"," 7", "8"," 9", "10"};

        CustomAdapter customAdapter = new CustomAdapter(Order_List_for_Workers_Activity.this,
                orderID, address, price);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
//            Toast.makeText(Order_List_for_Workers_Activity.this, orderID[position], Toast.LENGTH_SHORT).show();

  //          Toast.makeText(this, "Yes is clicked", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder OTP_Checker_Builder = new AlertDialog.Builder(Order_List_for_Workers_Activity.this);
            View OTP_Checker_View = getLayoutInflater().inflate(R.layout.alert_dialog_workers_delivery_otp,null);
            final EditText OTP_from_User_Edittext = (EditText) OTP_Checker_View.findViewById(R.id.give_OTP_Edittext);

            OTP_Checker_Builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            OTP_Checker_Builder.setView(OTP_Checker_View);

            final AlertDialog OTP_CHECKER_AlertDialog = OTP_Checker_Builder.create();

            OTP_CHECKER_AlertDialog.setCanceledOnTouchOutside(false);
            OTP_Checker_Builder.setCancelable(false);
            OTP_CHECKER_AlertDialog.show();

            OTP_CHECKER_AlertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String input_form_user=OTP_from_User_Edittext.getText().toString();
                    if ( !input_form_user.isEmpty()) {
                        String corresponding_order_OTP = OTP[position];
                       // Toast.makeText(Order_List_for_Workers_Activity.this, input_form_user, Toast.LENGTH_SHORT).show();
                        if(input_form_user.equals(corresponding_order_OTP)) {

                            Toast.makeText(Order_List_for_Workers_Activity.this, "OTP matched", Toast.LENGTH_SHORT).show();
                            OTP_CHECKER_AlertDialog.dismiss();
                        }
                        else
                            Toast.makeText(Order_List_for_Workers_Activity.this, "Unsucesful ! You must have to provide OTP that was given when you ordered the product", Toast.LENGTH_SHORT).show();

                    }
                     else if (input_form_user.isEmpty())
                        Toast.makeText(Order_List_for_Workers_Activity.this, "You must have to provide OTP that was given when you ordered the product", Toast.LENGTH_SHORT).show();


                }
            });



        });
    }

    class CustomAdapter extends ArrayAdapter<String> {
        Context context;
        String[] orderID, address;
        int[] price;

        public CustomAdapter(Context context, String[] orderID, String[] address, int[] price) {
            super(context, R.layout.order_row, R.id.orderNameTextViewId, orderID);
            this.context = context;
            this.orderID = orderID;
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


            nameTextView.setText(orderID[position]);
            addressTextView.setText("Address: " + address[position]);
            priceTextView.setText("Price: " + Integer.toString(price[position]) + "৳");

            return view;
        }
    }
}