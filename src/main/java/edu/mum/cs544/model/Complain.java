package edu.mum.cs544.model;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;


@Entity
public class Complain implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    private String subject;

    private String description;

    @Valid
    //unidirectional relationship
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
