package edu.mum.cs544.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ResidenceAdvisor extends Person {
    private String raId;
    @OneToOne
    @JoinColumn(name = "buildingNo")
    private Building building;
}
