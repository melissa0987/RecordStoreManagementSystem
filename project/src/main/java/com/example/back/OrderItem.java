package com.example.back;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class OrderItem {
    private final LocalDate orderMade = LocalDate.now();
    private final DateTimeFormatter formattedRegisDate = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    
    private Record item;
    private int quantity;

    //constructor
    public OrderItem(Record item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    //getters
    public Record getItem(){
        return this.item;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public String getOrderMadeString(){
        return this.formattedRegisDate.format(this.orderMade);
    }
    
    //setter
    public void setItem(Record item){
        this.item = item;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    //calculate total
    public double calculateTotal(){
        return this.item.getPrice() * this.quantity;
    }
    public int getEarnedPoint() {
        return this.item.getEarnedPoint() * this.quantity;
    }

    //toString method
    @Override
    public String toString(){
        return "\n----------------\nBUYING \n" +
                "Product: " + this.item + "" + 
                "quantity: " + this.quantity + "\n";
    }
    @Override
    public boolean equals(Object o){
        if( !(o instanceof OrderItem)){
            return false;
        }
        OrderItem c = (OrderItem)o;
        return this.item == c.getItem() && this.quantity == c.getQuantity();
    }



    

    
}
