package edu.mum.cs544.model;

import java.io.Serializable;
import java.util.Date;

public class RoomApplication implements Serializable {

    private long applicationId;

    private Date applicationDate;
    private Date arrivingDate;
    private Building buildingPreference;
}
