package edu.mum.cs544.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Admin extends Person {
    private String staffId;
    @OneToMany
    @JoinColumn(name = "Student_id")
    private List<Student> students = new ArrayList<Student>();
    @OneToMany
    @JoinColumn(name = "building_id")
    private List<Building> buildings = new ArrayList<Building>();
    @OneToMany
    @JoinColumn(name = "room_id")
    private List<Room> rooms = new ArrayList<Room>();


    //Constructor
    public Admin() {
    }
    //Getters and Setters


    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
