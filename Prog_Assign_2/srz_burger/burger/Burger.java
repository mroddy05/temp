package srz_burger.burger;
import java.util.ArrayList;
import java.util.Collections;

import srz_burger.burger.bun.BurgerBun;
import srz_burger.burger.cheese.BurgerCheese;
import srz_burger.burger.garnishes.BurgerGarnish;
import srz_burger.burger.patties.BurgerPatty;

public class Burger implements MenuItem {
    private BurgerBun bun;
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

    public void setCheese(ArrayList<BurgerCheese> cheese) {
        this.cheeseList = cheese;
    }

    public void addCheese(BurgerCheese cheese) {
        this.cheeseList.add(cheese);
        this.selectionList.add(cheese);
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

	public void displayItems() {
		System.out.println("Burger: $" + this.getPrice());
		for (MenuItem m : this.selectionList) {
			System.out.println("    " + m.toNiceString());
		}
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
