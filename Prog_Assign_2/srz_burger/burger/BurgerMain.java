package srz_burger.burger;
import java.util.Scanner;

import srz_burger.burger.bun.BriocheBun;
import srz_burger.burger.bun.PotatoBun;
import srz_burger.burger.bun.SesameBun;

import srz_burger.burger.cheese.AmericanCheese;
import srz_burger.burger.cheese.CheddarCheese;
import srz_burger.burger.cheese.PepperjackCheese;
import srz_burger.burger.cheese.SwissCheese;

import srz_burger.burger.garnishes.BaconGarnish;
import srz_burger.burger.garnishes.FriedEggGarnish;
import srz_burger.burger.garnishes.GuacamoleGarnish;
import srz_burger.burger.garnishes.LettuceGarnish;
import srz_burger.burger.garnishes.OnionRingGarnish;
import srz_burger.burger.garnishes.PickleGarnish;
import srz_burger.burger.garnishes.TomatoGarnish;
import srz_burger.burger.patties.BeefPatty;
import srz_burger.burger.patties.ChickenPatty;
import srz_burger.burger.patties.ImpossiblePatty;
import srz_burger.burger.patties.VeggiePatty;

public class BurgerMain {
    private Burger burger;
    private Scanner input;

    public BurgerMain() {
        burger = new Burger();
        input = new Scanner(System.in);
    }

    private void inputBunChoice() {
        Boolean validChoice = false;
        Integer choice = 0;

        System.out.println("What kind of bun would you like:");
        System.out.println("1 - Brioche Bun");
        System.out.println("2 - Potato Bun");
        System.out.println("3 - Sesame Bun");
        while (!validChoice) {
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    burger.setBun(new BriocheBun());
                    validChoice = true;
                    break;
                case 2:
                    burger.setBun(new PotatoBun());
                    validChoice = true;
                    break;
                case 3:
                    burger.setBun(new SesameBun());
                    validChoice = true;
                    break;            
                default:
                    System.out.println("Pick between 1-3");
            }
        }
    }
    
    private void inputCheeseChoice() {
        System.out.print("How many different cheese slices (max 4)? ");
		Integer numToppings = input.nextInt();
		for (Integer i = 0; i < numToppings; i++) {
			Boolean validChoice = false;
			System.out.println("1 - American Cheese");
			System.out.println("2 - Cheddar Cheese");
			System.out.println("3 - Pepperjack Cheese");
			System.out.println("4 - Swiss Cheese");
			System.out.print("Your choice: ");
			while (!validChoice) {
				Integer choice = input.nextInt();
				switch(choice) {
					case 1: 
						burger.addCheese(new AmericanCheese());
						validChoice = true;
						break;
					case 2: 
						burger.addCheese(new CheddarCheese());
						validChoice = true;
						break;
					case 3: 
						burger.addCheese(new PepperjackCheese());
						validChoice = true;
						break;
					case 4: 
						burger.addCheese(new SwissCheese());
						validChoice = true;
						break;
					default:
						System.out.println("Pick between 1-4");
                }
            }
        }
    }

    private void inputGarnishChoice() {
        System.out.print("How many different garnishes (max 4)? ");
		Integer numToppings = input.nextInt();
		for (Integer i = 0; i < numToppings; i++) {
			Boolean validChoice = false;
			System.out.println("1 - Bacon");
			System.out.println("2 - Fried Egg");
			System.out.println("3 - Guacamole");
			System.out.println("4 - Lettuce");
			System.out.println("5 - Onion Rings");
            System.out.println("6 - Pickles");
            System.out.println("7 - Tomato");
			System.out.print("Your choice: ");
			while (!validChoice) {
				Integer choice = input.nextInt();
				switch(choice) {
					case 1: 
						burger.addGarnishes(new BaconGarnish());
						validChoice = true;
						break;
					case 2: 
						burger.addGarnishes(new FriedEggGarnish());
						validChoice = true;
						break;
					case 3: 
						burger.addGarnishes(new GuacamoleGarnish());
						validChoice = true;
						break;
					case 4: 
						burger.addGarnishes(new LettuceGarnish());
						validChoice = true;
						break;
                    case 5: 
						burger.addGarnishes(new OnionRingGarnish());
						validChoice = true;
						break;
                    case 6: 
						burger.addGarnishes(new PickleGarnish());
						validChoice = true;
						break;
                    case 7: 
						burger.addGarnishes(new TomatoGarnish());
						validChoice = true;
						break;
					default:
						System.out.println("Pick between 1-7");
                }
            }
        }
    }

    private void inputPattyChoice() {
        System.out.print("How many different patties (max 4)? ");
		Integer numToppings = input.nextInt();
		for (Integer i = 0; i < numToppings; i++) {
			Boolean validChoice = false;
			System.out.println("1 - Beef Patty");
			System.out.println("2 - Chicken Patty");
			System.out.println("3 - Impossible Patty");
			System.out.println("4 - Veggie Patty");
			System.out.print("Your choice: ");
			while (!validChoice) {
				Integer choice = input.nextInt();
				switch(choice) {
					case 1: 
						burger.addPatties(new BeefPatty());
						validChoice = true;
						break;
					case 2: 
						burger.addPatties(new ChickenPatty());
						validChoice = true;
						break;
					case 3: 
						burger.addPatties(new ImpossiblePatty());
						validChoice = true;
						break;
					case 4: 
						burger.addPatties(new VeggiePatty());
						validChoice = true;
						break;
					default:
						System.out.println("Pick between 1-4");
                }
            }
        }
    }


    private void showBurger() {
        burger.sortItems();
        burger.displayItems();
    }

    public void runMenu() {
        inputBunChoice();
        inputCheeseChoice();
        inputGarnishChoice();
        inputPattyChoice();
        showBurger();
    }


    public static void main(String[] args) {
        BurgerMain bm = new BurgerMain();
        bm.runMenu();

        
    }
}
