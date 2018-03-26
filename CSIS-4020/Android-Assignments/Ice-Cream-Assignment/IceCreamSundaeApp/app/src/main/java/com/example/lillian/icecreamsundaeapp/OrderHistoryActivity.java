package com.example.lillian.icecreamsundaeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity {

    ArrayList<OrderItem> orders;
    ArrayList<String> stringOrders;
    ListView orderHistoryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        setTitle("Order History");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        orders = (ArrayList<OrderItem>) i.getSerializableExtra("DataKey");
        Log.d("DEBUG", orders.toString());

        stringOrders = new ArrayList<String>();
        for(OrderItem item: orders){
            stringOrders.add(item.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                stringOrders
        );

        // DBHelper dbhelp = new DBHelper();
        // orders = dbhelp.getAllOrders();

        orderHistoryListView = (ListView) findViewById(R.id.orderHistoryListView);

        orderHistoryListView.setAdapter(adapter);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in menu bar clicked; goto parent activity;
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
