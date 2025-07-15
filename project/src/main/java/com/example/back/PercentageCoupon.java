package com.example.back;


public class PercentageCoupon extends  Coupon{
    
    public double percentageOff;
    public PercentageCoupon(){}
    /*
     * CONSTRUCTOR
     * @param double dollarOff;
     * super(String couponCode) from the parent class Coupon.java
     */
    public PercentageCoupon(String couponCode, double percentageOff){
        super(couponCode);
        this.percentageOff = percentageOff;
    }
    
    /*
     * getter method for double PercentageOff
     */
    public double getPercentageOff(){
        return this.percentageOff;
    }
    public String getCouponCode(){
        return super.getCouponCode();
    }
    /*
     * setter method double percentageOff
     * @param double percentageOff
     */
    public void setPercentageOFF(double percentageOff){
        this.percentageOff = percentageOff;
    }
    /*
     * this method calculates the discount based on the price by 
     * multiplying the price by the percentageOff
     * 
     * this method id set private since the client need to have access on how the discounted price 
     * was calculated 
     */
    private double discount(double price) {
        double discount = 0;

        //5% will be the min value
        if (this.percentageOff == 5){
            discount = price * 0.05;
        }else if(this.percentageOff == 10 ){
            discount = price * 0.10;
        }else if(this.percentageOff == 25 ){
            discount = price * 0.25;

            //50% off will be the maximum value
        }else if (this.percentageOff == 50 ){ 
            discount = price * 0.50;
        }else{
            discount = 0;
        }
        return discount;
    }

    /*
     * @Override method double priceDiscounted(double price) from the parent class 
     * 
     * this method calculates the discounted price after
     * subtracting the (product) price to the value of the coupon(percentageOff);
     */
    @Override
    public double priceDiscounted(double price){
        return price - discount(price);
    }
    
    /*
     * @Override double discountValue() from parent class Coupon.java
     * 
     *  this method will return the monetary value of the discount
     */
    @Override
    public double discountValue(){
        return getPercentageOff();
    };
    

     /*
     * this method prints the information of the coupon 
     * int percentageOff
     * super.getCouponCode() to print the couponCode 
     * super.getIssuedString() to print the issued date
     * super.getExpString() to print the expiration date
     */
    @Override
    public String toString(){
        return "PERCENTAGE Coupon: " + super.getCouponCode() + 
                "\nDiscount: " + getPercentageOff() + "%" +
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
        if( !(o instanceof PercentageCoupon)){
            return false;
        }
        PercentageCoupon dc = (PercentageCoupon)o;
        return super.getCouponCode().equals(dc.getCouponCode()) &&
                this.percentageOff == dc.getPercentageOff ();
    }
}
