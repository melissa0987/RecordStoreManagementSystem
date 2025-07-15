package com.example.back;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class VinylTest {
    
    // testing equals method, between record and vinyl
    @Test
    public void equalsTest(){

        Record recordTest = new Vinyl(0, "test", "The name", "A label", Date.valueOf("2001-11-11"), "rock", 20, "black", "large", false, 25.00);
        Vinyl vinylTest = new Vinyl(0, "test", "The name", "A label", Date.valueOf("2001-11-11"), "rock", 20, "black", "large", false, 25.00);

        if(vinylTest.equals(recordTest)){}
        else{
            fail("Both records have the same values, should have passed");
        }

        //testing non-equal vinyls

        Record recordTestUnequal = new Vinyl(0, "test", "The name", "A label", Date.valueOf("2001-11-11"), "rock", 20, "black", "large", false, 25.00);
        Vinyl vinylTestUnequal = new Vinyl(0, "NOW THIS IS DIFFERENT", "The name", "A label", Date.valueOf("2001-9-11"), "rocknroll", 20, "black", "large", false, 30.00);

        if(vinylTestUnequal.equals(recordTestUnequal)){
            fail("Both records have the different values, should not have passed");
        }
        else{}

    } 

}
