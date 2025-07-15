package com.example.back;

import static org.junit.Assert.*;
import org.junit.Test;

public class DollarCouponTest {
    //Constructor
    @Test
    public void testEqualsSameConstructor(){
        DollarCoupon dc1 = new DollarCoupon("rffoa133d", 5);
        DollarCoupon expected1 = new DollarCoupon("rffoa133d", 5);
        assertEquals(expected1, dc1);


        DollarCoupon dc2 = new DollarCoupon("tbfae150d", 10);
        DollarCoupon expected2 = new DollarCoupon("tbfae150d", 10);
        assertEquals(expected2, dc2);
    }

    //getter methods
    @Test
    public void testEqualsSameGetMethods(){
        DollarCoupon dc1 = new DollarCoupon("rffoa133d", 5);
        String code = "rffoa133d";
        assertEquals(code.toUpperCase(), dc1.getCouponCode());
        assertEquals(5.0, dc1.getDollarOff(), 0.001);

        DollarCoupon dc2 = new DollarCoupon("tbfae150d", 10);
        String code2 = "tbfae150d";
        assertEquals(code2.toUpperCase(), dc2.getCouponCode());
        assertEquals(10.00, dc2.getDollarOff(), 0.001);

    }
    //priceDiscounted()
    @Test
    public void testEqualsSamePriceDiscounted(){
        double price = 25.00;

        DollarCoupon dc1 = new DollarCoupon("rffoa133d", 5);
        assertEquals(20.00, dc1.priceDiscounted(price), 0.001);

        DollarCoupon dc2 =new DollarCoupon("tbfae150d", 10);
        assertEquals(15.00, dc2.priceDiscounted(price), 0.001);
    }
    //discountValue
    @Test
    public void testEqualsSameDiscountValue(){
        DollarCoupon dc1 = new DollarCoupon("rffoa133d", 5);
        assertEquals(5.0, dc1.discountValue(), 0.001);

        DollarCoupon dc2 = new DollarCoupon("tbfae150d", 10);
        assertEquals(10.0, dc2.discountValue(), 0.001);

    }

}
