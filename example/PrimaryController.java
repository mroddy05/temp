package com.example;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
import com.example.ReceiptController;

public class PrimaryController {

    @FXML
    private ComboBox<String> bunChoice;
    @FXML
    private ComboBox<String> cheeseChoice;
    @FXML
    private ComboBox<String> garnishChoice;
    @FXML
    private ComboBox<String> pattyChoice;
    @FXML
    private ListView<String> selectedItems;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private Label chooseItemLabel;
    @FXML
    private Button cheeseButton;
    @FXML
    private Button garnishButton;
    @FXML
    private Button pattyButton;
    
    private Burger burger;
    private ObservableList<String> selectedIngredients;
    private ReceiptController receipt;

    @FXML
    public void initialize() {
        burger = new Burger();
        selectedIngredients = FXCollections.observableArrayList();
        selectedItems.setItems(selectedIngredients);

        bunChoice.setItems(FXCollections.observableArrayList("Brioche Bun", "Potato Bun", "Sesame Bun"));
        cheeseChoice.setItems(FXCollections.observableArrayList("American Cheese", "Cheddar Cheese", 
                                                                "Pepperjack Cheese", "Swiss Cheese"));
        garnishChoice.setItems(FXCollections.observableArrayList("Bacon", "Fried Egg", "Guacamole", 
                                                            "Lettuce", "Onion Ring", "Pickle", "Tomato"));
        pattyChoice.setItems(FXCollections.observableArrayList("Beef", "Chicken", "Impossible", 
                                                            "Veggie"));

        chooseItemLabel.setText("Choose Your Bun:");

        cheeseButton.setDisable(true);
        garnishButton.setDisable(true);
        pattyButton.setDisable(true);


        ReceiptController receiptController = new ReceiptController();
        setReceiptController(receiptController);
    }

    public void setReceiptController(ReceiptController receiptController) {
        this.receipt = receiptController;
    }

    @FXML
    private void handleBunSelection() {
        cheeseButton.setDisable(false);
        garnishButton.setDisable(false);
        pattyButton.setDisable(false);
        
        String bunType = bunChoice.getValue();
        if (bunType != null) {
            switch (bunType) {
                case "Brioche Bun": burger.setBun(new BriocheBun()); break;
                case "Potato Bun": burger.setBun(new PotatoBun()); break;
                case "Sesame Bun": burger.setBun(new SesameBun()); break;
            }
            selectedIngredients.add("Bun: " + bunType + "  $ " + burger.getBun().getPrice());
            setPrice(burger.getPrice());
            bunChoice.setDisable(true);
        }
    }

    @FXML
    private void addCheese() {
        Integer numCheese = 0;
        cheeseButton.setDisable(true);
        bunChoice.setVisible(false);
        cheeseChoice.setVisible(true);
                                                            
        chooseItemLabel.setText("Choose Your Cheese: (up to 4)");

        
        
        String cheeseType = cheeseChoice.getValue();
        if ((cheeseType != null) && (burger.getCheese().size() < 4)) {
            switch (cheeseType) {
                case "American Cheese": 
                    burger.addCheese(new AmericanCheese()); 
                    break;
                case "Cheddar Cheese": 
                    burger.addCheese(new CheddarCheese()); 
                    break;
                case "Pepperjack Cheese": 
                    burger.addCheese(new PepperjackCheese()); 
                    break;
                case "Swiss Cheese": 
                    burger.addCheese(new SwissCheese()); 
                    break;
            }
            
            selectedIngredients.add("Cheese: " + cheeseType + "  $ " + burger.getCheesePrice());
            setPrice(burger.getPrice());

            // cheeseChoice.setValue(null);

            if (burger.getCheese().size() >= 4) {
                cheeseChoice.setDisable(true);
            }        
        }
    }

    @FXML
    private void addGarnish() {
        Integer numGarnish = 0;
        garnishButton.setDisable(true);
        bunChoice.setVisible(false);
        cheeseChoice.setVisible(false);
        garnishChoice.setVisible(true);
                                                            
        chooseItemLabel.setText("Choose Your Garnishes: (up to 4)");

        
        
        String garnishType = garnishChoice.getValue();
        if ((garnishType != null) && (burger.getGarnish().size() < 4)) {
            switch (garnishType) {
                case "Bacon": 
                    burger.addGarnishes(new BaconGarnish()); 
                    break;
                case "Fried Egg": 
                    burger.addGarnishes(new FriedEggGarnish()); 
                    break;
                case "Guacamole": 
                    burger.addGarnishes(new GuacamoleGarnish()); 
                    break;
                case "Lettuce": 
                    burger.addGarnishes(new LettuceGarnish()); 
                    break;
                case "Onion Ring": 
                    burger.addGarnishes(new OnionRingGarnish()); 
                    break;
                case "Pickle": 
                    burger.addGarnishes(new PickleGarnish()); 
                    break;
                case "Tomato": 
                    burger.addGarnishes(new TomatoGarnish()); 
                    break;
            }
            
            selectedIngredients.add("Garnish: " + garnishType + "  $ " + burger.getGarnishPrice());
            setPrice(burger.getPrice());

            // garnishChoice.setValue(null);

            if (burger.getGarnish().size() >= 4) {
                garnishChoice.setDisable(true);
            }        
        }
    }

    @FXML
    private void addPatty() {
        Integer numPatty = 0;
        pattyButton.setDisable(true);
        bunChoice.setVisible(false);
        cheeseChoice.setVisible(false);
        garnishChoice.setVisible(false);
        pattyChoice.setVisible(true);
                                                            
        chooseItemLabel.setText("Choose Your Patties: (up to 4)");

        
        
        String pattyType = pattyChoice.getValue();
        if ((pattyType != null) && (burger.getPatty().size() < 4)) {
            switch (pattyType) {
                case "Beef": 
                    burger.addPatties(new BeefPatty()); 
                    break;
                case "Chicken": 
                    burger.addPatties(new ChickenPatty()); 
                    break;
                case "Impossible": 
                    burger.addPatties(new ImpossiblePatty()); 
                    break;
                case "Veggie": 
                    burger.addPatties(new VeggiePatty()); 
                    break;
            }
            
            selectedIngredients.add("Patty: " + pattyType + "  $ " + burger.getPattyPrice());
            setPrice(burger.getPrice());

            // pattyChoice.setValue(null);

            if (burger.getPatty().size() >= 4) {
                pattyChoice.setDisable(true);
            }        
        }
    }

    @FXML 
    private void setPrice(Double price) {
        Double totalPrice = burger.getPrice();
        totalPriceLabel.setText("Total Price: "+ price);
    }

    @FXML
    private void switchToSecondary() throws IOException {
        AllData.setBurger(burger);
        App.setRoot("secondary");
    }
}