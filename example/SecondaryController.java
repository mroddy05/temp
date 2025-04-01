package com.example;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import com.pizza.Pizza;
import com.pizza.crust.ThickCrust;
import com.pizza.crust.ThinCrust;
import com.pizza.sauce.AlfredoSauce;
import com.pizza.sauce.TomatoSauce;
import com.pizza.topping.AsiagoTopping;
import com.pizza.topping.MozzarellaTopping;
import com.pizza.topping.MushroomTopping;
import com.pizza.topping.PepperTopping;
import com.pizza.topping.PepperoniTopping;
import com.pizza.topping.SausageTopping;

public class SecondaryController {

    @FXML
    private ComboBox<String> crustChoice;
    @FXML
    private ComboBox<String> sauceChoice;
    @FXML
    private ComboBox<String> toppingChoice;
    @FXML
    private ListView<String> selectedItems;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private Label chooseItemLabel;
    @FXML
    private Button sauceButton;
    @FXML
    private Button toppingButton;
    
    private Pizza pizza;
    private ObservableList<String> selectedIngredients;

    @FXML
    public void initialize() {
        pizza = new Pizza();
        selectedIngredients = FXCollections.observableArrayList();
        selectedItems.setItems(selectedIngredients);

        crustChoice.setItems(FXCollections.observableArrayList("Thick Crust", "Thin Crust"));
        sauceChoice.setItems(FXCollections.observableArrayList("Alfredo", "Tomato"));
        toppingChoice.setItems(FXCollections.observableArrayList("Asaigo", "Mozzarella", "Mushroom", 
                                                            "Pepperoni", "Pepper", "Sausage"));

        chooseItemLabel.setText("Choose Your Crust:");

        sauceButton.setDisable(true);
        toppingButton.setDisable(true);
    }

    @FXML
    private void addCrust() {
        sauceButton.setDisable(false);
        toppingButton.setDisable(false);
        
        String crustType = crustChoice.getValue();
        if (crustType != null) {
            switch (crustType) {
                case "Thick Crust": pizza.setCrust(new ThickCrust()); break;
                case "Thin Crust": pizza.setCrust(new ThinCrust()); break;
            }
            selectedIngredients.add("Crust: " + crustType + "  $ " + pizza.getCrust().getPrice());
            setPrice(pizza.getPrice());
            crustChoice.setDisable(true);
        }
    }

    @FXML
    private void addSauce() {
        sauceButton.setDisable(true);
        crustChoice.setVisible(false);
        sauceChoice.setVisible(true);
                                                            
        chooseItemLabel.setText("Choose Your Sauce: ");

        
        
        String sauceType = sauceChoice.getValue();
        if (sauceType != null) {
            switch (sauceType) {
                case "Alfredo": pizza.setSauce(new AlfredoSauce()); break;
                case "Tomato": pizza.setSauce(new TomatoSauce()); break;
            }
            selectedIngredients.add("Sauce: " + sauceType + "  $ " + pizza.getSauce().getPrice());
            setPrice(pizza.getPrice());
            sauceChoice.setDisable(true);
        }
    }

    @FXML
    private void addTopping() {
        toppingButton.setDisable(true);
        crustChoice.setVisible(false);
        sauceChoice.setVisible(false);
        toppingChoice.setVisible(true);
                                                            
        chooseItemLabel.setText("Choose Your Toppings: (as many as wanted on the pizza)");

        
        
        String toppingType = toppingChoice.getValue();
        if ((toppingType != null)) {
            switch (toppingType) {
                case "Asaigo": 
                    pizza.addTopping(new AsiagoTopping()); 
                    break;
                case "Mozzarella": 
                    pizza.addTopping(new MozzarellaTopping()); 
                    break;
                case "Mushroom": 
                    pizza.addTopping(new MushroomTopping()); 
                    break;
                case "Pepperoni": 
                    pizza.addTopping(new PepperoniTopping()); 
                    break;
                case "Pepper": 
                    pizza.addTopping(new PepperTopping()); 
                    break;
                case "Sausage": 
                    pizza.addTopping(new SausageTopping()); 
                    break;
            }
            
            selectedIngredients.add("Topping: " + toppingType + "  $ " + pizza.getToppingPrice());
            setPrice(pizza.getPrice());

            // toppingChoice.setValue(null);
    
        }
    }

    @FXML 
    private void setPrice(Double price) {
        Double totalPrice = pizza.getPrice();
        totalPriceLabel.setText("Total Price: "+ price);
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void switchToReceipt() throws IOException {
        AllData.setPizza(pizza);
        App.setRoot("receipt");
    }
}