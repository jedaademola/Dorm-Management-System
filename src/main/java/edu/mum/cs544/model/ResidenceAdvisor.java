package edu.mum.cs544.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ResidenceAdvisor {
    private String raId;
    @OneToOne
    @JoinColumn(name = "building_no")
    private Building building;
}
