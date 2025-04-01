package com.burger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.burger.bun.BurgerBun;
import com.burger.cheese.BurgerCheese;
import com.burger.garnishes.BurgerGarnish;
import com.burger.patties.BurgerPatty;

public class Burger implements MenuItem {
    private BurgerBun bun;
    private BurgerCheese cheese;
    private ArrayList<BurgerCheese> cheeseList;
    private ArrayList<BurgerGarnish> garnishList;
    private ArrayList<BurgerPatty> pattyList;
    private ArrayList<MenuItem> selectionList;

    public Burger() {
        this.bun = null;
        this.cheeseList = new ArrayList<BurgerCheese>();
        this.garnishList = new ArrayList<BurgerGarnish>();
        this.pattyList = new ArrayList<BurgerPatty>();
        this.selectionList = new ArrayList<MenuItem>();
        this.cheese = null;
    }
    
    public BurgerBun getBun() {
        return this.bun;
    }

    public void setBun(BurgerBun bun) {
        this.bun = bun;
        this.selectionList.add(bun);
    }

    public ArrayList<BurgerCheese> getCheese() {
        return this.cheeseList;
    }

    public Double getCheesePrice() {
        if(!cheeseList.isEmpty()) {
            return cheeseList.get(cheeseList.size() - 1).getPrice();
        }
        return 0.0;
    }
    public void setCheese(ArrayList<BurgerCheese> cheese) {
        this.cheeseList = cheese;

    }
    

    public void addCheese(BurgerCheese cheese) {
        this.cheeseList.add(cheese);
        this.selectionList.add(cheese);
        this.cheese = cheese;
    }

    public ArrayList<BurgerGarnish> getGarnish() {
        return this.garnishList;
    }

    public void setGarnishes(ArrayList<BurgerGarnish> garnishes) {
        this.garnishList = garnishes;
    }

    public void addGarnishes(BurgerGarnish garnish) {
        this.garnishList.add(garnish);
        this.selectionList.add(garnish);
    }

    public Double getGarnishPrice() {
        if(!garnishList.isEmpty()) {
            return garnishList.get(garnishList.size() - 1).getPrice();
        }
        return 0.0;
    }

    public ArrayList<BurgerPatty> getPatty() {
        return this.pattyList;
    }

    public void setPatties(ArrayList<BurgerPatty> patties) {
        this.pattyList = patties;
    }

    public void addPatties(BurgerPatty patty) {
        this.pattyList.add(patty);
        this.selectionList.add(patty);
    }

    public Double getPattyPrice() {
        if(!pattyList.isEmpty()) {
            return pattyList.get(pattyList.size() - 1).getPrice();
        }
        return 0.0;
    }

	public void displayItems() {
		System.out.println("Burger: $" + this.getPrice());
		for (MenuItem m : this.selectionList) {
			System.out.println("    " + m.toNiceString());
		}
	}

    public List<MenuItem> getSelectionList() {
        return selectionList;
    }
    @Override
	public Double getPrice() {
		Double totalPrice = 0.0;
		for (MenuItem m : this.selectionList) {
			totalPrice += m.getPrice();
		}
		return totalPrice;
	}

	public void sortItems() {
		Collections.sort(this.selectionList);
	}
}