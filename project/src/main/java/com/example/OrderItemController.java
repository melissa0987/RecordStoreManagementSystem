package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.example.back.RecordStore;
import com.example.back.Cart;
import com.example.back.Client;
import com.example.back.Coupon;
import com.example.back.OrderItem;
import com.example.back.Record;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class OrderItemController {
    
    private String titleToFilter;
    private int priceToFilter;
    private RecordStore recordStore;

    public OrderItemController(String title, int price, RecordStore recordStore){
        this.titleToFilter = title;
        this.priceToFilter = price;
        this.recordStore = recordStore;

    }

    //window pops up with sorted product list
    public Cart  sort(RecordStore prod, Client client){
        Cart cart = new Cart(prod);
        List<OrderItem> shoppingCart = new ArrayList<OrderItem>();

        Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Shop");

       
        Text sText = new Text("Sort: ");

        Button random = new Button("Random");
        random.setMaxWidth(Double.MAX_VALUE);
        random.setOnAction(e->{
            
            order(prod, client);
            window.close();
        });

        //view the cart
        Button viewCart = new Button("View Cart");
        cart.setCart(shoppingCart);
        viewCart.setMaxWidth(Double.MAX_VALUE);
            viewCart.setOnAction(e->{
                displayCart(cart);
            });
        //cancels the cart
        Button cancelShop = new Button("Cancel Shop");
        cancelShop.setMaxWidth(Double.MAX_VALUE);
        cancelShop.setOnAction(e->{
            window.close();
        });

        //button pay 
        Button pay = new Button("Pay");
        pay.setMaxWidth(Double.MAX_VALUE);


        //sort th product list
            HBox ho = new HBox();
            ho.getChildren().addAll(viewCart);
			HBox hbo = new HBox();
			hbo.getChildren().addAll(sText, random);
			hbo.setAlignment(Pos.TOP_RIGHT);

			VBox vh = new VBox();
			vh.getChildren().addAll(ho, hbo);

            Button addSort1 = new Button("add to cart");
            Button addSort2 = new Button("add to cart");
            Button addSort3 = new Button("add to cart");

            Text t1 = new Text(prod.get(0) + " ");
            Text t2 = new Text(prod.get(1) + " ");
            Text t3 = new Text(prod.get(2) + " ");

            HBox h1 = new HBox();
            HBox h2 = new HBox();
            HBox h3 = new HBox();
            addSort1.setMaxWidth(Double.MAX_VALUE);
            addSort1.setOnAction( e->{
                shoppingCart.add( new OrderItem( prod.get(0), 1));
            });
            addSort2.setMaxWidth(Double.MAX_VALUE);
            addSort2.setOnAction( e->{
                shoppingCart.add( new OrderItem( prod.get(1), 1));
            });
            addSort3.setMaxWidth(Double.MAX_VALUE);
            addSort3.setOnAction( e->{
                shoppingCart.add( new OrderItem( prod.get(2), 1));
            });

            h1.getChildren().addAll(t1, addSort1);
            h2.getChildren().addAll(t2, addSort2);
            h3.getChildren().addAll(t3, addSort3);
            
            HBox payCancel = new HBox();
            payCancel.setAlignment(Pos.CENTER);
            payCancel.getChildren().addAll(cancelShop, pay);


            vh.getChildren().addAll(h1, h2, h3, payCancel);
            vh.setAlignment(Pos.CENTER);

            cart.setCart(shoppingCart);
            client.setCart(cart);
            //pay button is cliecked
            pay.setOnAction(ev ->{
                try {
                    payCart(client);
                } catch (IOException e1) {
                }
            });
			Scene sce = new Scene(vh, 500, 700);
			window.setScene(sce);
            window.showAndWait();

            return cart;
    }

    //order cart
    public Cart order(RecordStore products, Client client){
        Cart cart = new Cart(products);
        List<OrderItem> shoppingCart = new ArrayList<OrderItem>();

        Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Shop");

        Text sText = new Text("Sort: ");
		Button sort = new Button(" Price: Lowest to Highest");
		sort.setMaxWidth(Double.MAX_VALUE);
		//sorts the product list by price
		sort.setOnAction( e -> {
			// //sort th product list
			List<Record> records = products.sortByPrice();
			RecordStore prod = new RecordStore(records);
            
            sort(prod, client);
            window.close();
		});

        Button viewCart = new Button("View Cart");
        viewCart.setMaxWidth(Double.MAX_VALUE);
        //sets cart 
        cart.setCart(shoppingCart);

            //views the cart 
            viewCart.setOnAction(e->{
                displayCart(cart);
            });
        
        //cancels shopping and closes the window
        Button cancelShop = new Button("Cancel Shop");
        cancelShop.setMaxWidth(Double.MAX_VALUE);
        cancelShop.setOnAction(e->{
            window.close();
        });
        Button pay = new Button("Pay");
        pay.setMaxWidth(Double.MAX_VALUE);


        //sort th product list
            HBox ho = new HBox();
            ho.getChildren().addAll(viewCart);
			
			HBox hbo = new HBox();
			hbo.getChildren().addAll(sText, sort);
			hbo.setAlignment(Pos.TOP_RIGHT);

			VBox vh = new VBox();
			vh.getChildren().addAll(ho, hbo);

            /*Button addSort1 = new Button("add to cart");
            Button addSort2 = new Button("add to cart");
            Button addSort3 = new Button("add to cart");

            Text t1 = new Text(products.get(0) + " ");
            Text t2 = new Text(products.get(1) + " ");
            Text t3 = new Text(products.get(2) + " ");

            HBox h1 = new HBox();
            HBox h2 = new HBox();
            HBox h3 = new HBox();

            //button events 
            addSort1.setMaxWidth(Double.MAX_VALUE);
            addSort1.setOnAction( e->{
                shoppingCart.add( new OrderItem( products.get(0), 1));
            });
            addSort2.setMaxWidth(Double.MAX_VALUE);
            addSort2.setOnAction( e->{
                shoppingCart.add( new OrderItem( products.get(1), 1));
            });
            addSort3.setMaxWidth(Double.MAX_VALUE);
            addSort3.setOnAction( e->{
                shoppingCart.add( new OrderItem( products.get(2), 1));
            });
            

            h1.getChildren().addAll(t1, addSort1);
            h2.getChildren().addAll(t2, addSort2);
            h3.getChildren().addAll(t3, addSort3);

            HBox payCancel = new HBox();
            payCancel.setAlignment(Pos.CENTER);
            payCancel.getChildren().addAll(cancelShop, pay);


            vh.getChildren().addAll(h1, h2, h3, payCancel);*/
            for(int i = 0; i < this.recordStore.filteredSize(); i++){

                Button buttonToAdd = new Button("add to cart");
                Text textToAdd = new Text(this.recordStore.getFiltered(i) + " ");
                HBox hboxToAdd = new HBox();

                //getting around effectively final lol
                int pos = i;

                buttonToAdd.setOnAction( e ->{
                shoppingCart.add( new OrderItem( this.recordStore.getFiltered(pos), 1));
                });
                hboxToAdd.getChildren().addAll(buttonToAdd,textToAdd);
                vh.getChildren().add(hboxToAdd);
            }
            vh.getChildren().add(cancelShop);




            vh.setAlignment(Pos.CENTER);
        
        cart.setCart(shoppingCart);
        client.setCart(cart);
            //pay button is cliecked
            pay.setOnAction(ev ->{
                try {
                    payCart(client);
                } catch (IOException e1) {
                }
            });
		Scene sce = new Scene(vh, 500, 700);
		window.setScene(sce);
        window.showAndWait();
        return cart;

    }

    //diaplays the cart 
    public void displayCart(Cart cart){
        Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("View Cart");

        ListView<Cart> list = new ListView<Cart>();
		ObservableList<Cart> items = FXCollections.observableArrayList(cart);
		list.setItems(items);
		list.setCellFactory(ComboBoxListCell.forListView(cart)); //prints the cart info

        Button exit = new Button("Exit");
		exit.setMaxWidth(Double.MAX_VALUE);
            exit.setOnAction( event ->{
                window.close();
            });

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(0, 20, 10, 20)); 	//vbox styling
		vbox.getChildren().addAll(list, exit);
        Scene scene = new Scene(vbox, 250, 300);
		window.setScene(scene);
        window.showAndWait();
    }



    //pay Cart
    public void payCart(Client client) throws IOException{
        Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Pay Cart");

        Button cancel = new Button("Cancel payment");
        Cart cart = client.getCart();
        
        ListView<Cart> list = new ListView<Cart>();
		ObservableList<Cart> items = FXCollections.observableArrayList(cart);
		list.setItems(items);
		list.setCellFactory(ComboBoxListCell.forListView(cart)); //prints the cart info

        Text itemNo = new Text("Items: " + cart.size());
        Text total = new Text("Total: " + client.getCartTotal());
        Text gainedPoints = new Text("Earned points : " + cart.earnedPointsFromProducts());
        


        Label couponText = new Label();
        Button applyCoupon = new Button("Apply coupon");
        applyCoupon.setOnAction(e->{

            String a = applyCoupon(client);
            try {
                Coupon c = lookForCoupon(a, client);
                couponText.setText(c + "");
            } catch (IOException e1) {
            }
            window.close();

            //System.out.println(a + " " + couponText.getText() + "" + code.getText());
            
        });

       
        VBox vbox = new VBox();
        vbox.getChildren().addAll(cancel, list, itemNo, total,gainedPoints, applyCoupon);
        Scene scene = new Scene(vbox, 500, 700);
        window.setScene(scene);
        window.showAndWait();

    }

    //looks for the coupon
    public Coupon lookForCoupon(String code, Client client) throws IOException{
        for(int i=0; i<client.getCoupons().size(); i++){
            if (code.equals(client.getCoupons().get(i).getCouponCode())){
                return client.getCoupons().get(i);
            }
        }
        return null;
    }

    //method to apply the coupon
    public String applyCoupon(Client client){
        Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Select coupon");

        String c = "";
        Label code = new Label(); 
            Button cp1 = new Button("use coupon");
            Button cp2 = new Button("use coupon");
            Button cp3 = new Button("use coupon");

            Text t1 = new Text();
            Text t2 = new Text();
            Text t3 = new Text();
            try{
                t1.setText(client.getCoupons().get(0) + " ");
                t2.setText(client.getCoupons().get(1) + " ");
                t3.setText(client.getCoupons().get(2) + " ");
            }catch (IOException e1) {}

            HBox h1 = new HBox();
            HBox h2 = new HBox();
            HBox h3 = new HBox();
            
            h1.getChildren().addAll(t1, cp1);
            h2.getChildren().addAll(t2, cp2);
            h3.getChildren().addAll(t3, cp3);

            cp1.setOnAction(ev->{
                //Stage window1 = new Stage();
                Button cancel = new Button("Cancel payment");
                cancel.setOnAction(eve ->{
                    window.close();
                }); 
                Cart cart = client.getCart();

                ListView<Cart> list = new ListView<Cart>();
                ObservableList<Cart> items = FXCollections.observableArrayList(cart);
                list.setItems(items);
                list.setCellFactory(ComboBoxListCell.forListView(cart)); //prints the cart info
                List<Coupon> cList = new ArrayList<Coupon>();
                try {
                    cList.add( client.getCoupons().get(0));
                } catch (IOException e) {}

                Text itemNo = new Text("Items: " + cart.size());
                Text total = new Text("Total: " + client.getCartTotal());
                Text gainedPoints = new Text("Earned points : " + cart.earnedPointsFromProducts());
                Text couponCode = new Text("Coupon code : " + cList.get(0).getCouponCode());
                Text discout  = new Text("Coupon discount : " + cList.get(0).discountValue());
                Text getTotalAfterDiscount = new Text("Total after discount: " + client.getTotalAfterDiscount(0));
                Text calculateNewPoints = new Text("Gained total points: " + client.calculateNewSetPoints());
                Button confirm = new Button("Confirm purchase");
                confirm.setOnAction(eve ->{
                    client.setPoints(client.calculateNewSetPoints());

                    ListView<Cart> cc = new ListView<Cart>();
                    ObservableList<Cart> h = FXCollections.observableArrayList(client.getCart());
                    cc.setItems(h);
                    list.setCellFactory(ComboBoxListCell.forListView(client.getCart())); //
                    Button exit = new Button("Exit");
                    exit.setMaxWidth(Double.MAX_VALUE);
                        exit.setOnAction( event ->{
                            window.close();
                        
				    });

                VBox vbox = new VBox();
                vbox.setPadding(new Insets(0, 20, 10, 20)); 	//vbox styling
                vbox.getChildren().addAll(list, exit);
                Scene scene = new Scene(vbox, 500, 700);
                window.setScene(scene);
                    
                });


                    
                VBox vbox = new VBox();
                vbox.getChildren().addAll(cancel, list, itemNo, total,gainedPoints, couponCode, discout, getTotalAfterDiscount, calculateNewPoints, confirm);
                Scene scene = new Scene(vbox, 500, 700);
                window.setScene(scene);

            });

            cp2.setOnAction(ev->{
                 //Stage window1 = new Stage();
                 Button cancel = new Button("Cancel payment");
                 cancel.setOnAction(eve ->{
                     window.close();
                 }); 
                 Cart cart = client.getCart();
 
                 ListView<Cart> list = new ListView<Cart>();
                 ObservableList<Cart> items = FXCollections.observableArrayList(cart);
                 list.setItems(items);
                 list.setCellFactory(ComboBoxListCell.forListView(cart)); //prints the cart info
                 List<Coupon> cList = new ArrayList<Coupon>();
                 try {
                     cList.add( client.getCoupons().get(1));
                 } catch (IOException e) {}
 
                 Text itemNo = new Text("Items: " + cart.size());
                 Text total = new Text("Total: " + client.getCartTotal());
                 Text gainedPoints = new Text("Earned points : " + cart.earnedPointsFromProducts());
                 Text couponCode = new Text("Coupon code : " + cList.get(0).getCouponCode());
                 Text discout  = new Text("Coupon discount : " + cList.get(0).discountValue());
                 Text getTotalAfterDiscount = new Text("Total after discount: " + client.getTotalAfterDiscount(1));
                 Text calculateNewPoints = new Text("Gained total points: " + client.calculateNewSetPoints());
                 Button confirm = new Button("Confirm purchase");
                 confirm.setOnAction(eve ->{
                     client.setPoints(client.calculateNewSetPoints());
 
                     ListView<Cart> cc = new ListView<Cart>();
                     ObservableList<Cart> h = FXCollections.observableArrayList(client.getCart());
                     cc.setItems(h);
                     list.setCellFactory(ComboBoxListCell.forListView(client.getCart())); //
                     Button exit = new Button("Exit");
                     exit.setMaxWidth(Double.MAX_VALUE);
                         exit.setOnAction( event ->{
                             window.close();
                         
                     });
 
                 VBox vbox = new VBox();
                 vbox.setPadding(new Insets(0, 20, 10, 20)); 	//vbox styling
                 vbox.getChildren().addAll(list, exit);
                 Scene scene = new Scene(vbox, 500, 700);
                 window.setScene(scene);
                     
                 });
 
 
                     
                 VBox vbox = new VBox();
                 vbox.getChildren().addAll(cancel, list, itemNo, total,gainedPoints, couponCode, discout, getTotalAfterDiscount, calculateNewPoints, confirm);
                 Scene scene = new Scene(vbox, 500, 700);
                 window.setScene(scene);
            });
            cp3.setOnAction(ev->{
                 //Stage window1 = new Stage();
                 Button cancel = new Button("Cancel payment");
                 cancel.setOnAction(eve ->{
                     window.close();
                 }); 
                 Cart cart = client.getCart();
 
                 ListView<Cart> list = new ListView<Cart>();
                 ObservableList<Cart> items = FXCollections.observableArrayList(cart);
                 list.setItems(items);
                 list.setCellFactory(ComboBoxListCell.forListView(cart)); //prints the cart info
                 List<Coupon> cList = new ArrayList<Coupon>();
                 try {
                     cList.add( client.getCoupons().get(0));
                 } catch (IOException e) {}
 
                 Text itemNo = new Text("Items: " + cart.size());
                 Text total = new Text("Total: " + client.getCartTotal());
                 Text gainedPoints = new Text("Earned points : " + cart.earnedPointsFromProducts());
                 Text couponCode = new Text("Coupon code : " + cList.get(0).getCouponCode());
                 Text discout  = new Text("Coupon discount : " + cList.get(0).discountValue());
                 Text getTotalAfterDiscount = new Text("Total after discount: " + client.getTotalAfterDiscount(2));
                 Text calculateNewPoints = new Text("Gained total points: " + client.calculateNewSetPoints());
                 Button confirm = new Button("Confirm purchase");
                 confirm.setOnAction(eve ->{
                     client.setPoints(client.calculateNewSetPoints());
 
                     ListView<Cart> cc = new ListView<Cart>();
                     ObservableList<Cart> h = FXCollections.observableArrayList(client.getCart());
                     cc.setItems(h);
                     list.setCellFactory(ComboBoxListCell.forListView(client.getCart())); //
                     Button exit = new Button("Exit");
                     exit.setMaxWidth(Double.MAX_VALUE);
                         exit.setOnAction( event ->{
                             window.close();
                         
                     });
 
                 VBox vbox = new VBox();
                 vbox.setPadding(new Insets(0, 20, 10, 20)); 	//vbox styling
                 vbox.getChildren().addAll(list, exit);
                 Scene scene = new Scene(vbox, 500, 700);
                 window.setScene(scene);
                     
                 });
 
 
                     
                 VBox vbox = new VBox();
                 vbox.getChildren().addAll(cancel, list, itemNo, total,gainedPoints, couponCode, discout, getTotalAfterDiscount, calculateNewPoints, confirm);
                 Scene scene = new Scene(vbox, 500, 700);
                 window.setScene(scene);
            });
     
        VBox vh = new VBox();
        vh.getChildren().addAll(h1, h2, h3);
        Scene sce = new Scene(vh, 500, 700);
        window.setScene(sce);
        window.showAndWait();
        c = code.getText() + "";

        return c;

        
    }
}
