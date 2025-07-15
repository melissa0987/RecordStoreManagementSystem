package com.example.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClientList {
    
    private List<Client> clientDatabase;
    private Client currentClient;
    private int clientPosition;
    private static final Path clientPath = Paths.get("clientlist.txt");

    public ClientList(List<Client> clientList){
        this.clientDatabase = clientList;
        this.clientPosition = -1;
    }

    // temporary, just to check

    public void displayClients(){
        for(int i = 0; i < this.clientDatabase.size(); i++){
            System.out.println(this.clientDatabase.get(i));
        }
    }

    // this method returns record at position x
    public Client get(int x){
        return this.clientDatabase.get(x);
    }

    public int size(){
        return this.clientDatabase.size();
    }

    // this method takes a user inputed name and email, and loops through the database to see if the user exists in the clientDatabase
    // if they do, return the client

    //might want to add selectedClient variable to the class to store it in, so this can return a boolean and on succes, store the client to be modified later

    public Boolean checkForClientInDatabase(String name, String email){

        for(int i = 0; i < this.clientDatabase.size(); i++){
            if(this.clientDatabase.get(i).clientExists(name, email)){
                this.currentClient = this.clientDatabase.get(i);
                this.clientPosition = i;
                return true;
            }
        }
        return false;
    }

    //When a client adds points to their account through purchases, the new point
    // total is written to the csv file

    public void writeToClientListCSV(Client client) throws IOException{

       //remove old client from clientList
       this.clientDatabase.remove(this.clientPosition);

       //adds updated client to database
       this.clientDatabase.add(client);

       //turns the clientList into a list of strings and adds them to the 

        List<String> csvList = new ArrayList<String>();

       for(int i = 0; i < this.clientDatabase.size();i++){
            Client clientToAdd = this.clientDatabase.get(i);
            String stringBuilder = clientToAdd.getName() + "," + clientToAdd.getEmail() + "," + clientToAdd.getPhone() + "," + clientToAdd.getAddress() + "," + clientToAdd.getLevel() + clientToAdd.getPoints();
            csvList.add(stringBuilder);
       }
       Files.write(ClientList.clientPath,csvList);

    }


    //temp stuff maybe, for testing

    public List<Client> getClientDatabase() {
        return clientDatabase;
    }

    public Client getCurrentClient() {
        return currentClient;
    }

    public int getClientPosition() {
        return clientPosition;
    }

    public static Path getClientPath() {
        return clientPath;
    }



}
