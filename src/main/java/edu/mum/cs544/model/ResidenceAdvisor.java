
package edu.mum.cs544.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ResidenceAdvisor extends Student {

    /// private String raId;

    @OneToOne
    @JoinColumn(name = "buildingNo")
    private Building building;

    public ResidenceAdvisor() {
    }

    //Getters and Setters

    //public String getRaId() {
    //    return raId;
    //  }

    //  public void setRaId(String raId) {
    //     this.raId = raId;
    //   }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

}

