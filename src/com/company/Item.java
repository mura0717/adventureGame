package com.company;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private String itemName;
    private String itemDescription;

//Item Constructer
public Item(String itemName, String itemDescription) {
     this.itemName = itemName;
     this.itemDescription = itemDescription;
 }
//roomItems ArrayList


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


/*
 // ??? Find Item Method ???
 public String[] findItem (String[] itemName) {"KEY", "KEYCARD", "KNIFE", "FLASHLIGHT", "SANDWICH", "METAL VALVE"
        return findItem;
}
 String[] itemFindToDo = {"KEY", "KEYCARD", "KNIFE", "FLASHLIGHT", "SANDWICH", "METAL VALVE"};
 Det var bare et forsøg på at lave Get og Set til Item classen/Objeket ??
*/

// Item toString
    public String toString() {
        return itemName + " - " + itemDescription;
                

    }
}
