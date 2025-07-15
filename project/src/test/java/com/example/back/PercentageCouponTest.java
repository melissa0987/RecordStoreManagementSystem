package com.example.back;
import static org.junit.Assert.*;
import org.junit.Test;

public class PercentageCouponTest {
    //constructor
    @Test
    public void testEqualsSameConstructor(){
        PercentageCoupon pc1 = new PercentageCoupon("tgdua154p", 10);
        PercentageCoupon ex1 = new PercentageCoupon("tgdua154p", 10);
        assertEquals(ex1, pc1);


        PercentageCoupon pc2 = new PercentageCoupon("hddie52p", 5);
        PercentageCoupon ex2 = new PercentageCoupon("hddie52p", 5);
        assertEquals(ex2, pc2);
    }
    //getter methods
    @Test
    public void testEqualsSameGetMethods(){
        PercentageCoupon pc1 = new PercentageCoupon("tgdua154p", 10);
        String c1 = "tgdua154p";
        assertEquals(c1.toUpperCase(), pc1.getCouponCode());
        assertEquals(10.0, pc1.getPercentageOff(), 0.001);

        PercentageCoupon pc2 = new PercentageCoupon("hddie52p", 5);
        String c2 = "hddie52p";
        assertEquals(c2.toUpperCase(), pc2.getCouponCode());
        assertEquals(5.0, pc2.getPercentageOff(), 0.001);
    }
    //priceDiscounted()
    @Test
    public void testEqualsSamePriceDiscounted(){
        double price = 20.00;

        PercentageCoupon pc1 = new PercentageCoupon("tgdua154p", 10);
        assertEquals(18.0, pc1.priceDiscounted(price), 0.001);


        PercentageCoupon pc2 = new PercentageCoupon("hddie52p", 5);
        assertEquals(19., pc2.priceDiscounted(price), 0.001);
    }
    //discountValue
    @Test
    public void testEqualsSameDiscountValue(){
        PercentageCoupon pc1 = new PercentageCoupon("tgdua154p", 10);
        assertEquals(10.00, pc1.discountValue(), 0.001);


        PercentageCoupon pc2 = new PercentageCoupon("hddie52p", 5);
        assertEquals(5.00, pc2.discountValue(), 0.001);
    }



}
