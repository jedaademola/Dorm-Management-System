package edu.mum.cs544.model;


import javax.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private long id;
    private String roomNo;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    private Building building;

    //Constructor
    public Room() {
    }
    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
