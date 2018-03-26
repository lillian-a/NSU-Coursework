package com.example.lillian.androidassignment4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FacultyDetailActivity extends AppCompatActivity {

    Faculty f;
    TextView detailFacultyNameTextView, detailFacultyTitleTextView, detailFacultyBioTextView;
    ImageView detailFacultyImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_detail);

        Intent i = getIntent();
        f = (Faculty) i.getSerializableExtra("DATA");
        detailFacultyNameTextView = (TextView) findViewById(R.id.detailFacultyNameTextView);
        detailFacultyTitleTextView = (TextView) findViewById(R.id.detailFacultyTitleTextView);
        detailFacultyBioTextView = (TextView) findViewById(R.id.detailFacultyBioTextView);
        detailFacultyImageView = (ImageView) findViewById(R.id.detailFacultyImageView);

        detailFacultyNameTextView.setText(f.getFullName());
        detailFacultyTitleTextView.setText(f.getTitle());
        detailFacultyBioTextView.setText(f.getBio());
        detailFacultyBioTextView.setMovementMethod(new ScrollingMovementMethod());

        Context context = getBaseContext();
        int facultyID = context.getResources().getIdentifier(f.getAssetName(), "drawable", context.getPackageName());
        detailFacultyImageView.setImageResource(facultyID);

    }
    public void goToFacultyWebsite(View view) {
        String url = "http://cec.nova.edu/~" + f.getUserName();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
