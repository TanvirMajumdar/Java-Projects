package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {
   
private HashMap<String,Item> itemCollection;
    
    public HashMap<String, Item> getItemCollection(){
        return itemCollection;
    }
    
    public void setItemCollection(HashMap<String, Item> itemCollection){
        this.itemCollection=itemCollection;
    }
 
    TheSystem() throws FileNotFoundException{
        itemCollection = new HashMap<String,Item>();
      
        if (getClass().getSimpleName().equals("AppSystem")){  
                File file =new File("resources//sample.txt");
                Scanner input = new Scanner(file);
                while(input.hasNext()){                         
                    String[] itemInfo=input.nextLine().split("\\s ");
                    Item newItem = new Item();
                    newItem.setItemName(itemInfo[0]);
                    newItem.setItemDesc(itemInfo[1]);
                    newItem.setItemPrice(Double.parseDouble((itemInfo[2])));
                    newItem.setAvailableQuantity(Integer.parseInt((itemInfo[3])));
                    itemCollection.put(newItem.getItemName(),newItem);
                }
                input.close();
          
        }
    }
    
    
    public Boolean checkAvailability(Item item) {
        if (item.getQuantity()>=item.getAvailableQuantity()){
            System.out.println(String.format("System is unable to add %s to the card. System only has %s %ss ", item.getItemName(),item.getAvailableQuantity(), item.getItemName()));
            return false;
        }
        else{
            return true;
        }
    }
    
    public Boolean add(Item item) throws FileNotFoundException{
        if (item==null){
            return false;
        }
        else if(this.getItemCollection().containsKey(item.getItemName())){
            Item newItem=this.itemCollection.get(item.getItemName());
            Integer currentQuantity= newItem.getQuantity();
            newItem.setQuantity(currentQuantity+1);
            //this.itemCollection.put(item.getItemName(),newItem);
            return true;
        }
        else if (!this.getItemCollection().containsKey(item.getItemName())){
            this.itemCollection.put(item.getItemName(),item);
            return true;
        }
        else {
            return false;
        }
    }

    public Item remove(String itemName) {
        if(itemCollection.containsKey(itemName)){
            return itemCollection.remove(itemName);
        }
        else{
            return null;
        }
    }

    public abstract void display();
}
