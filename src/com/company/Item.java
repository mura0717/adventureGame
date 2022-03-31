package com.company;

import java.util.ArrayList;

public class Item {

    private String itemName;
    private String itemDescription;
    private boolean isUsable;
    private boolean isReadable;
    private ArrayList <Item> items = new ArrayList();

    //Item Constructer
    public Item(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.items = items;
    }

    public Item(String itemName, String itemDescription, boolean isUsable, boolean isReadable) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.isUsable = isUsable;
        this.isReadable = isReadable;
        this.items = items;
    }

    //Item Setters
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
    //Item Getters
    public String getItemDescription() {
        return itemDescription;
    }
    public String getItemName() {
        return itemName;
    }

    // Item toString
    public String toString() {
        return itemDescription;
    }

    //not sure what this does:
  //  public void remove(Item temp) {
   // }
}