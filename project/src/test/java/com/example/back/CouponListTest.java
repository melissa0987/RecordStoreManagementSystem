package com.example.back;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
public class CouponListTest {
     //Constructor
    @Test
    public void testEqualsSameConstructor() throws IOException{
        LoadCSV csv = new LoadCSV();
        CouponList cp = new CouponList(csv.loadCoupons());
        Coupon c1 = cp.get(0);

        Coupon e1 = new PercentageCoupon("TGDUA154P", 10);
        assertEquals(c1, e1);
        
    }
}
