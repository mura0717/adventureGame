package com.company;

import java.util.ArrayList;

public class Item {

    private String itemName;
    private String itemDescription;
    private boolean isUsable;
    private boolean isReadable;
    private boolean isInsertableUsed = false;
    private ArrayList <Item> items = new ArrayList();

    //Item Constructer 1
    public Item(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.items = items;
    }
    //Item Constructer 2 = isUsable & isReadable added, isInsertableUsed added
    public Item(String itemName, String itemDescription, boolean isUsable, boolean isReadable, boolean isInsertableUsed) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.isUsable = isUsable;
        this.isReadable = isReadable;
        this.isInsertableUsed = isInsertableUsed;
        this.items = items;
    }

    //Item Setters
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setInsertableUsed(boolean insertableUsed) {
        isInsertableUsed = insertableUsed;
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

    public boolean getIsInsertableUsed() {
        return isInsertableUsed;
    }

    // Item toString
    public String toString() {
        return itemDescription;
    }


}