



package edu.mum.cs544.model;


import javax.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private int id;

    private String roomNo;

    @OneToOne
    @JoinColumn(name = "studentId")
    @Basic(optional = true)
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name = "buildingId")
    private Building building;

    @OneToOne(mappedBy = "roomNo", cascade=CascadeType.REFRESH)
    private RoomApplication roomApplications;

    public RoomApplication getRoomApplications() {
        return roomApplications;
    }

    public void setRoomApplications(RoomApplication roomApplications) {
        this.roomApplications = roomApplications;
    }

    //Constructor
    public Room() {

    }


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

  //  public Admin getAdmin() {
   //     return admin;
 //   }

   // public void setAdmin(Admin admin) {
   //     this.admin = admin;
   // }
}