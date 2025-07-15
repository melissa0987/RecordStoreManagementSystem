package com.example.back;

import java.util.*;

public class RecordStore {

    private List<Record> storeProducts;
    private List<Record> filteredRecords;
    
    public RecordStore(List<Record> records){
        this.storeProducts = records;
        // filteredRecords is used when the user is filtering by price/title, and sorting
        // placed in seperate variable to allow the original list of all products to always be available
        this.filteredRecords = records;
    }

    //displays the list of products (unfiltered, unsorted)
    public void displayItems(){
        for(int i = 0; i < this.storeProducts.size(); i++){
            System.out.println(this.storeProducts.get(i));
        }
    }
    //this method returns the record at position x 
    public Record get(int x){
        if(x > this.storeProducts.size() - 1){
            throw new IllegalArgumentException("Not in store range");
        }
        return this.storeProducts.get(x);
    }
    
    //returns the size/length of the list 
    public int size(){
        return this.storeProducts.size();
    }

    //-------  FILTER METHODS
    //prints filtered profduct list
    public void displayFilteredItems(){
        for(int i = 0; i < this.filteredRecords.size(); i++){
            System.out.println(this.filteredRecords.get(i));
        }
    }

    

   
    //returns the size/length of the  filteredList 
    public int filteredSize(){
        return this.filteredRecords.size();
    }

    //this method returns the record at position x in the filteredList
    public Record getFiltered(int x){
        if(x > this.filteredRecords.size() - 1){
            throw new IllegalArgumentException("Not in store range");
        }
        return this.filteredRecords.get(x);
    }
    //filters arrayList of Records based off of a given price, all record with a lower
    // price get put in the new arrayList 

    public void filterByPrice(double maxprice){
        
        ArrayList<Record> filterRecord = new ArrayList<Record>();

        for(int i = 0; i < this.storeProducts.size(); i++){
            if(this.storeProducts.get(i).getPrice() < maxprice){
                filterRecord.add(this.storeProducts.get(i));
            }
        }

        this.filteredRecords = filterRecord;

    }

    // filter the arrayList of records based off of a given String for the title
    // if the title exists in the recordStore, it gets added to the new arrayList

    public void filterByTitle(String title){
        
        ArrayList<Record> filterRecord = new ArrayList<Record>();

        for(int i = 0; i < this.storeProducts.size(); i++){
            if(this.storeProducts.get(i).getRecordTitle().toLowerCase().contains(title.toLowerCase())){
                filterRecord.add(this.storeProducts.get(i));
            }
        }
    }

    //sets the filtered Records to equal the unfiltered ones
    public void resetStore(){
        this.filteredRecords = this.storeProducts;
    }
    
    


    //---------SORT METHODS 
    //sort records by LOWEST PRICE 
    public List<Record> sortByPrice(){
        List<Record> sortedPrice = new ArrayList<Record>();
        Collections.sort(this.storeProducts );
        for (Record r : this.storeProducts ){
            sortedPrice.add(r);
        }
        return sortedPrice;
    }
    
    //displays sorted byPrice
    public void displayProductSortedByPrice(){
        List<Record> items = sortByPrice();
        for(Record record : items){
            System.out.println( record);
        }
    }


    
    @Override
    public String toString(){
        String str = " ";
        for(int i = 0; i < this.storeProducts.size(); i++){
            str += this.storeProducts.get(i) + "\n";
        }
        return str;
    }

    
}
