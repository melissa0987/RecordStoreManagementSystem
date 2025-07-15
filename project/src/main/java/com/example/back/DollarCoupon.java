package com.example.back;
public class DollarCoupon extends Coupon{

    private double dollarOff;
    public DollarCoupon(){}
    /*
     * CONSTRUCTOR
     * @param double dollarOff;
     * super(String couponCode) from the parent class Coupon.java
     */
    public DollarCoupon(String couponCode, double dollarOff){
        super(couponCode);
        this.dollarOff = dollarOff;
    }
    
    /*
     * getter method for double dollarOff
     */
    public double getDollarOff(){
        return this.dollarOff;
    }
    /*
     * setter method double dollarOff
     * @param double dollarOff
     */
    public void setDollarOff(double dollarOff){
        this.dollarOff = dollarOff;
    }

    /*
     * @Override method double priceDiscounted(double price) from the parent class 
     * 
     * this method calculates the discounted price after
     * subtracting the (product) price to the value of the coupon(dollarOff);
     */
    @Override
    public double priceDiscounted(double price){
        return price - this.dollarOff;
    };

    /*
     * @Override double discountValue() from parent class Coupon.java
     * 
     *  this method will return the monetary value of the discount
     */
    @Override
    public double discountValue(){
        return getDollarOff();
    };


    /*
     * this method prints the information of the coupon 
     * int dollarOff
     * super.getCouponCode() to print the couponCode 
     * super.getIssuedString() to print the issued date
     * super.getExpString() to print the expiration date
     */
    @Override
    public String toString(){
        return "DOLLAR Coupon: " + super.getCouponCode() + 
                "\nDiscount: " + getDollarOff() + "$" + 
                "\n" + super.getIssuedString() + 
                "\n" + super.getExpString() +
                "\n";
    }

    /*
     * @Override boolean equals() method 
     * will be used to verify if the coupon is already created or not 
     */
    @Override
    public boolean equals(Object o){
        if( !(o instanceof DollarCoupon)){
            return false;
        }
        DollarCoupon dc = (DollarCoupon)o;
        return super.getCouponCode().equals(dc.getCouponCode()) &&
                this.dollarOff == dc.getDollarOff();
    }
    
}
