package com.example.back;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//client has their own cart, and each time they add item to their cart, they can load the list of the store products
public class Cart {
    private final LocalDate cartMade = LocalDate.now();
    private final DateTimeFormatter formattedCartDate = DateTimeFormatter.ofPattern("MMM dd, yyyy");

    private RecordStore storeProducts;
    private List<OrderItem> cart ;


    //this method allows the client to add items to their cart
    public List<OrderItem> orderProducts(){
        //displayItems();
        List<OrderItem> orderCart = new ArrayList<OrderItem>();
        // Scanner reader = new Scanner(System.in);
        // System.out.println("selectproduct #");
        // int prodNum = reader.nextInt(); //the product number 
        // int prodQuant = reader.nextInt(); //the number of quantity
        // orderCart.add(new OrderItem(this.storeProducts.get(prodNum), prodQuant));
        return orderCart;
    }
     //constructor 
    public Cart(RecordStore storeProducts){
        this.storeProducts = storeProducts;
        //this.cart = orderProducts();
    }
    //getter
    public RecordStore getStoreProducts() {
        return storeProducts;
    }
    public List<OrderItem> getCart(){
        return this.cart;
    }
    public String getStringCartDate() {
        return this.formattedCartDate.format(this.cartMade);
    }
    //setter
    public void setStoreProducts(RecordStore storeProducts) {
        this.storeProducts = storeProducts;
    }
    public void setCart(List<OrderItem> shoppingCart){
        this.cart = shoppingCart;
    }

    //displays the product list 
    // private void displayItems(){
    //     for(int i = 0; i < this.storeProducts.size(); i++){
    //         System.out.println(this.storeProducts.get(i));
    //     }
    // }

    //sort records by LOWEST PRICE 
    public RecordStore sortByPrice(){
        return (RecordStore) this.storeProducts.sortByPrice();
    }

    //this method FILTERS the products 
    public void filterByPrice(double maxPrice){
       this.storeProducts.filterByPrice(maxPrice);
    }
    public int size(){
        return this.cart.size();
    }

   
    

    //calculate earned points
    public int earnedPointsFromProducts(){
        int points = 0;
        for (OrderItem item : this.cart ){
            points += points + item.getEarnedPoint();
        }
        return points;
    }

    //calculates the total of the cart 
    public double cartTotal(){
        double total = 0;
        //this.cart =  orderProducts();
        for(int i=0; i<this.cart .size(); i++ ){
            total = total + this.cart .get(i).calculateTotal();
        }
        return total;
    }


    /* 
    //shows the client's available coupon 
    private List<Coupon> getCouponList(Client user){
        return user.getCoupons();
    }
    //Client selects the coupon they wanna use in x position 
    private Coupon useCoupon(Client user, int x){
        List<Coupon> couponList = getCouponList(user);
        return couponList.get(x);
    }
    //calculates the discount value of the coupon
    public double discountValue(Client user, int x){
       Coupon coupon = useCoupon(user, x);
       return coupon.discountValue();
    }

    //calculates the grandTotal of the cart after discount
    public double getTotalAfterDiscount(Client user, int x){
        double cartTotal = cartTotal();
        return cartTotal - discountValue(user, x);
    }
    */

    //toString method will print the items on the cart only, the day the cart was made
    @Override
    public String toString(){
        String str =  "Transaction date: " + getStringCartDate() + "\n";
        // this.cart = orderProducts();
         String order = "";
         for (OrderItem item: this.cart ){
             order += item + "\n";
        }
        return str + " " + order +  " Total: " + cartTotal();

    }
   





    
    
}
