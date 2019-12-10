package com.example.android.task;

public class User {
    private String name, email, enrollment, branch;


    public User() {

    }

    public User(String name, String email, String enrollment, String branch) {
        this.name = name;
        this.email = email;
        this.enrollment = enrollment;
        this.branch = branch;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }


}




