package com.company;

import java.util.ArrayList;

public class Item {

    private String itemName;
    private String itemDescription;
    private boolean isUsable;
    private boolean isReadable;
    private boolean keyCardUsed;
    private ArrayList <Item> items = new ArrayList();

    public Item (){};

    //Item Constructer 1
    public Item(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.items = items;
    }
    //Item Constructer 2 = isUsable & isReadable added, isInsertableUsed added
    public Item(String itemName, String itemDescription, boolean isUsable, boolean isReadable) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.isUsable = isUsable;
        this.isReadable = isReadable;
        this.items = items;
    }

    public Item (String itemName, String itemDescription, boolean isUsable, boolean isReadable, boolean keyCardUsed){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.isUsable = isUsable;
        this.isReadable = isReadable;
        this.keyCardUsed = keyCardUsed;
        this.items = items;
    }

    //Item Setters
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public boolean setKeyCardUsed(boolean keyCardUsed) {
        this.keyCardUsed = keyCardUsed;
        return keyCardUsed;
    }

    //Item Getters
    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public boolean getIsReadable() {
        return isReadable;
    }

    public boolean getIsUsable() {
        return isUsable;
    }

    public boolean getKeyCardUsed() {
        return keyCardUsed;
    }

    // Item toString
    public String toString() {
        return itemDescription;
    }




}