//package com.example.FrontEnd;
package com.example;

import java.io.IOException;

import com.example.back.ClientList;
import com.example.back.LoadCSV;

// import com.example.Client;
// import com.example.ClientList;
// import com.example.LoadCSV;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// DEPRECATED, CODE MOVED INTO THE RECORDGUI CLASS -- NO LONGER NEEDED

public class SignInAttempt implements EventHandler<ActionEvent> {

    private Text signInResult;
    private TextField name;
    private TextField email;
    private Scene storeScene;
    private Stage stage;

    public SignInAttempt(TextField name, TextField email, Text signInResult, Stage currentStage){
        this.name = name;
        this.email = email;
        this.signInResult = signInResult;
        this.stage = currentStage;
    }

    @Override
    public void handle(ActionEvent event) {

        LoadCSV csv = new LoadCSV();
        try{
            ClientList clients = new ClientList(csv.loadClients());
            System.out.println(this.name.getText());
            System.out.println(this.email.getText());
            if(clients.checkForClientInDatabase(name.getText(), email.getText())){
                this.signInResult.setText("Valid, signing you in...");
            }
            else{
                this.signInResult.setText("Sorry, user does not exist in our database");
            }
        }
        catch(IOException e){
            this.signInResult.setText(e.getMessage());
        }
        catch(IllegalArgumentException e){
            this.signInResult.setText(e.getMessage());
        }

    }
    
}
