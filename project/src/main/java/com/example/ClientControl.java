package com.example;



import com.example.back.Cart;
import com.example.back.Client;
import com.example.back.MembershipLevel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ClientControl{
	//displays the client's profile
	public Client profile(Client c){
		Client client = c;
	
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("View Profile");

		//viewing the profile
		Button displayProfile = new Button("View Profile");
		//when the button displayProfile is clicked it will open a new window
		displayProfile.setOnAction(e -> {
			ListView<Client> list = new ListView<Client>();
			ObservableList<Client> items = FXCollections.observableArrayList(client);
			list.setItems(items);
			list.setCellFactory(ComboBoxListCell.forListView(client)); //prints the client info

			//exit button for display
			Button exit = new Button("Exit");
			exit.setMaxWidth(Double.MAX_VALUE);
				exit.setOnAction( event ->{
					window.close();
					profile(client);
				});

			VBox vbox = new VBox();
			vbox.setPadding(new Insets(0, 20, 10, 20)); 	//vbox styling
			vbox.getChildren().addAll(list, exit);
			Scene scene = new Scene(vbox, 300, 163);
			window.setScene(scene);
		});

		//when user cancels profile view
		Button cancelView = new Button("Cancel");
		cancelView.setOnAction( e->{
			window.close();
		});

		VBox vbox = new VBox();
		//editing the buttons
		displayProfile.setMaxWidth(Double.MAX_VALUE);
		cancelView.setMaxWidth(Double.MAX_VALUE);
		vbox.setSpacing(10);
        vbox.setPadding(new Insets(0, 20, 10, 20)); 	//vbox styling
		vbox.getChildren().addAll(displayProfile, cancelView);
		vbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(vbox, 200, 250);
		window.setScene(scene);
		window.showAndWait();


		//return client
		return client;
	}

	//edit profile
	public Client editProfile(Client c ){
		
		Client client = c;

		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Edit Profile");


		//viewing the profile
		Button editProfile = new Button("Edit Profile");
		Button cancelEdit = new Button("Cancel");

		String name = client.getName();
		String phone = client.getPhone();
		String address = client.getAddress();
		String level = client.getLevel().toString();
		double points  = client.getPoints();

		//when user clicks on 
		editProfile.setOnAction(e ->{
			Text nLabel = new Text("Name: ");
			TextField nameT = new TextField(name);
			Text pLabel = new Text("Phone: ");
			TextField phoneT = new TextField(phone);
			Text ALabel = new Text("Address: ");
			TextField addressT = new TextField(address);
			Text pointLabel = new Text("Points: ");	
			Text pointsT = new Text(points + "");
			Text levelLabel = new Text("Memebership Level: ");
			Text levelT = new Text(level);
			Button yes = new Button("Upgrade Level for $5");
			Button saveEdit = new Button("Save Edit");
			Button exit = new Button("Cancel Edit");

			//when save button is clicked;
			saveEdit.setOnAction(ev ->{
				client.setName(nameT.getText());
				client.setPhone(phoneT.getText());
				client.setAddress(addressT.getText());
				window.close();
				profile(client);
			});

			//user decides to cancel edit
			exit.setOnAction(ev ->{
				window.close();
			});

			//when yes button is clicked, the membership level will change depending on the client's current level
			yes.setOnAction(ev ->{
				ListView<String> list = new ListView<String>();
				String msg = "";
				Button goBack = new Button();

				if(level.equals("Bronze")){
					client.setLevel(MembershipLevel.SILVER);
					msg = "Membership level is changed to Silver";
					goBack.setText(" Ok ");

				}else if(level.equals("Silver")){
					client.setLevel(MembershipLevel.GOLD);
					msg = "Membership level changed to Gold";
					goBack.setText(" Ok ");
				}else{
					msg = "Membership level is maxed!";
					goBack.setText(" Ok ");
				}

				//print the message
				ObservableList<String> items = FXCollections.observableArrayList(msg);
				list.setItems(items);
				list.setCellFactory(ComboBoxListCell.forListView(msg));

				//if the goBack button is clicked, it will go back to editProfile window
				goBack.setMaxWidth(Double.MAX_VALUE);
				goBack.setOnAction(event ->{
					window.close();
					editProfile(client);
				});

				VBox vbox = new VBox();
				vbox.setAlignment(Pos.CENTER);
				vbox.getChildren().addAll(list , goBack);
				Scene scene = new Scene(vbox, 300, 250);
				window.setScene(scene);
			});

			VBox vbox = new VBox();
			vbox.setSpacing(10);
       		vbox.setPadding(new Insets(0, 20, 10, 20)); 	
			
			HBox hboxN = new HBox();
			HBox hboxPh = new HBox();
			HBox hboxA = new HBox();
			HBox hboxPo = new HBox();
			HBox hboxL = new HBox();
			HBox hbox1 = new HBox();
			HBox hbox2 = new HBox();
			hbox1.setSpacing(10);
			hbox2.setSpacing(10);
			hbox2.setAlignment(Pos.CENTER);
			hboxN.getChildren().addAll(nLabel, nameT);
			hboxPh.getChildren().addAll(pLabel, phoneT);
			hboxA.getChildren().addAll(ALabel, addressT);
			hboxPo.getChildren().addAll(pointLabel, pointsT);
			hboxL.getChildren().addAll(levelLabel, levelT);
			hbox1.getChildren().addAll(yes);
			hbox2.getChildren().addAll(saveEdit, exit);

			vbox.getChildren().addAll(hboxN, hboxPh, hboxA, hboxPo, hboxL, hbox1, hbox2);
			Scene scene = new Scene(vbox, 300, 250);
			window.setScene(scene);
		});

		//user cancels edit it will close the edi window
		cancelEdit.setOnAction( e->{
			window.close();
		});

		VBox vbox = new VBox();
		//editing the buttons
		editProfile.setMaxWidth(Double.MAX_VALUE);
		cancelEdit.setMaxWidth(Double.MAX_VALUE);
		vbox.setSpacing(10);
        vbox.setPadding(new Insets(0, 20, 10, 20)); 	
		vbox.getChildren().addAll(editProfile, cancelEdit);
		vbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(vbox, 200, 250);
		window.setScene(scene);
		window.showAndWait();

		return client;
	}

	

	public void useCoupon(Client c){

	}




 
}
