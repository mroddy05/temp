package srz_burger.burger.garnishes;

import srz_burger.burger.MenuItem;

public abstract class BurgerGarnish implements MenuItem {
    public abstract String toString();

    public String toNiceString() {
        return "Garnish: " + this.toString() + " $" + this.getPrice();

    }

    @Override
    public Double getPrice() {
        return 0.70;
    }
    
}
