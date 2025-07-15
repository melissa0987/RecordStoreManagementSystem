package com.example;

import java.io.IOException;


import com.example.back.LoadCSV;
import com.example.back.RecordStore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Shop {
    public void displayProducts() throws IOException{

        Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Shop");


        //display the products
        LoadCSV csv = new LoadCSV();
        RecordStore product = new RecordStore(csv.loadRecords());

        ListView<RecordStore> list = new ListView<RecordStore>();
        ObservableList<RecordStore> items = FXCollections.observableArrayList(product);
        list.setItems(items);
        list.setCellFactory(ComboBoxListCell.forListView(product));
        VBox vbox = new VBox();
        vbox.getChildren().addAll(list);
        Scene scene = new Scene(vbox, 200, 250);
        window.setScene(scene);

    }
}
