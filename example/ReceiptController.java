package com.example;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import com.burger.Burger;
import com.burger.bun.BriocheBun;
import com.burger.bun.PotatoBun;
import com.burger.bun.SesameBun;

import com.burger.cheese.AmericanCheese;
import com.burger.cheese.BurgerCheese;
import com.burger.cheese.CheddarCheese;
import com.burger.cheese.PepperjackCheese;
import com.burger.cheese.SwissCheese;

import com.burger.garnishes.BaconGarnish;
import com.burger.garnishes.FriedEggGarnish;
import com.burger.garnishes.GuacamoleGarnish;
import com.burger.garnishes.LettuceGarnish;
import com.burger.garnishes.OnionRingGarnish;
import com.burger.garnishes.PickleGarnish;
import com.burger.garnishes.TomatoGarnish;
import com.burger.patties.BeefPatty;
import com.burger.patties.ChickenPatty;
import com.burger.patties.ImpossiblePatty;
import com.burger.patties.VeggiePatty;
import com.pizza.Pizza;
public class ReceiptController {

    private Burger burger;
    private Pizza pizza;

    @FXML
    private ListView<String> selectedItems;
    @FXML
    private Label totalPriceLabel;
    
    @FXML
    private void initialize() {
        ObservableList<String> receiptItems = FXCollections.observableArrayList();
        
        burger = AllData.getBurger();
        pizza = AllData.getPizza();

        if (burger != null) {
            burger.sortItems();
            receiptItems.add("Burger: $" + burger.getPrice());
            for (com.burger.MenuItem m : burger.getSelectionList()) {
                receiptItems.add("    " + m.toNiceString());
            }
        }

        if (pizza != null) {
            pizza.sortItems();
            receiptItems.add("Pizza: $" + pizza.getPrice());
            for (com.pizza.MenuItem m : pizza.getSelectionList()) {
                receiptItems.add("    " + m.toNiceString());
            }
        }

        selectedItems.setItems(receiptItems);

        setPrice();
    }

    private Double getTotalPrice() {
        Double total = 0.0;
        total += burger.getPrice();
        total += pizza.getPrice();
        return total;
    }

    @FXML 
    private void setPrice() {
        Double totalPrice = getTotalPrice();
        totalPriceLabel.setText("Total Price: "+ totalPrice);
    }
}
