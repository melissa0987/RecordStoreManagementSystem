package com.example.back;

import java.sql.Date;

public class CD extends Record {

    private boolean specialEdition;
    private double price;

    public CD(int itemid, String recordTitle, String artistName, String recordLabel, Date relaseDate, String genre,
            int earnedPoint, boolean specialEdition, double price) 
    {
        super(itemid, recordTitle, artistName, recordLabel, relaseDate, genre, earnedPoint);

        this.specialEdition = specialEdition;
        this.price = price;
    }

    @Override
    public double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        
        return   "Type: CD " +
        "\nProductId: " + getID() + 
        "\nTitle: " + getRecordTitle() + 
        "\nArtist: " + getArtist() + 
        "\nLabel: " + getRecordLabel() + 
        "\nRelease Date: " + getRelaseDate() + 
        "\nGenre: " + getGenre() + 
        "\nPoints Earned On Purchase: " + getEarnedPoint() + 
        "\nSpecial Edition: "  + this.specialEdition + 
        "\nPrice: " + this.price + "\n";

    }

    // override compares to, used in testing

    @Override
    public boolean equals(Object o){
        if( !(o instanceof CD)){
            return false;
        }

        CD cd = (CD) o;
        return this.getID() == cd.getID() &&
                this.getRecordTitle().equals(cd.getRecordTitle()) &&
                this.getArtist().equals(cd.getArtist()) &&
                this.getRecordLabel().equals(cd.getRecordLabel()) &&
                this.getRelaseDate().compareTo(cd.getRelaseDate()) == 0 &&
                this.getGenre().equals(cd.getGenre()) &&
                this.getEarnedPoint() == cd.getEarnedPoint() &&
                this.specialEdition == cd.specialEdition &&
                this.price == cd.price;
    }

    @Override
    public int compareTo(Record o) {
        // TODO Auto-generated method stub
        return 0;
    }

    


    
}
