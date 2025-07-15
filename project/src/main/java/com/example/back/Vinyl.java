
package com.example.back;
import java.sql.Date;

public class Vinyl extends Record{

    private String colour;
    private String size;
    private boolean doubleLP;
    private double price;

    public Vinyl(int itemid, String recordTitle, String artistName, String recordLabel, Date relaseDate, String genre,
            int earnedPoint, String colour, String size, boolean doubleLP, double price) 
    {
        super(itemid, recordTitle, artistName, recordLabel, relaseDate, genre, earnedPoint);
        this.colour = colour;
        this.size = size;
        this.doubleLP = doubleLP;
        this.price = price;
    }

    @Override
    public double getPrice(){
        return this.price;
    }

    @Override
    public String toString() {
        
        return  "Type: " + "Vinyl " +
        "\nProductId: " + getID() + 
        "\nTitle: " + getRecordTitle() + 
        "\nArtist: " + getArtist() + 
        "\nLabel: " + getRecordLabel() + 
        "\nRelease Date: " + getRelaseDate() + 
        "\nGenre: " + getGenre() + 
        "\nPoints Earned On Purchase: " + getEarnedPoint() + 
        "\nColour: " + this.colour + 
        "\nSize: " + this.size + 
        "\nDoubleLP: " + this.doubleLP + 
        "\nPrice: " + this.price + "\n";

    }

    // override equals, used in testing

    @Override
    public boolean equals(Object o){
        if( !(o instanceof Vinyl)){
            return false;
        }

        Vinyl v = (Vinyl) o;
        return this.getID() == v.getID() &&
                this.getRecordTitle().equals(v.getRecordTitle()) &&
                this.getArtist().equals(v.getArtist()) &&
                this.getRecordLabel().equals(v.getRecordLabel()) &&
                this.getRelaseDate().compareTo(v.getRelaseDate()) == 0 &&
                this.getGenre().equals(v.getGenre()) &&
                this.getEarnedPoint() == v.getEarnedPoint() &&
                this.colour.equals(v.colour) &&
                this.size.equals(v.size) &&
                this.doubleLP == v.doubleLP && 
                this.price == v.price;
    }

}
