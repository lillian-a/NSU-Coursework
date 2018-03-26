package com.example.lillian.icecreamsundaeapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.content.Intent;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView priceTextView;
    TextView hotFudgeSizeTextView;
    Spinner iceCreamSpinner;
    Spinner sizeSpinner;
    SeekBar hotFudgeSeekBar;
    CheckBox peanutsCheckBox;
    CheckBox mAndMCheckBox;
    CheckBox almondsCheckBox;
    CheckBox browniesCheckBox;
    CheckBox strawberriesCheckBox;
    CheckBox oreosCheckBox;
    CheckBox gummyBearCheckBox;
    CheckBox marshmallowsCheckBox;

    ArrayList<OrderItem> orders;
    int[] sizePricing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // CheckBoxes Create
        peanutsCheckBox = (CheckBox) findViewById(R.id.peanutsCheckBox);
        mAndMCheckBox = (CheckBox) findViewById(R.id.mAndMCheckBox);
        almondsCheckBox = (CheckBox) findViewById(R.id.almondsCheckBox);
        browniesCheckBox = (CheckBox) findViewById(R.id.browniesCheckBox);
        strawberriesCheckBox = (CheckBox) findViewById(R.id.strawberriesCheckBox);
        oreosCheckBox = (CheckBox) findViewById(R.id.oreosCheckBox);
        gummyBearCheckBox = (CheckBox) findViewById(R.id.gummyBearCheckBox);
        marshmallowsCheckBox = (CheckBox) findViewById(R.id.marshmallowsCheckBox);
        priceTextView = (TextView) findViewById(R.id.priceTextView);
        sizeSpinner = (Spinner) findViewById(R.id.sizeSpinner);
        iceCreamSpinner = (Spinner) findViewById(R.id.iceCreamSpinner);
        hotFudgeSeekBar = (SeekBar) findViewById(R.id.hotFudgeSeekBar);
        hotFudgeSizeTextView = (TextView) findViewById(R.id.hotFudgeSizeTextView);

        hotFudgeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                hotFudgeSizeTextView.setText(Integer.toString(progress) + " oz.");
                progressChanged = progress;
                updatePriceDisplay();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"seek bar progress:"+progressChanged, Toast.LENGTH_SHORT).show();
            }
        });

        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
                updatePriceDisplay();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        iceCreamSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
                updatePriceDisplay();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        orders = new ArrayList<OrderItem>();
        //orders.add(new OrderItem("Vanilla", "Small", 0.00));
        //orders.add(new OrderItem("Vanilla", "Small", 0.00));
        //orders.add(new OrderItem("Vanilla", "Small", 0.00));
        updatePriceDisplay();
    }

    /*  GET TOPPINGS PRICE     */
    public Double getToppingsPrice() {
        Double p = 0.00;
        if (peanutsCheckBox.isChecked()) {
            p += 0.15;
        }
        if (mAndMCheckBox.isChecked()) {
            p += 0.25;
        }
        if (almondsCheckBox.isChecked()) {
            p += 0.15;
        }
        if (browniesCheckBox.isChecked()) {
            p += 0.20;
        }
        if (strawberriesCheckBox.isChecked()) {
            p += 0.20;
        }
        if (oreosCheckBox.isChecked()) {
            p += 0.20;
        }
        if (gummyBearCheckBox.isChecked()) {
            p += 0.20;
        }
        if (marshmallowsCheckBox.isChecked()) {
            p += 0.15;
        }
        Log.d("DEBUG","p from topping: "+p);
        return p;
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        updatePriceDisplay();
        // Check which checkbox was clicked
//        switch(view.getId()) {
//            case R.id.peanutsCheckBox:
//            case R.id.mAndMCheckBox:
//            case R.id.almondsCheckBox:
//            case R.id.browniesCheckBox:
//            case R.id.strawberriesCheckBox:
//            case R.id.oreosCheckBox:
//            case R.id.gummyBearCheckBox:
//            case R.id.marshmallowsCheckBox:
//                //if (checked)
//                    updatePriceDisplay();
//                //else
//                //    updatePriceDisplay();
//                //break;
//        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            // do whatever we want for menu item
//            // ie open new activity
//            return true;
//        }
        if (id == R.id.menu_item_1) {
            //Toast.makeText(this, "Menu Order History Item selected", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, OrderHistoryActivity.class);
            i.putExtra("DataKey", orders);
            startActivity(i);
            return true;
        }
        if (id == R.id.menu_item_2) {
            // Toast.makeText(this, "Menu About Item selected", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(i);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void processTheWorks(View view) {
        Log.d("DEBUG", "The works pressed");
        setCheckBoxesTrue();
        updatePriceDisplay();
    }

    public void setCheckBoxesTrue() {
        if ( !peanutsCheckBox.isChecked() ) {
            peanutsCheckBox.setChecked(true);
        }
        if ( !mAndMCheckBox.isChecked() ) {
            mAndMCheckBox.setChecked(true);
        }
        if ( !almondsCheckBox.isChecked() ) {
            almondsCheckBox.setChecked(true);
        }
        if ( !browniesCheckBox.isChecked() ) {
            browniesCheckBox.setChecked(true);
        }
        if ( !strawberriesCheckBox.isChecked() ) {
            strawberriesCheckBox.setChecked(true);
        }
        if ( !oreosCheckBox.isChecked() ) {
            oreosCheckBox.setChecked(true);
        }
        if ( !gummyBearCheckBox.isChecked() ) {
            gummyBearCheckBox.setChecked(true);
        }
        if ( !marshmallowsCheckBox.isChecked() ) {
            marshmallowsCheckBox.setChecked(true);
        }
    }
    public void setCheckBoxesFalse() {
        if ( peanutsCheckBox.isChecked() ) {
            peanutsCheckBox.setChecked(false);
        }
        if ( mAndMCheckBox.isChecked() ) {
            mAndMCheckBox.setChecked(false);
        }
        if ( almondsCheckBox.isChecked() ) {
            almondsCheckBox.setChecked(false);
        }
        if ( browniesCheckBox.isChecked() ) {
            browniesCheckBox.setChecked(false);
        }
        if ( strawberriesCheckBox.isChecked() ) {
            strawberriesCheckBox.setChecked(false);
        }
        if ( oreosCheckBox.isChecked() ) {
            oreosCheckBox.setChecked(false);
        }
        if ( gummyBearCheckBox.isChecked() ) {
            gummyBearCheckBox.setChecked(false);
        }
        if ( marshmallowsCheckBox.isChecked() ) {
            marshmallowsCheckBox.setChecked(false);
        }
    }

    public void processResetButton(View view) {
        // Log.d("DEBUG", "Reset pressed");
        setDefaults();

    }

    public void processOrderButton(View view) {
        // Log.d("DEBUG", "Order pressed");
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Calendar c = Calendar.getInstance();
        String formattedDate = df.format(c.getTime());
        // Log.d("DEBUG", "DATE:" + formattedDate);
        orders.add(new OrderItem(formattedDate, iceCreamSpinner.getSelectedItem().toString(), sizeSpinner.getSelectedItem().toString(), getCurrentPrice()));
        Toast.makeText(this, "Your sundae is on the way! Enjoy!", Toast.LENGTH_SHORT).show();
        setDefaults();

    }

    public void updatePriceDisplay() {
        String price = "$";
        price += getCurrentPrice();
        Log.d("DEBUG", "PRICE MAIN - "+price);
        priceTextView.setText(price);
    }

    /*  GET CURRENT PRICE    */
    public Double getCurrentPrice() {
        Double p = 0.00;
        p += getSizePrice();
        Log.d("DEBUG", "PRICE 2 - " + p);
        p += getFudgePrice();
        p += getToppingsPrice();
        return round(p,2);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /*  SET DEFAULTS    */
    public void setDefaults(){
        // size small
        sizeSpinner.setSelection(0);
        // flavor vanilla
        iceCreamSpinner.setSelection(0);
        // hot fudge 1 oz
        hotFudgeSeekBar.setProgress(1);
        // toppings none
        setCheckBoxesFalse();
        updatePriceDisplay();

    }

    /*  GET SIZE PRICE     */
    public Double getSizePrice() {
        Double p = 0.00;
        int num = sizeSpinner.getSelectedItemPosition();
        if (num == 0){
            p += 2.99;
        } else if (num == 1) {
            p += 3.99;
        } else {
            p+= 4.99;
        }
        return p;
    }

    /*  GET HOT FUDGE PRICE */
    public Double getFudgePrice() {
        Double p = 0.00;
        int num = hotFudgeSeekBar.getProgress();
        if (num == 0){
            p += 0;
        } else if (num == 1) {
            p += 0.15;
        } else if (num == 2) {
            p+= 0.25;
        } else {
            p+= 0.30;
        }
        return p;
    }


}
