package edu.mum.cs544.model;

import javax.persistence.Entity;

@Entity
public class Student extends Person {

    private String studentId;


    //Constructor
    public Student() {
    }
    //Getters and Setters


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
