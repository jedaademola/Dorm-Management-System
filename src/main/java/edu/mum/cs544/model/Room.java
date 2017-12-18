



package edu.mum.cs544.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private int id;

    private String roomNo;

    @OneToOne
    @JoinColumn(name = "studentId")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    private Building building;

    @ManyToOne
    @JoinColumn(name="adminId")
    private Admin admin;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="itemId")
    private List<Item>items;

    //Constructor
    public Room() {
    }
    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }



    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}