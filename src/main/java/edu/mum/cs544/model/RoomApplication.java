package edu.mum.cs544.model;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

public class RoomApplication implements Serializable {

    private long applicationId;

   @ManyToOne(cascade = CascadeType.ALL)
    private Student studentNo;

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
