//package com.example.FrontEnd;
package com.example;

import java.io.IOException;

import com.example.back.Client;
import com.example.back.ClientList;
import com.example.back.LoadCSV;

// import com.example.Client;
// import com.example.ClientList;
// import com.example.LoadCSV;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.paint.*;
import javafx.scene.text.Text;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.*;


public class RecordGUI extends Application { 

    private Stage currentStage;
    private ClientList clientList;
    public static void main(String[] args) {
        Application.launch(args);
    }   

    @Override
   public void start(Stage window) { 


        //sets the currentStage = to the window
        currentStage = window;

        //calls the createSignInScene to create singIn scene
        Scene signIn = createSignInScene();

        //set the starting scene as the signIn scene
        window.setTitle("Programming III - Project: Record Store"); 
        window.setScene(signIn); 
        window.show(); 

       }

          //this creates the signInScene that the program starts in, on succesful validtion, changes to the recordStore scene
          
          private Scene createSignInScene(){
            //container and layout
            Group root = new Group(); 

            //scene signIn -- Building the singInScene
            Scene signIn = new Scene(root, 800, 600); 
            signIn.setFill(Color.BEIGE);

            VBox vbox = new VBox();

            Text storeTitle = new Text("Welcome to our Record store!");
            storeTitle.setStyle("-fx-font: 24 arial");
            Label nameLabel = new Label("Enter your name");
            TextField nameField = new TextField("");
            Label emailLabel = new Label("Enter your email");
            TextField emailField = new TextField("");
            Button signInButton = new Button("Sign in");
            Text signInResponse = new Text("Sign In Status");

            vbox.getChildren().addAll(storeTitle,nameLabel,nameField,emailLabel,emailField,signInButton,signInResponse);
            vbox.setAlignment(Pos.CENTER);
            vbox.setMinWidth(300);
            root.getChildren().add(vbox);
            
            vbox.setLayoutX(250);
            vbox.setLayoutY(150);

            // when the signInButton is clicked, checks if name and email is in the client databse, and if succesful, changes scene to recordScene
            signInButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent event) {
                    LoadCSV csv = new LoadCSV();
                try{
                    ClientList clients = new ClientList(csv.loadClients());
                    
                    // loads clients, and checks if nameField and emailField match, if it does, sets the client as the currentClient in the clienList
                    if(clients.checkForClientInDatabase(nameField.getText(), emailField.getText())){
                        signInResponse.setText("Valid, signing you in...");
                        //sets the clientList, will be passed to the RecordStore scene so the client can be tracked there
                        clientList = clients;
                        //creates the recordStore scene with the clientList passed to it
                        Scene store = createRecordScene(clientList);
                        //calls method that changes the scene on the currentStage
                        switchToStore(store);
                    }
                    else{
                        signInResponse.setText("Sorry, user does not exist in our database");
                    }
                }
                catch(IOException e){
                    signInResponse.setText(e.getMessage());
                }
                catch(IllegalArgumentException e){
                    signInResponse.setText(e.getMessage());
                }

            }});

            return signIn;
          }

          // this method creates the recordStore scene 
          private Scene createRecordScene(ClientList clientList){

            //container and layout
            Group root = new Group(); 

            //scene signIn -- Building the recordScene
            Scene storeScene = new Scene(root, 800, 600); 
            storeScene.setFill(Color.BEIGE);

            StorePage storePage = new StorePage(clientList);
            root.getChildren().add(storePage);

            return storeScene;
          }

          //switches from signInScene to RecordStore scene

          public void switchToStore(Scene storeScene){
              currentStage.setScene(storeScene);
          }

} 


