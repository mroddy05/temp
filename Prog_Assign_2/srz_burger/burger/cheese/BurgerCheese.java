package srz_burger.burger.cheese;

import srz_burger.burger.MenuItem;

public abstract class BurgerCheese implements MenuItem {
    public abstract String toString();

    public String toNiceString() {
        return "Cheese: " + this.toString() + " $" + this.getPrice();

    }

    @Override
    public Double getPrice() {
        return 0.50;
    }
    
}
