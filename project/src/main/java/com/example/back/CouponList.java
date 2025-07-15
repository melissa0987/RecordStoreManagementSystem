package com.example.back;

import java.util.List;

public class CouponList {
    
    private List<Coupon> coupons;
    //private static final  Path path = Paths.get("coupons.txt");
    //String fileContent = new String(Files.readAllBytes(path));

    public CouponList(List<Coupon> coupons){
        this.coupons = coupons;
    }

    //getter 
    public List<Coupon> getCoupon(){
        return this.coupons;
    }

    @Override
    public String toString(){
        String str = " ";
        for (int i=0; i<this.coupons.size(); i++){
            str +=  this.coupons.get(i) + "\n ";
        }
        return str;
    }

    //this method returns the discount value of the coupon
    public double discount(){
        double d = 0;
        for (int i=0; i<this.coupons.size(); i++){
            d = d + this.coupons.get(i).discountValue();
        }
        return d;
    }

    //returns the size/length of the list 
    public int size(){
        return this.coupons.size();
    }
    //this method returns the coupon at position x 
    public Coupon get(int x){
        return this.coupons.get(x);
    }

    //addcoupon 
    public List<Coupon> addCoupon(Coupon coupon){
        this.coupons.add(coupon);
        return this.coupons;
    }
    public List<Coupon> getCouponList(){
        return this.coupons;
    }
    


}
