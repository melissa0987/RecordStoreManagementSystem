package com.example.back;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.time.LocalDate;

public class Client {
    private String name; 
    private String email;
    private String phone;
    private String address;
    private MembershipLevel level;
    private double points;
    private List<Coupon> coupons;
    private Cart cart;

    private final LocalDate regisDate = LocalDate.now();
    private final DateTimeFormatter formattedRegisDate = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    public Client(){}
    public Client(String name, String email, String phone, String address, MembershipLevel level, double points){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.level = level;
        this.points = points;
        this.coupons = new ArrayList<Coupon>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStringRegisDate() {
        return this.formattedRegisDate.format(this.regisDate);
    }


    //no setter for  regisDate because it is a final attribute
    public MembershipLevel getLevel() {
        return level;
    }

    public void setLevel(MembershipLevel level) {
        this.level = level;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double newTotal) {
        this.points = newTotal;
    }
    public void setCoupons(Coupon coupon){
        this.coupons.add(coupon);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + 
                "\ne-mail: " + this.email + 
                "\nphone: " + this.phone + 
                "\naddress: " + this.address + 
                "\nregistered date: " + this.formattedRegisDate.format(this.regisDate) + 
                "\nlevel: " + this.level + 
                "\npoints: " + this.points + "\n";
    }

    /*
     * this method overrides the default method of equals()
     * --mostly used for testing, 
     * in this case, this method will be used if a client with the same infos are already created
     */
    @Override
    public boolean equals(Object o){
        if( !(o instanceof Client)){
            return false;
        }

        Client c = (Client) o;
        return this.name.equals(c.getName()) &&
                this.email.equals(c.getEmail()) &&
                this.phone.equals(c.getPhone()) &&
                this.address.equals(c.getAddress()) &&
                this.formattedRegisDate.format(this.regisDate).equals( c.getStringRegisDate() )&&
                this.level == c.getLevel() &&
                this.points == c.getPoints();
    }


    // check if user input name and email matches a client, used for signing in as a user
    public boolean clientExists(String name, String email){
        if(this.name.equals(name) && this.email.equals(email)){
            return true;
        }
        else{
            return false;
        }
    }

    //-----CART
    public void setCart(Cart cart){
        this.cart = cart;
    }
    public Cart getCart(){
        return this.cart;
    }
    //return cart total
    public double getCartTotal(){
        return this.cart.cartTotal();
    }
    //use to show client's available coupons
    public List<Coupon> getCoupons() throws IOException{
        List<Coupon> co = new ArrayList<Coupon>();
        LoadCSV csv = new LoadCSV();
        CouponList c = new CouponList(csv.loadCoupons());
        int num = 0;
        while (num < 5){
            co.add(c.get(num));
            num++;
        }
        this.coupons = co;
        return this.coupons;
    }
    //client uses coupon at position x 
    public Coupon useCoupon(int x){
        return this.coupons.get(x);
    }
    //shoes the discount value of the coupon 
    public double couponDiscountValue(int x){
        return useCoupon(x).discountValue();
    }
    //calculate the grandtotal after the discount deduction
    public double getTotalAfterDiscount(int x){
        double cartTotal = getCartTotal();
        double discount = couponDiscountValue(x);
        return cartTotal - discount;
    }
    //calculates earned points from purchase
    public int earnedPoints(){
        return this.cart.earnedPointsFromProducts();
    }

    //calculates and sets client's new total points by adding the earned points from purchase, points earned from benefits and the old points
    public double calculateNewSetPoints(){
        double clientOldPoints = this.points;
        double earnedP = earnedPoints();
        double membershipLevelPointsBenefits = this.level.gainedPoints(getCartTotal());

        double newTotal = clientOldPoints + earnedP + membershipLevelPointsBenefits;

        setPoints(newTotal);
        return newTotal;
    }


    

}
