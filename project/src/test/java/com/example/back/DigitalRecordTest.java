package com.example.back;

import static org.junit.Assert.*;
import java.sql.Date;

import org.junit.Test;

public class DigitalRecordTest {
    
        // testing equals method, between record and CD
        @Test
        public void equalsTest(){
    
            Record recordTest = new DigitalRecord(0, "test", "The name", "A label", Date.valueOf("2001-11-11"), "rock", 20, "mP4","100mb", 30.00);
            DigitalRecord DigitalTest = new DigitalRecord(0, "test", "The name", "A label", Date.valueOf("2001-11-11"), "rock", 20, "mP4","100mb", 30.00);
    
            if(DigitalTest.equals(recordTest)){}
            else{
                fail("Both records have the same values, should have passed");
            }
    
            //testing non-equal vinyls
    
            DigitalRecord DigitalTestUnequal = new DigitalRecord(0, "test", "The NEW name", "A label", Date.valueOf("2001-11-11"), "rock", 60, "mP4","100mb", 30.00);
    
            if(DigitalTestUnequal.equals(recordTest)){
                fail("Both records have the different values, should not have passed");
            }
            else{}
    
    } 
    
}
