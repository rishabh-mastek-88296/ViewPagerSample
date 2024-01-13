package com.example.myapplication;

import java.io.Serializable;

public class StudentModel implements Serializable {

    private String name;
    private String subject;

    public StudentModel(String name, String subject) {

        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
