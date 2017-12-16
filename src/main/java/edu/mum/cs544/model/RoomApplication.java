package edu.mum.cs544.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "application")
public class RoomApplication implements Serializable {

    @Id
    @GeneratedValue
    private long applicationId;

   @ManyToOne//(cascade = CascadeType.ALL)
   @JoinColumn(name="studentId")
    private Student student;
    private Date applicationDate;
    private Date arrivingDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Building buildingNO;

    private ApplicationStatus status;

    public RoomApplication() {
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }
}
