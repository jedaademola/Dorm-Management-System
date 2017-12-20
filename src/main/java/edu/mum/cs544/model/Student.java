package edu.mum.cs544.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends Person {

    private String studentId;

    @OneToOne(mappedBy = "student", cascade= CascadeType.ALL)
    private Room room;

    @OneToMany(mappedBy = "studentId", cascade= CascadeType.ALL)
    private  List<Complain> complains;



    //Constructor
    public Student() {
        complains = new ArrayList<>();
    }

    @Override
    public String toString() {
        return studentId;
    }


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
