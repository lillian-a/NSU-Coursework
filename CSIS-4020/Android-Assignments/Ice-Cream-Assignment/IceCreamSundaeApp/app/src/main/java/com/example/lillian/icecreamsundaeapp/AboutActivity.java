package com.example.lillian.icecreamsundaeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AboutActivity extends AppCompatActivity {

    TextView aboutTitleTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setTitle("About Us");
        // Frank's Ice Cream Company
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //aboutTitleTextView = (TextView) findViewById(R.id.aboutTitleTextView);
        //Intent i = getIntent();
        //String message = i.getStringExtra("DataKey");
        //aboutTitleTextView.setText(message);
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
