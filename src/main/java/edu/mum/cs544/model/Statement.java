package edu.mum.cs544.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Statement implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    //unidirectionals
    @OneToOne(cascade = CascadeType.ALL)
    private Room roomNo;

    @ElementCollection
    private List<Item> items;

    private String category;

    public Statement(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Room getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Room roomNo) {
        this.roomNo = roomNo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
