package srz_burger.burger.bun;

import srz_burger.burger.MenuItem;

public abstract class BurgerBun implements MenuItem {
    public abstract String toString();

    public String toNiceString() {
        return "Bun: " + this.toString() + " $" + this.getPrice();

    }

    @Override
    public Double getPrice() {
        return 1.00;
    }
    
}
