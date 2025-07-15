package com.example.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class LoadCSV implements LoadProducts {
    
    private static final Path recordPath = Paths.get("RecordStore.txt");
    private static final Path clientPath = Paths.get("clientlist.txt");
    private static final Path couponPath = Paths.get("couponFile.txt");

    public LoadCSV(){
    }

    public List<Record> loadRecords() throws IOException{
        
        List<String> lines = Files.readAllLines(LoadCSV.recordPath);
        ArrayList<Record> records = new ArrayList<Record>();

            for(String line : lines){
                String[] recordString = line.split(",");
                switch (recordString[0]) {
                    case "Vinyl":
                        try{
                            records.add(new Vinyl(Integer.parseInt(recordString[1]), recordString[2], recordString[3], recordString[4], Date.valueOf(recordString[5]), recordString[6], Integer.parseInt(recordString[7]), recordString[8], recordString[9], Boolean.parseBoolean(recordString[10]), Double.parseDouble(recordString[11])));
                        }
                        catch(IllegalArgumentException e){
                            throw new IOException("Error in IO file, line " + lines);
                        }
                      break;
                    case "CD":
                        try{   
                            records.add(new CD(Integer.parseInt(recordString[1]), recordString[2], recordString[3], recordString[4], Date.valueOf(recordString[5]), recordString[6], Integer.parseInt(recordString[7]), Boolean.parseBoolean(recordString[8]), Double.parseDouble(recordString[9])));
                        }
                        catch(IllegalArgumentException e){
                            throw new IOException("Error in IO file, line " + lines);
                        }
                        break;
                    case "DigitalRecord":
                        try{
                            records.add(new DigitalRecord(Integer.parseInt(recordString[1]), recordString[2], recordString[3], recordString[4], Date.valueOf(recordString[5]), recordString[6], Integer.parseInt(recordString[7]), recordString[8], recordString[9], Double.parseDouble(recordString[10])));
                        }
                        catch(IllegalArgumentException e){
                            throw new IOException("Error in IO file, line " + lines);
                        }
                        break;
                   default:
                        throw new IOException("Error in IO file, line " + lines);
                }
            }
    
        return records;
    }

    public List<Client> loadClients() throws IOException{
            
        List<String> lines = Files.readAllLines(LoadCSV.clientPath);
        ArrayList<Client> clientList = new ArrayList<Client>();
        
        for(String line : lines){
            String[] clientString = line.split(",");
            
            try{
                clientList.add(new Client(clientString[0], clientString[1], clientString[2], clientString[3], MembershipLevel.valueOf(clientString[4].toUpperCase()), Double.parseDouble(clientString[5])));
            }
            catch(IllegalArgumentException e){
                throw new IOException("Error in IO file, line " + lines);
            }
        }

        return clientList;
    }
    
    public List<Coupon> loadCoupons() throws IOException{

        List<String> lines = Files.readAllLines(LoadCSV.couponPath);
        ArrayList<Coupon> couponList = new ArrayList<Coupon>();

        for(String line : lines){
            String[] couponString = line.split(", ");
            switch(couponString[0]){
                case "Dollar":
                try{
                    couponList.add(new DollarCoupon(couponString[1],Double.parseDouble(couponString[2])));
                }
                catch(IllegalArgumentException e){
                    throw new IOException("Error in IO file, line " + lines);
                }
                    break;
                case "Percentage":
                try{
                    couponList.add(new PercentageCoupon(couponString[1], Double.parseDouble(couponString[2])));
                }
                catch(IllegalArgumentException e){
                    throw new IOException("Error in IO file, line " + lines);
                }
                    break;
                default:
                    throw new IOException("Error in IO file, line " + couponString);
            }
        }
        
        return couponList;
    }
    
}
