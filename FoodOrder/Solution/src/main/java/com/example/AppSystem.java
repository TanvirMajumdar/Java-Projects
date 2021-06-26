package com.example;
import java.util.HashMap;
import java.io.FileNotFoundException;

public class AppSystem extends TheSystem {
    AppSystem() throws FileNotFoundException{
    }

    @Override
    public void display() {
        System.out.println("AppSystem Inventory:");
        System.out.printf("%-20s %-20s %-10s %-10s","Name","Description","Price","Available Quantity");
         System.out.println();
        for(HashMap.Entry<String,Item>entry:this.getItemCollection().entrySet()){
            System.out.printf("%-20s %-20s %-10.2f %-10d",entry.getValue().getItemName(),entry.getValue().getItemDesc(),entry.getValue().getItemPrice(), entry.getValue().getAvailableQuantity());
            System.out.println();
        }
    }

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
        if(item==null){
            return false;
        }
        else if(this.getItemCollection().containsKey(item.getItemName())){
            System.out.println(String.format("%s is already in the App system",item.getItemName()));
            return false;
        }
        else{
            this.getItemCollection().put(item.getItemName(),item);
            return true;
        }
    }

    public Item reduceAvailableQuantity(String item_name) {
        if(getItemCollection().containsKey(item_name)){
            Integer tot= getItemCollection().get(item_name).getAvailableQuantity()-1;
            getItemCollection().get(item_name).setAvailableQuantity(tot);
            if(tot==0)
            {
                remove(item_name);
            }
            return getItemCollection().get(item_name);
            }
        else{
            return null;
        }
    }
}
