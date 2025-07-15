package com.example.back;
import java.util.ArrayList;
import java.util.List;

public class App 
{

    public static void main(String[] args) {
        
        Client testClient = new Client("Jamie", "email", "561-123-9038", "Street", MembershipLevel.BRONZE, 35.00);
        List<Client> testList = new ArrayList<Client>();
        ClientList testClientList = new ClientList(testList);

        //check for right name and email, should return true

        if(testClientList.checkForClientInDatabase("Jamie", "email")){
        }
        else{
            System.out.println("here...");
        }

        //check for wrong name and email, should return false

        if(testClientList.checkForClientInDatabase("Oops", "email")){
            System.out.println("Should have returned false");
        }
        else{
        }

    }    

}
