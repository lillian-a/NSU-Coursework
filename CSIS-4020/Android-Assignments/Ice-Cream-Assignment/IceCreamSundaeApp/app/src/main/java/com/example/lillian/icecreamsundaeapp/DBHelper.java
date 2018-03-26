package com.example.lillian.icecreamsundaeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.id;

/**
 * Created by Lillian on 3/23/17.
 */

//public class DBHelper extends SQLiteOpenHelper {

//    public static final String DATABASE_NAME = "IceCreamOrders.db";
//    public static final String ICE_CREAM_TABLE_NAME = "icecream";
//    public static final String ICE_CREAM_COLUMN_ORDER_ID = "orderid";
//    public static final String ICE_CREAM_COLUMN_DATE = "date";
//    public static final String ICE_CREAM_COLUMN_SIZE = "size";
//    public static final String ICE_CREAM_COLUMN_FLAVOR = "flavor";
//    public static final String ICE_CREAM_COLUMN_PRICE = "price";
//
//    private HashMap hp;
//
//    public DBHelper(Context context) {
//        super(context, DATABASE_NAME , null, 1);
//    }
//
//    public ArrayList<OrderItem> getAllOrders () {
//
//    }
//
//
//    public void printOrders() {
//
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(
//                "create table icecream " +
//                        "(orderid integer primary key, date text, size text,flavor text, price text)"
//        );
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS icecream");
//        onCreate(db);
//    }
//
//    public boolean insertIceCream (Integer orderid, String date, String size, String flavor, String price) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("orderid", orderid);
//        contentValues.put("date", date);
//        contentValues.put("size", size);
//        contentValues.put("flavor", flavor);
//        contentValues.put("price", price);
//        db.insert("icecream", null, contentValues);
//        return true;
//    }
//}
