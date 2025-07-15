package com.example.back;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public abstract class  Coupon {
    private final LocalDate issued = LocalDate.now();
    private final LocalDate expire = issued.plusDays(30);
    private final DateTimeFormatter formattedRegisDate = DateTimeFormatter.ofPattern("MMM dd, yyyy");

    //to print it into a string
    private final String issuedString = formattedRegisDate.format(issued);
    private final String expString = formattedRegisDate.format(expire);

    private String couponCode;
    public Coupon(){}
    /*
     * constructor
     * @param String couponCode;
     */

    public Coupon(String couponCode){
        this.couponCode = couponCode;
    }
    /*
     * Getter methods for attributes 
     * String couponCode
     * String issuedString
     *  String expString
     */
    public String getCouponCode(){
        return this.couponCode.toUpperCase();
    }
    public String getIssuedString(){
        return "Issued date: " + this.issuedString;
    }
    public String getExpString(){
        return "Expiration date : " + this.expString;
    }

    /*
     * setter method for String couponCode
     * no setter codes for String issuedString & String expString
     */
    public void setCouponCode(String couponCode){
        this.couponCode = couponCode;
    }

    /*
     * this methods are ABSTRACT METHODs and 
     * each class extension will define how the method will behave 
     */
    public abstract double priceDiscounted(double price);
    public abstract double discountValue();


    @Override
    public String toString(){
        return "Coupon : " + this.couponCode + 
                getIssuedString() + "\n" + 
                getExpString() ;
    }

    @Override
    public boolean equals(Object o){
        if( !(o instanceof Coupon)){
            return false;
        }
        Coupon c = (Coupon)o;
        return this.couponCode.equals(c.getCouponCode());
    }
}
