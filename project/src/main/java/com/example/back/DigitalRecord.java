package com.example.back;

import java.sql.Date;

public class DigitalRecord extends Record {

    private String fileType;
    private String fileSize;
    private double price;

    public DigitalRecord(int itemid, String recordTitle, String artistName, String recordLabel, Date relaseDate, String genre,
            int earnedPoint, String fileType, String fileSize, double price) {
        super(itemid, recordTitle, artistName, recordLabel, relaseDate, genre, earnedPoint);
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.price = price;
    }

    @Override
    public double getPrice(){
        return this.price;
    }

    @Override
    public String toString() {
        
        return   "Type: Digital " + 
                    "\nProductId: " + getID() + 
                    "\nTitle: " + getRecordTitle() + 
                    "\nArtist: " + getArtist() + 
                    "\nLabel: " + getRecordLabel() + 
                    "\nRelease Date: " + getRelaseDate() + 
                    "\nGenre: " + getGenre() + 
                    "\nPoints Earned On Purchase: " + getEarnedPoint() + 
                    "\nFileType: " + this.fileType + 
                    "\nFileSize: " + this.fileSize + 
                    "\nPrice: " + this.price + "\n";

    }

    // override compares to, used in testing

    @Override
    public boolean equals(Object o){
        if( !(o instanceof DigitalRecord)){
            return false;
        }

        DigitalRecord d = (DigitalRecord) o;
        return this.getID() == d.getID() &&
                this.getRecordTitle().equals(d.getRecordTitle()) &&
                this.getArtist().equals(d.getArtist()) &&
                this.getRecordLabel().equals(d.getRecordLabel()) &&
                this.getRelaseDate().compareTo(d.getRelaseDate()) == 0 &&
                this.getGenre().equals(d.getGenre()) &&
                this.getEarnedPoint() == d.getEarnedPoint() &&
                this.fileSize.equals(d.fileSize) &&
                this.fileType.equals(d.fileType) &&
                this.price == d.price;
    }
    
}
