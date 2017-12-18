package edu.mum.cs544.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Student extends Person {

    private String studentId;

    @OneToOne(mappedBy = "student")
    private Room room;


    //Constructor
    public Student() {
    }

    @Override
    public String toString() {
        return studentId;
    }
//Getters and Setters


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


}
