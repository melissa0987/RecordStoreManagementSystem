package com.example.back;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ClientListTest {
    //Constructor
    @Test
    public void testEqualsSameConstructor() throws IOException{
        LoadCSV csv = new LoadCSV();
        ClientList list = new ClientList(csv.loadClients());
        Client client1 = list.get(0);
        Client client2 = list.get(1);
        Client client3 = list.get(2);

        Client expected1 = new Client("Silly Steve", "yipee@gmail.com", "323-232-4344", "2485 John St", MembershipLevel.GOLD, 0.0);
        Client expected2 = new Client("James Biond", "je@gmail.com", "324-422-2222", "11000 Oliver Road", MembershipLevel.SILVER, 150.0);
        Client expected3 = new Client("James", "emailTest", "514-212-3492", "2333 Baker St", MembershipLevel.BRONZE, 30.0);

        assertEquals(expected1, client1);
        assertEquals(expected2, client2);
        assertEquals(expected3, client3);

        int c1 = list.size();
        int e1 = 3;

        assertEquals(e1, c1, 0.01);

       
    }
    @Test
    public void checkForClientInDatabaseTest(){

        // add a client to the clientList to be passed to the class
        Client testClient = new Client("Jamie", "email", "561-123-9038", "Street", MembershipLevel.BRONZE, 35.00);
        List<Client> testList = new ArrayList<Client>();
        testList.add(testClient);
        ClientList testClientList = new ClientList(testList);

        //check for right name and email, should return true

        if(testClientList.checkForClientInDatabase("Jamie", "email")){
        }
        else{
            fail("Should have returned true");
        }

        //check for wrong name and email, should return false

        if(testClientList.checkForClientInDatabase("Oops", "email")){
            fail("Should have returned false");
        }
        else{
        }

    }
    
    

    
}

