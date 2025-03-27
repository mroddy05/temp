package srz_burger.burger.patties;

import srz_burger.burger.MenuItem;

public abstract class BurgerPatty implements MenuItem {
    public abstract String toString();

    public String toNiceString() {
        return "Patty: " + this.toString() + " $" + this.getPrice();

    }

    @Override
    public Double getPrice() {
        return 1.50;
    }
    
}
