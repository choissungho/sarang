package com.androidproject.models;

import io.realm.RealmObject;

public class English extends RealmObject {
    private String english;
    private String text;

    public English() {

    }

    public English(String english, String text) {
        this.english = english;
        this.text = text;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
