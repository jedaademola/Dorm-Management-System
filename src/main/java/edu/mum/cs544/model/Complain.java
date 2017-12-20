package edu.mum.cs544.model;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Complain implements Serializable{

    @Id
    @GeneratedValue
    private int id;

    private String subject;

    private String description;

    //@Valid
    //unidirectional relationship
    @ManyToOne //(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private Student studentId;

    @Temporal(TemporalType.DATE)
    private Date complainDate;

    //@NotEmpty(message = "{NotEmpty.validation}")
    @Column(name="feedback", columnDefinition="TEXT")
    private String feedBack;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Date getComplainDate() {
        return complainDate;
    }

    public void setComplainDate(Date complainDate) {
        this.complainDate = complainDate;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }
}
