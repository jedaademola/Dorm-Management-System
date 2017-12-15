package edu.mum.cs544.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Student extends Person {

    private String studentId;

    @ManyToOne
    private Room room;
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
