package com.example;

import com.burger.Burger;
import com.pizza.Pizza;

public class AllData {
    private static Burger burger;
    private static Pizza pizza;

    public static void setBurger(Burger burger1) {
        burger = burger1;
    }

    public static Burger getBurger() {
        return burger;
    }

    public static void setPizza(Pizza pizza1) {
        pizza = pizza1;
    }

    public static Pizza getPizza() {
        return pizza;
    }
}
