package com.example.lillian.androidassignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CourseDetailActivity extends AppCompatActivity {

    Course c;
    TextView detailCourseName, detailCourseShortDesc, detailCourseLongDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        Intent i = getIntent();
        c = (Course) i.getSerializableExtra("DATA");

        detailCourseName = (TextView) findViewById(R.id.detailCourseNameTextView);
        detailCourseShortDesc = (TextView) findViewById(R.id.detailCourseShortDescTextView);
        detailCourseLongDesc = (TextView) findViewById(R.id.detailCourseLongDescTextView);

        detailCourseName.setText(c.getName());
        detailCourseShortDesc.setText(c.getShortDesc());
        detailCourseLongDesc.setText(c.getLongDesc());


    }
}
