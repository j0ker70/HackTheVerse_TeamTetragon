package com.example.securedelivery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WorkerHomeActivity extends AppCompatActivity {

    private GridView gridView;
    String[] Options = {"Order List", "Submit Transaction", "History", "Profile"};
    int[] OptionImage = {R.drawable.order_list, R.drawable.payment, R.drawable.order_list, R.drawable.order_list};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_home);
        gridView = findViewById(R.id.gridview);
        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Toast.makeText(WorkerHomeActivity.this,"0",Toast.LENGTH_SHORT).show();
                }
                else if(i==1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(WorkerHomeActivity.this);
                    builder.setTitle("Enter the amount");
                    final View customLayout = getLayoutInflater().inflate(R.layout.custom_dialog,null);
                    builder.setView(customLayout);
                    builder.setPositiveButton(
                                    "OK",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which)
                                        {
                                            EditText editText = customLayout.findViewById(R.id.editText);
                                        }
                                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else if(i==2){
                    Toast.makeText(WorkerHomeActivity.this,"2",Toast.LENGTH_SHORT).show();
                }
                else if(i==3){
                    Toast.makeText(WorkerHomeActivity.this,"3",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    static class ViewHolder {
        public TextView name;
        ImageView image;
    }


    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return OptionImage.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = view;
            ViewHolder viewHolder;
            Log.d("Options", String.valueOf(i));
            if (view1 == null) {
                view1 = getLayoutInflater().inflate(R.layout.row_data, null);
                //getting view in row_data
                viewHolder = new ViewHolder();
                viewHolder.name = view1.findViewById(R.id.gridText);
                viewHolder.image = view1.findViewById(R.id.gridImage);
                view1.setTag(viewHolder);
            }
            {
                viewHolder = (ViewHolder) view1.getTag();
                viewHolder.name.setText(Options[i]);
                viewHolder.image.setImageResource(OptionImage[i]);
            }
            return view1;
        }

    }
}