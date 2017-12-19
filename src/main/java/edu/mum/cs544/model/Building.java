package edu.mum.cs544.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Building {
    @Id
    @GeneratedValue
    private long id;
    private String buildingNo;
    private String location;



    @OneToMany(mappedBy = "building")
    private List<Room> rooms;

    @OneToOne(mappedBy = "building")
    private ResidenceAdvisor ra;

    @ManyToOne
    @JoinColumn(name="adminId")
    private Admin admin;

    //Constructor
    public Building() {
    }
    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public ResidenceAdvisor getRa() {
        return ra;
    }

    public void setRa(ResidenceAdvisor ra) {
        this.ra = ra;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

