//package com.example.FrontEnd;
package com.example;

import java.io.IOException;

import com.example.back.Client;
import com.example.back.ClientList;
import com.example.back.CouponList;
import com.example.back.LoadCSV;
import com.example.back.RecordStore;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

//TODO: Pretty much all store functionality in here lol

public class StorePage extends VBox {

    private ClientList clientList;
    private Client currentClient;
    private RecordStore recordStore;
    private CouponList coupons;
     
    public StorePage(ClientList clientList){

        //sets the clienlist as the passed list, and the current client as the client stored inside on succesful sign in
        this.clientList = clientList;
        this.currentClient = this.clientList.getCurrentClient();

        //loads the recordStore and couponList into the object

        LoadCSV csv = new LoadCSV();
        try{
            this.recordStore =  new RecordStore(csv.loadRecords());
            this.coupons = new CouponList(csv.loadCoupons());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        //creates the scene objects to be appended to the scene

        VBox main = new VBox();

        //Text Field welcomes specific client to storePage, adds it to main

        Text header = new Text("Welcome to Cool Records, " + this.currentClient.getName());
        header.setStyle("-fx-font: 24 arial");
        main.getChildren().add(header);

        //creates a new Hbox and adds the two profile buttons, then adds them to main

        HBox profileButtons = new HBox();

        ClientControl clientControl = new ClientControl(); //where client's behaviour is
        Button viewProfileButton = new Button("View Profile");
        viewProfileButton.setOnAction(e -> {
                    clientControl.profile(this.currentClient);
                }
            );

        //edits profile
        Button editProfileButton = new Button("Edit Profile");
        editProfileButton.setOnAction( e ->{
                clientControl.editProfile(this.currentClient);
            });

        profileButtons.getChildren().addAll(viewProfileButton,editProfileButton);
        profileButtons.setAlignment(Pos.CENTER);

        main.getChildren().add(profileButtons);

        Text sortingText = new Text("Leave title blank to sort by price, fill to sort by title");
        main.getChildren().add(sortingText);

        //creates new Hbox and adds the sorting/filtering textfields to it

        HBox sorting = new HBox();

        Label titleLabel = new Label("Filter By Record Title");
        TextField titleSort = new TextField();

        Label priceLabel = new Label("Filter By Max Price");
        TextField priceSort = new TextField();

        //TODO edit
        Button sortButton = new Button("Show sorted/filtered list");

        sorting.getChildren().addAll(titleLabel,titleSort,priceLabel,priceSort,sortButton);
        main.getChildren().add(sorting);
        main.setAlignment(Pos.CENTER);

        sortButton.setOnAction( e ->{
            // if input is not a number, returns and tells user to input number
            try{
            Integer.valueOf(priceSort.getText());
            }
            catch(NumberFormatException nfe){
                priceSort.setText("Please put in a number");
                return;
            }
                OrderItemController order = new OrderItemController(titleSort.getText(),Integer.valueOf(priceSort.getText()),this.recordStore);
                order.order(recordStore, this.currentClient);
            });
    
        //adds main to the object, this gets appened to the scene in the RecordGUI application class
        this.getChildren().add(main);
        this.setMaxWidth(700);
        this.setLayoutX(50);
        
    }

}

