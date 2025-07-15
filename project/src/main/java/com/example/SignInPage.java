//package com.example.FrontEnd;
package com.example;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


// DEPRECATED, CODE MOVED INTO THE RECORDGUI CLASS -- NO LONGER NEEDED

public class SignInPage extends VBox{

    private Stage currentStage;

    public SignInPage(Scene scene, Stage currentStage){

        this.currentStage = currentStage;
        
        //building vBox components
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
        this.getChildren().add(vbox);

        //adding action event to sign in button

        // SignInAttempt newSign = new SignInAttempt(nameField, emailField, signInResponse, currentStage);
        signInButton.setOnAction(new EventHandler<ActionEvent>(){

           @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                
            }
            
        });

    }


}
