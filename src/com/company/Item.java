package com.company;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private String itemName;
    private String itemDescription;

//Item Constructer
public Item(String itemDescription, String itemName) {
     this.itemName = itemName;
     this.itemDescription = itemDescription;
 }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    private String[] items = {"KEY", "KEYCARD", "KNIFE", "FLASHLIGHT", "SANDWICH", "METAL VALVE"};
    private ArrayList<String> roomItems = new ArrayList<String>(List.of(items));

    public void setItemsList(ArrayList<String> itemsList) {
        this.roomItems = itemsList;
    }
    public ArrayList<String> getItemsList() {
        return roomItems;
    }
    /*
 // ??? Find Item Method ???
 public String[] findItem (String[] itemName) {"KEY", "KEYCARD", "KNIFE", "FLASHLIGHT", "SANDWICH", "METAL VALVE"
        return findItem;
}
     //String[] itemFindToDo = {"KEY", "KEYCARD", "KNIFE", "FLASHLIGHT", "SANDWICH", "METAL VALVE"};

*/

// Det var bare et forsøg på at lave Get og Set til Item classen/Objeket ??

    // Room toString
    public String toString() {
        return itemDescription + """
                
                """ + itemName;
    }
}
