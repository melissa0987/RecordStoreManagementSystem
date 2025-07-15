package com.example.back;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoadSQL implements LoadProducts {

    @Override
    public List<Record> loadRecords() throws IOException {
        return null;
    }

    @Override
    public List<Client> loadClients() throws IOException {
        return null;
    }

    @Override
    public List<Coupon> loadCoupons() throws IOException{
        List<Coupon>  c = new ArrayList<Coupon>();
        String sql = "SELECT * FROM coupons";
        PreparedStatement stmt = null;

        String user = System.console().readLine("Username: ");
        String password = new String(System.console().readPassword("Password: "));
        String url = "jdbc:oracle:thin:@198.168.52.211:1521/pdbora19c.dawsoncollege.qc.ca";
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            System.out.println("Connection is closed: " + conn.isClosed());
            
            stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                String type = result.getString(1);
                if ( type.equals("Dollar")){
                    Coupon dc= new DollarCoupon(result.getString(2), result.getDouble(3));
                    c.add(dc);
                }else{
                    c.add(new PercentageCoupon(result.getString(2), result.getDouble(3)));
                }

            }
        }catch(SQLException e){
            throw new IOException(e);
        } 
        
        /*finally{
            try{
                if(conn != null && !conn.isClosed()){
                    conn.close();    
                }
            }
            catch(SQLException e){
                throw new IOException(e);
            }
        }*/
        return c;

    }


    
}
