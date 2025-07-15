package com.example.back;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.example.back.Client;
import com.example.back.MembershipLevel;

public class ClientTest {
     //Constructor
     @Test
     public void testEqualsSameConstructor(){
         Client client = new Client("Melissa", "email@email.com", "514000000", "123 strt", MembershipLevel.GOLD, 210);
         Client expected = new Client("Melissa", "email@email.com", "514000000", "123 strt", MembershipLevel.GOLD, 210);
         assertEquals(expected, client);
     }
     //getter methods
     @Test
     public void testEqualsSameGetMethods(){
         Client client = new Client("Melissa", "email@email.com", "514000000", "123 strt", MembershipLevel.GOLD, 210);
         assertEquals("Melissa", client.getName());
         assertEquals("email@email.com", client.getEmail());
         assertEquals("514000000", client.getPhone());
         assertEquals("123 strt", client.getAddress());
 
         MembershipLevel level = MembershipLevel.GOLD;
         assertEquals(level, client.getLevel());
         assertEquals(210, client.getPoints(), 0.01);
     
     }

     @Test
     public void clientExistsTest(){

        Client testClient = new Client("jk", "email", "phone", "dw", MembershipLevel.BRONZE, 30);

        // should return true

        if(testClient.clientExists("jk", "email")){

        }
        else{
            fail("Shouldve reutrned true");
        }

        //should return false

        if(testClient.clientExists("wrong", "emaw3il")){
            fail("Shouldve reutrned false");
        }
        else{
        }
     }

     @Test
     public void getCouponsTest() throws IOException{

        LoadCSV csv = new LoadCSV();
        List<Coupon> compareTo = csv.loadCoupons();

        //comapre the loaded coupons to the csvCoupon list

        Client testClient = new Client("jk", "email", "phone", "dw", MembershipLevel.BRONZE, 30);
        List<Coupon> clientCoupon =  testClient.getCoupons();

        for(int i = 0; i < clientCoupon.size(); i++){
            if(clientCoupon.get(i).equals(compareTo.get(i))){
                
            }
            else{
                fail("Should have never been reached");
            }
        }

    }

    @Test
    public void couponDiscountValueTest(){

        //create new dollar coupon and set it to the client
        Coupon testCoupon = new DollarCoupon("coupon",15.0);
        Client testClient = new Client("jk", "email", "phone", "dw", MembershipLevel.BRONZE, 30);

        testClient.setCoupons(testCoupon);

        //compares coupon values at first index to expected value of 15.0
        assertEquals(15.0, testClient.couponDiscountValue(0), 0.001);

    }
    

}




