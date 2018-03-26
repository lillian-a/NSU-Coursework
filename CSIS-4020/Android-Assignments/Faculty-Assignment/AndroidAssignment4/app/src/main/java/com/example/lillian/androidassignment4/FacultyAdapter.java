package com.example.lillian.androidassignment4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lillian on 4/8/17.
 */

public class FacultyAdapter extends ArrayAdapter<Faculty> {

    public FacultyAdapter(Context context, ArrayList<Faculty> facultys) {
        super(context, 0, facultys);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Faculty f = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_faculty_list, parent, false);
        }
        TextView nameView = (TextView) convertView.findViewById(R.id.facultyNameTextView);
        TextView titleView = (TextView) convertView.findViewById(R.id.facultyTitleTextView);
        ImageView facultyImageView = (ImageView) convertView.findViewById(R.id.facultyImageView);

        nameView.setText(f.getFullName());
        titleView.setText(f.getTitle());

        Context context = getContext();
        int imageID = context.getResources().getIdentifier(f.getAssetName(), "drawable", context.getPackageName());
        facultyImageView.setImageResource(imageID);

        return convertView;
    }


}
