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

public class CoursesMain extends AppCompatActivity {


    ListView courseListView;
    ArrayList<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_main);

        parseCourseJSON();

        courseListView = (ListView) findViewById(R.id.courseListView);

        ArrayAdapter<Course> adapter = new CoursesAdapter(this, courses);
        courseListView.setAdapter(adapter);

        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("DEBUG", "Item Selected");
                Intent i = new Intent(CoursesMain.this, CourseDetailActivity.class);
                i.putExtra("DATA",courses.get(position));
                startActivity(i);
            }
        }
        );

    }

    void parseCourseJSON() {
        courses = new ArrayList<Course>();

        try {
            String jsonString = loadJSONFromAsset();
            Log.d("DEBUG", jsonString);
            JSONObject jo = new JSONObject(jsonString);
            JSONArray jsonArray = jo.getJSONArray(Course.COURSE_ROOT_KEY);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject courseObj = jsonArray.getJSONObject(i);
                Course c = new Course(courseObj);
                courses.add(c);
            }
            Log.d("DEBUG",courses.toString());

        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }



    String loadJSONFromAsset(){
        String json = null;

        try {
            InputStream is = getResources().openRawResource(R.raw.courses_data);
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
