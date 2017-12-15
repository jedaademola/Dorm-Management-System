package edu.mum.cs544.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

public class RoomApplication implements Serializable {

    private long applicationId;

    private Date applicationDate;
    private Date arrivingDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Building buildingPreference;

    public RoomApplication() {
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
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

    public Building getBuildingPreference() {
        return buildingPreference;
    }

    public void setBuildingPreference(Building buildingPreference) {
        this.buildingPreference = buildingPreference;
    }
}
