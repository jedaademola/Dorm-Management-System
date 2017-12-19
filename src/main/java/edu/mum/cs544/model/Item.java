package edu.mum.cs544.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    public Item() {

    }

    @Id
    @GeneratedValue
    private int itemId;

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

//    public static List<Item> itemList(){
//        List<Item> itemList = new ArrayList<>();
//
//        itemList.add(new Item(1, "Chair"));
//        itemList.add(new Item(2, "Desk"));
//        itemList.add(new Item(3, "Wardrob"));
//        itemList.add(new Item(4, "Bed"));
//
//        return itemList;
//    }


    public Item(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

}
