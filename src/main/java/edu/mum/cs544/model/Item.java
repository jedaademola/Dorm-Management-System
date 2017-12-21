package edu.mum.cs544.model;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Embeddable;

@Embeddable
public class Item {

    public Item() {

    }


    private int itemId;
    @NotBlank
    private String itemName;


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int id) {
        this.itemId = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public Item(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

}
