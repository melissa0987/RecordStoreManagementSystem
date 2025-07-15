package com.example.back;

import static org.junit.Assert.*;


import java.sql.Date;

import org.junit.Test;

public class CDTest {
    
        // testing equals method, between record and CD
        @Test
        public void equalsTest(){
    
            Record recordTest = new CD(0, "test", "The name", "A label", Date.valueOf("2001-11-11"), "rock", 20, true, 30.00);
            CD CDTest = new CD(0, "test", "The name", "A label", Date.valueOf("2001-11-11"), "rock", 20, true, 30.00);
    
            if(CDTest.equals(recordTest)){}
            else{
                fail("Both records have the same values, should have passed");
            }
    
            //testing non-equal vinyls
    
            CD CDTestUnequal = new CD(0, "different", "The name", "A new label", Date.valueOf("2001-11-11"), "rock", 20, true, 30.00);
    
            if(CDTestUnequal.equals(recordTest)){
                fail("Both records have the different values, should not have passed");
            }
            else{}
    
    } 
    
    
}
