package com.example.lillian.androidassignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FacultyMain extends AppCompatActivity {

    ListView facultyListView;
    ArrayList<Faculty> facultys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_main);

        parseFacultyJSON();

        facultyListView = (ListView) findViewById(R.id.facultyListView);

        ArrayAdapter<Faculty> adapter = new FacultyAdapter(this, facultys);
        facultyListView.setAdapter(adapter);


        facultyListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("DEBUG", "Item Selected");
                Intent i = new Intent(FacultyMain.this, FacultyDetailActivity.class);
                i.putExtra("DATA",facultys.get(position));
                startActivity(i);
            }
        }
        );

    }

    void parseFacultyJSON() {
        facultys = new ArrayList<Faculty>();

        try {
            String jsonString = loadJSONFromAsset();
            Log.d("DEBUG", jsonString);
            JSONObject jo = new JSONObject(jsonString);
            JSONArray jsonArray = jo.getJSONArray(Faculty.FACULTY_ROOT_KEY);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject facultyObj = jsonArray.getJSONObject(i);
                Faculty c = new Faculty(facultyObj);
                facultys.add(c);
            }
            Log.d("DEBUG",facultys.toString());
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    String loadJSONFromAsset(){
        String json = null;

        try {
            InputStream is = getResources().openRawResource(R.raw.faculty_data);
            int size = is.available();
            byte [] buffer = new byte [size];
            is.read(buffer);
            json = new String(buffer, "UTF-8");
            is.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            return json;
        }
    }
}
