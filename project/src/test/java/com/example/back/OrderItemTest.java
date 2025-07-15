package com.example.back;

import static org.junit.Assert.*;
import org.junit.Test;

public class OrderItemTest {
    //constructor
    @Test
    public void testEqualsSameConstructor(){
        Record testRecord = new Vinyl(1,"test title", "John Silly", "RCA Records", null, "Rock", 30, "Black", "13.5", true, 35.00);

        OrderItem oi1 = new OrderItem(testRecord, 1);
        OrderItem exp1 = new OrderItem(testRecord, 1);
        assertEquals(exp1, oi1);
    }

    //getter methods
    @Test
    public void testEqualsSameGetMethods(){
        Record testRecord = new Vinyl(1,"test title", "John Silly", "RCA Records", null, "Rock", 30, "Black", "13.5", true, 35.00);

        OrderItem oi1 = new OrderItem(testRecord, 1);
        assertEquals(1, oi1.getQuantity(), 0.001);
    }
    @Test
    public void calculateTotalTest(){
        Record testRecord = new Vinyl(1,"test title", "John Silly", "RCA Records", null, "Rock", 30, "Black", "13.5", true, 35.00);

        OrderItem oi1 = new OrderItem(testRecord, 2);
        assertEquals(70.00, oi1.calculateTotal(), 0.001);
    }
    @Test
    public void getEarnedPointTest(){
        Record testRecord = new Vinyl(1,"test title", "John Silly", "RCA Records", null, "Rock", 30, "Black", "13.5", true, 35.00);

        OrderItem oi1 = new OrderItem(testRecord, 2);
        assertEquals(60.00, oi1.getEarnedPoint(), 0.001);

    }

}
