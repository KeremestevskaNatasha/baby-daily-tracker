package com.example.dailybabytrucker.model;

public class Note {

    private String title, timeStamp;

    public Note(String title, String timeStamp) {
        this.title = title;
        this.timeStamp = timeStamp;
    }

    public String getTitle() {
        return title;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
