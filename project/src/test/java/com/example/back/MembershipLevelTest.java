package com.example.back;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MembershipLevelTest {
    @Test
    public void membershipLevel(){
        MembershipLevel bronze = MembershipLevel.BRONZE;
        MembershipLevel bExpect = MembershipLevel.BRONZE;
        assertEquals(bExpect, bronze);

        MembershipLevel silver = MembershipLevel.SILVER;
        MembershipLevel silverExp = MembershipLevel.SILVER;
        assertEquals(silverExp, silver);

        MembershipLevel gold = MembershipLevel.GOLD;
        MembershipLevel goldExp = MembershipLevel.GOLD;
        assertEquals(goldExp, gold);

    }
    //gainedPoints
    @Test
    public void gainedPointsTEST(){
        double purchase = 500.0; 
        MembershipLevel bronze = MembershipLevel.BRONZE;
        assertEquals(500.0, bronze.gainedPoints(purchase), 0.001);

        MembershipLevel silver = MembershipLevel.SILVER;
        assertEquals(1000.0, silver.gainedPoints(purchase), 0.001);

        MembershipLevel gold = MembershipLevel.GOLD;
        assertEquals(1500.0, gold.gainedPoints(purchase), 0.001);
    }
}
