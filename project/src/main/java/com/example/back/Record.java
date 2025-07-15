package com.example.back;

import java.sql.Date;

public abstract class Record implements Comparable<Record>{
    
    private int itemID;
    private String recordTitle;
    private String artistName;
    private String recordLabel;
    private Date relaseDate;
    private String genre;
    private String productId;
    private int earnedPoint;
   
    public Record(int itemid, String recordTitle, String artistName, String recordLabel, Date relaseDate, String genre, int earnedPoint) {
        this.itemID = itemid;
        this.recordTitle = recordTitle;
        this.artistName = artistName;
        this.recordLabel = recordLabel;
        this.relaseDate = relaseDate;
        this.genre = genre;
        this.earnedPoint = earnedPoint;
    }

    //getters and setters

    public String getRecordTitle() {
        return recordTitle;
    }
    public void setRecordTitle(String recordTitle) {
        this.recordTitle = recordTitle;
    }
    public String getArtist() {
        return artistName;
    }
    public void setArtist(String artistName) {
        this.artistName = artistName;
    }
    public String getRecordLabel() {
        return recordLabel;
    }
    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }
    public Date getRelaseDate() {
        return relaseDate;
    }
    public void setRelaseDate(Date relaseDate) {
        this.relaseDate = relaseDate;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public int getEarnedPoint() {
        return earnedPoint;
    }
    public void setEarnedPoint(int earnedPoint) {
        this.earnedPoint = earnedPoint;
    }
    public int getID(){
        return this.itemID;
    }

    //toString

    @Override
    public String toString() {
        return   " ProductId: " + itemID + "Title: " + recordTitle + " Artist: " + this.artistName + " Label: " + recordLabel
                + " Release Date: " + relaseDate + " Genre: " + genre + "Points Earned On Purchase: " + this.earnedPoint;
    }

    //Abstract methods
    public abstract double getPrice();

    //using Comparator to sort 
    @Override
    public int compareTo(Record o ){
        double comparePrice = ((Record)o).getPrice();

        //accending order
        return (int) (this.getPrice() - comparePrice);
    }

    //compares the artist name ASCENDING ORDER
    /*public int compareArtistName(Record r1, Record r2){
        String artist1 = r1.getArtistName();
        String artist2 = r2.getArtistName();

        return artist1.compareTo(artist2);
    }

    //compares the release date ASCENDING ORDER
    public int compareReleaseDate(Record r1, Record r2){
        Date artist1 = r1.getRelaseDate();
        Date artist2 = r2.getRelaseDate();

        return artist1.compareTo(artist2);
    }
    
    public List<Record> getDesArt() {
        return null;
    }
    */



}

