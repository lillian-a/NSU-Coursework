package com.example.lillian.androidassignment4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lillian on 4/8/17.
 */

public class CoursesAdapter extends ArrayAdapter<Course>{

    public CoursesAdapter(Context context, ArrayList<Course> courses) {
        super(context, 0, courses);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Course c = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_course_list, parent, false);
        }
        TextView nameView = (TextView) convertView.findViewById(R.id.courseNameView);
        TextView shortDescView = (TextView) convertView.findViewById(R.id.courseShortDescView);
        nameView.setText(c.getName());
        shortDescView.setText(c.getShortDesc());
        return convertView;
    }
}
