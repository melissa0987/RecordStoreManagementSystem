package com.example.back;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import org.junit.Test;

public class RecordStoreTest {
    
    @Test
    public void filterByPriceTest(){

        //create a new RecordStore object with one record stored inside
        // only price matters for this test, so the rest of the parameters can be null

        Record testRecord = new Vinyl(0, "test", null, null, null, null, 0, null, null, false, 25.00);
        List<Record> testList = new ArrayList<Record>();
        testList.add(testRecord);
        RecordStore testStore = new RecordStore(testList);

        //check if record is filtered if given price is higher than 25
        // as given number is higher than the record price, should not be filtered out and size remains 1
        
        testStore.filterByPrice(30);
        assertEquals(testStore.filteredSize(), 1);

        //check if record is filtered if given price is lower than 25
        // as given number is lower  than the record price, size should become 0

        testStore.filterByPrice(15);
        assertEquals(testStore.filteredSize(), 0);

    }

    @Test
    public void filterByTitleTest(){

        Record testRecord = new Vinyl(0, "testName", null, null, null, null, 0, null, null, false, 25.00);
        List<Record> testList = new ArrayList<Record>();
        testList.add(testRecord);
        RecordStore testStore = new RecordStore(testList);

        //checks if given string is contained in record title
        // given string "sTn" is, so it should not be filtered

        testStore.filterByTitle("sTn");
        assertEquals(testStore.filteredSize(), 1);

        //given string "sTz" is not contained in recordTitle, so should be filtered

        testStore.filterByTitle("sTz");
        assertEquals(testStore.filteredSize(), 1);

    }

    @Test
    public void getTest(){

        Record testRecord = new Vinyl(0, "testName", "testname", "whatever", Date.valueOf("1999-11-11"), "rock", 0, "black ", "13.5", false, 25.00);
        List<Record> testList = new ArrayList<Record>();
        testList.add(testRecord);
        RecordStore testStore = new RecordStore(testList);

        //get test at position 0, should equal testRecord

        assertEquals(testStore.get(0), testRecord);

        //at position 1, should throw IllegakArg

        try{
            testStore.get(1);
            fail("Shouldve been caught");
        }
        catch(IllegalArgumentException e){}
    }

    @Test
    public void getFilteredTest(){

        Record testRecord = new Vinyl(0, "testName", "testname", "whatever", Date.valueOf("1999-11-11"), "rock", 0, "black ", "13.5", false, 25.00);
        List<Record> testList = new ArrayList<Record>();
        testList.add(testRecord);
        RecordStore testStore = new RecordStore(testList);

        //filter the List so it filters out the testRecord
        
        testStore.filterByTitle("sZn");

        //get test at position 1, should throw exception as list is filtered to be empty

        try{
            testStore.getFiltered(1);
            fail("Shouldve been caught");
        }
        catch(IllegalArgumentException e){} 

    }

    @Test
    public void resetStoreTest(){
        
        // create a recordStore, filter out the one item, then reset the store back to the original
        Record testRecord = new Vinyl(0, "testName", "testname", "whatever", Date.valueOf("1999-11-11"), "rock", 0, "black ", "13.5", false, 25.00);
        List<Record> testList = new ArrayList<Record>();
        testList.add(testRecord);
        RecordStore testStore = new RecordStore(testList);

        //filter the List so it filters out the testRecord
        
        testStore.filterByTitle("sZn");

        testStore.resetStore();

        // test if each record in the store is == to the filteredStore

        for(int i = 0; i < testStore.size(); i++){
            assertEquals(testStore.get(i),testStore.getFiltered(i));
        }

    }

}
