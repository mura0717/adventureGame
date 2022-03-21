package com.company;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private String itemName;
    private String itemDescription;

 public Item(String itemDescription, String itemName) {
     this.itemName = itemName;
     this.itemDescription = itemDescription;



 }

/*
 // ??? Find Item metode ???
 public String[] findItem (String[] itemFind) {

     String[] itemFindToDo = {"KEY", "KEYCARD", "KNIFE", "FLASHLIGHT", "SANDWICH", "METAL VALVE"};

return itemFind;

 }

*/

 /* // Det var bare et forsøg på at lave Get og Set til Item classen/Objeket ??

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


*/

    // Room toString
    public String toString() {
        return itemDescription + """
                
                """ + itemName;
    }


}
