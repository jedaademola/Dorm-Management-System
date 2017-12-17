package edu.mum.cs544.model;

import edu.mum.cs544.util.ApplicationStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RoomApplication")
public class RoomApplication implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne//(cascade = CascadeType.ALL)
   @JoinColumn(name="studentId")
    private Student student;
    @OneToOne(cascade = CascadeType.ALL)
    private Building buildingNo;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    private Date applicationDate;
    private Date arrivingDate;

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

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getArrivingDate() {
        return arrivingDate;
    }

    public void setArrivingDate(Date arrivingDate) {
        this.arrivingDate = arrivingDate;
    }

    public Building getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(Building buildingNo) {
        this.buildingNo = buildingNo;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public RoomApplication() {
    }


}
