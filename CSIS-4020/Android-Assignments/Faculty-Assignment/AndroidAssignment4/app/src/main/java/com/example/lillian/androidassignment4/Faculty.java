package com.example.lillian.androidassignment4;

/**
 * Created by Lillian on 4/8/17.
 */

import org.json.JSONException;
import org.json.JSONObject;
import java.io.Serializable;

public class Faculty implements Serializable {
    public static String FACULTY_ROOT_KEY = "faculty";
    public static String CATEGORY_KEY = "category";
    public static String USER_NAME_KEY = "userName";
    public static String MIDDLE_NAME_KEY = "middleName";
    public static String DEGREE_KEY = "degree";
    public static String FIRST_NAME_KEY = "firstName";
    public static String LAST_NAME_KEY = "lastName";
    public static String TITLE_KEY = "title";
    public static String BIO_KEY = "bio";
    String category;
    String userName;
    String middleName;
    String degree;
    String firstName;
    String lastName;
    String title;
    String bio;


    public Faculty (String category, String userName, String middleName, String degree, String firstName, String lastName, String title, String bio) {
        this.category = category;
        this.userName = userName;
        this.middleName = middleName;
        this.degree = degree;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.bio = bio;
    }

    public Faculty (JSONObject jo) {
        try {
            this.category = jo.getString(CATEGORY_KEY);
            this.userName = jo.getString(USER_NAME_KEY);
            this.middleName = jo.getString(MIDDLE_NAME_KEY);
            this.degree = jo.getString(DEGREE_KEY);
            this.firstName = jo.getString(FIRST_NAME_KEY);
            this.lastName = jo.getString(LAST_NAME_KEY);
            this.title = jo.getString(TITLE_KEY);
            this.bio = jo.getString(BIO_KEY);
        } catch (JSONException ex){
            ex.printStackTrace();
        }
    }
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
    public String getFullName() {
        String name = "";
        name += firstName;
        if (!middleName.equals("")) {
            name += " " + middleName + ".";
        }
        if (!lastName.equals("")) {
            name += " " + lastName;
        }
        if (!degree.equals("")) {
            name += ", " + degree;
        }
        return name;
    }
    public String getAssetName() {
        return userName.toLowerCase().replace(" ","_");
    }
    public String getCategory() {
        return category;
    }
    public String getUserName() {
        return userName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getDegree() {
        return degree;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getTitle() {
        return title;
    }
    public String getBio() {
        return bio;
    }
    @Override
    public String toString() {
        return "Faculty{" +
                "category=" + category + "\'" +
                "userName=" + userName + "\'" +
                "middleName=" + middleName + "\'" +
                "degree=" + degree + "\'" +
                "firstName=" + firstName + "\'" +
                "lastName=" + lastName + "\'" +
                "title=" + title + "\'" +
                "bio=" + bio + "\'" +
                "}";
    }


}
