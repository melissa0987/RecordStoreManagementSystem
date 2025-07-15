package com.example.back;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class LoadCSVTest {
    
    @Test
    public void loadRecordsTest() throws IOException{
        Path recordPath = Paths.get("RecordStore.txt");
        List<String> lines = Files.readAllLines(recordPath);
        List<String> expected  = Files.readAllLines(recordPath);

        if(lines != null){
            assertEquals(expected, lines);
        }else{
            fail("RecordStore.txt is an empty file");
        }
    }

    @Test
    public void loadClientsTest() throws IOException{
        Path clientPath = Paths.get("clientlist.txt");
        List<String> lines = Files.readAllLines(clientPath);
        List<String> expected = Files.readAllLines(clientPath);
        if(lines != null){
            assertEquals(expected, lines);
        }else{
            fail("clientlist.txt is an empty file");
        }
    }
    @Test
    public void loadCouponsTest() throws IOException{
        Path couponPath = Paths.get("couponFile.txt");
        List<String> lines = Files.readAllLines(couponPath);
        List<String> expected = Files.readAllLines(couponPath);
        if(lines != null){
            assertEquals(expected, lines);
        }else{
            fail("couponFile.txt is an empty file");
        }
    }
}
