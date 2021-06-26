package com.example;
import java.util.Map.Entry;
import java.io.FileNotFoundException;

public class CartSystem extends TheSystem {
    CartSystem() throws FileNotFoundException{
    }

    @Override
    public void display() {
        Double subTotal=0.0;
        Double tax=0.0;
        Double total=0.0;
        
        System.out.println("Cart:");
        System.out.printf("%-20s %-20s %-10s %-10s %-10s","Name","Description","Price","Quantity","Sub Total");
        System.out.println();
        for(Entry<String,Item> entry: getItemCollection().entrySet()){
            String itemName = entry.getValue().getItemName();
            String itemDesc =entry.getValue().getItemDesc();
            int itemQuant = entry.getValue().getQuantity();
            double itemPrice =itemQuant * entry.getValue().getItemPrice();
            subTotal=itemQuant*itemPrice;
            System.out.printf("%-20s %-20s %-10.2f %-10d %-10.2f", itemName, itemDesc, itemPrice, itemQuant, subTotal);
            System.out.println();
        }
        
        for(Item value: getItemCollection().values() ){
            Double totalPrice=(value.getQuantity()*value.getItemPrice());
            subTotal+=totalPrice;
        }
        
        tax=subTotal*0.05;
        total= subTotal+tax;
        System.out.printf("%-20s %-20.2f", "Pre-tax Total", subTotal);
        System.out.println();
        System.out.printf("%-20s %-20.2f", "Tax", tax);
        System.out.println();
        System.out.printf("%-20s %-20.2f", "Total", total);
        System.out.println();
    }
}
