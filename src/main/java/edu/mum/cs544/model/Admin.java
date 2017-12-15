package edu.mum.cs544.model;


import javax.persistence.Entity;

@Entity
public class Admin extends Person {
    private String staffId;

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
}
