package com.example;





import java.io.IOException;

import com.example.back.Cart;
import com.example.back.Client;
import com.example.back.ClientList;
import com.example.back.LoadCSV;
import com.example.back.MembershipLevel;
import com.example.back.RecordStore;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.*;
import javafx.scene.text.Text;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.*;


public class App extends Application
{

    // private Stage currentStage;
    // private Client currentClient;
    // public static void main(String[] args) {
    //     Application.launch(args);
    // }    


    /*@Override
   public void start(Stage window) { 

        //sets the currentStage = to the window
        currentStage = window;

        //creates the recordStore scene
        Scene store = createRecordScene();
        //calls the createSignInScene to create singIn scene
        Scene signIn = createSignInScene(store);

        //set the starting scene as the signIn scene
        window.setTitle("Programming III - Project: Record Store"); 
        window.setScene(signIn); 
        window.show(); 

        //When client signs in, the method where client sign in should return Client object
        //sample for now


    } 

     //this creates the signInScene that the program starts in, on succesful validtion, changes to the recordStore scene
          
    private Scene createSignInScene(Scene storeScene){
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
                
                // loads clients, and checks if nameField and emailField match
                if(clients.checkForClientInDatabase(nameField.getText(), emailField.getText())){
                    signInResponse.setText("Valid, signing you in...");
                    //sets the currentClient to the client that he found
                    currentClient = clients.getCurrentClient();
                    //calls method that changes the scene on the currentStage
                    switchToStore(storeScene);
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
    private Scene createRecordScene(){

        //container and layout
        Group root = new Group(); 

        //scene signIn -- Building the recordScene
        Scene storeScene = new Scene(root, 800, 600); 
        storeScene.setFill(Color.BEIGE);

        StorePage storePage = new StorePage();
        root.getChildren().add(storePage);

        return storeScene;
    }

     //switches from signInScene to RecordStore scene

    public void switchToStore(Scene storeScene){
        currentStage.setScene(storeScene);
    }
    
    
    */
    
    
    
    
    
    
    
    
    
    
    
    /*@Override
    public void start(Stage primaryStage) throws IOException { 
            //container and layout
            Group root = new Group(); 
 
            // //scene is associated with container, dimensionsVBox 
            
            Scene scene = new Scene(root, 400, 300); 
            
            scene.setFill(Color.WHITESMOKE);
 
            // //associate scene to stage and show
            primaryStage.setTitle("Welcome to our Record Store"); 
            primaryStage.setScene(scene); 
            primaryStage.show(); 
            VBox vbox = new VBox();

            //sample
            Client client = new Client("Melissa", "email", "phone", "address", MembershipLevel.BRONZE, 120);
            LoadCSV csv = new LoadCSV();
            RecordStore recordStore = new RecordStore(csv.loadRecords());
            
            ClientControl clientControl = new ClientControl(); //where client's behaviour is
            //view profile
            Button viewProfile = new Button("View Profile");
            viewProfile.setOnAction(e -> {
                    clientControl.profile(client);
                }
            );
            //edit profile
            Button editProfile = new Button("Edit Profile");
            editProfile.setOnAction( e ->{
                clientControl.editProfile(client);
            });


            //this button allows client to shop
            Button shop = new Button("Shop");
            OrderItemController order = new OrderItemController();
            shop.setOnAction( e ->{
                client.setCart( order.order(recordStore, client) );
            });

            //editing button width
            viewProfile.setMaxWidth(Double.MAX_VALUE);
            editProfile.setMaxWidth(Double.MAX_VALUE);
            shop.setMaxWidth(Double.MAX_VALUE);


            vbox.setSpacing(10);
            vbox.setPadding(new Insets(0, 20, 10, 20)); 
            vbox.getChildren().addAll(viewProfile, editProfile, shop);
            root.getChildren().addAll(vbox);
            

    }*/
    private Stage currentStage;
    private ClientList clientList;

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

          public static void main(String[] args) {
                   Application.launch(args);
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
