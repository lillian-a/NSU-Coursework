package com.example.lillian.androidassignment4;

/**
 * Created by Lillian on 4/8/17.
 */

import org.json.JSONException;
import org.json.JSONObject;
import java.io.Serializable;

public class Course implements Serializable {
    public static String COURSE_ROOT_KEY = "courses";
    public static String NAME_KEY = "name";
    public static String SHORT_DESC_KEY = "shortDesc";
    public static String LONG_DESC_KEY = "longDesc";
    String name;
    String shortDesc;
    String longDesc;


    public Course (String name, String shortDesc, String longDesc) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
    }

    public Course (JSONObject jo) {
        try {
            this.name = jo.getString(NAME_KEY);
            this.shortDesc = jo.getString(SHORT_DESC_KEY);
            this.longDesc = jo.getString(LONG_DESC_KEY);
        } catch (JSONException ex){
            ex.printStackTrace();
        }
    }
    public String getName() {
        return name;
    }
    public String getShortDesc() {
        return shortDesc;
    }
    public String getLongDesc() {
        return longDesc;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAssetName() {
        return name.toLowerCase().replace(" ","_");
    }
    @Override
    public String toString() {
        return "Course{" +
			"name='" + name + "\'" +
			", shortDesc='" + shortDesc + "\'" +
			", longDesc='" + longDesc + "\'" +
			"}";
    }


}
