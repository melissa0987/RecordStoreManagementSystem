package com.example.back;

import java.io.IOException;
import java.util.List;

public interface LoadProducts {
    
    public List<Record> loadRecords() throws IOException;
    public List<Client> loadClients() throws IOException;
    public List<Coupon> loadCoupons() throws IOException;

}
