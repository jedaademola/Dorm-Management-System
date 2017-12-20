package edu.mum.cs544.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Statement implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buildingNo")
    private Building building;
    //unidirectionals
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roomNo")
    private Room roomNo;


    @ElementCollection
    private List<Item> items = new ArrayList<Item>();

    //   public List<Item> getItems() {
    //   return Collections.unmodifiableList(items);
    // }

    @Temporal(TemporalType.TIMESTAMP)
    private Date statementDate;

    private String category;

    public Statement() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Room getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Room roomNo) {
        this.roomNo = roomNo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Date getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(Date statementDate) {
        this.statementDate = statementDate;
    }

    public String  getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
