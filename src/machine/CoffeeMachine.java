package machine;

import java.util.Scanner;

public class CoffeeMachine {
	public static int water = 400;
	public static int milk = 540;
	public static int beans = 120;
	public static int disposableCups = 9;
	public static int money = 550;

	public static int espressoWater = 250;
	public static int espressoBeans = 16;
	public static int espressoCost = 4;

	public static int latteWater = 350;
	public static int latteMilk = 75;
	public static int latteBeans = 20;
	public static int latteCost = 7;

	public static int cappuccinoWater = 200;
	public static int cappuccinoMilk = 100;
	public static int cappuccinoBeans = 12;
	public static int cappuccinoCost = 6;

	public static void remaining(){
		System.out.println("The coffee machine has:");
		System.out.println(CoffeeMachine.water + " ml of water");
		System.out.println(CoffeeMachine.milk + " ml of milk");
		System.out.println(CoffeeMachine.beans + " g of coffee beans");
		System.out.println(CoffeeMachine.disposableCups + " disposable cups");
		System.out.println("$" + CoffeeMachine.money + " of money");
	}

	public static void buyEspresso(){
		if(CoffeeMachine.water < CoffeeMachine.espressoWater) {
			System.out.println("Sorry, not enough water!");
		}
		else if(CoffeeMachine.beans < CoffeeMachine.espressoBeans) {
			System.out.println("Sorry, not enough coffee beans!");
		}
		else {
			CoffeeMachine.water -= CoffeeMachine.espressoWater;
			CoffeeMachine.beans -= CoffeeMachine.espressoBeans;
			CoffeeMachine.money += CoffeeMachine.espressoCost;
			System.out.println("I have enough resources, making you a coffee!");
		}
	}
	public static void buyLatte(){
		if(CoffeeMachine.water < CoffeeMachine.latteWater) {
			System.out.println("Sorry, not enough water!");
		}
		else if(CoffeeMachine.milk < CoffeeMachine.latteMilk) {
			System.out.println("Sorry, not enough milk!");
		}
		else if(CoffeeMachine.beans < CoffeeMachine.latteBeans) {
			System.out.println("Sorry, not enough coffee beans!");
		}
		else {
			CoffeeMachine.water -= CoffeeMachine.latteWater;
			CoffeeMachine.milk -= CoffeeMachine.latteMilk;
			CoffeeMachine.beans -= CoffeeMachine.latteBeans;
			CoffeeMachine.money += CoffeeMachine.latteCost;
			System.out.println("I have enough resources, making you a coffee!");
		}
	}
	public static void buyCappuccino(){
		if(CoffeeMachine.water < CoffeeMachine.cappuccinoWater) {
			System.out.println("Sorry, not enough water!");
		}
		else if(CoffeeMachine.milk < CoffeeMachine.cappuccinoMilk) {
			System.out.println("Sorry, not enough milk!");
		}
		else if(CoffeeMachine.beans < CoffeeMachine.cappuccinoBeans) {
			System.out.println("Sorry, not enough coffee beans!");
		}
		else {
			CoffeeMachine.water -= CoffeeMachine.cappuccinoWater;
			CoffeeMachine.milk -= CoffeeMachine.cappuccinoMilk;
			CoffeeMachine.beans -= CoffeeMachine.cappuccinoBeans;
			CoffeeMachine.money += CoffeeMachine.cappuccinoCost;
			System.out.println("I have enough resources, making you a coffee!");
		}
	}

	public static void buy(Scanner s){
		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
		
		String opt = s.nextLine();

		boolean stop = false;

		while(!stop){
			switch(opt){
				case "1": CoffeeMachine.disposableCups -= 1; buyEspresso(); stop=true;
					break;
				case "2": CoffeeMachine.disposableCups -= 1; buyLatte(); stop = true;
					break;
				case "3": CoffeeMachine.disposableCups -= 1; buyCappuccino(); stop=true;
					break;
				case "back": stop=true;
					break;
				default:
					break;
			}
		}
	}

	public static void fill(Scanner s){
		System.out.println("Write how many ml of water you want to add:");
		CoffeeMachine.water += s.nextInt();
		System.out.println("Write how many ml of milk you want to add:");
		CoffeeMachine.milk += s.nextInt();
		System.out.println("Write how many grams of coffee beans you want to add:");
		CoffeeMachine.beans += s.nextInt();
		System.out.println("Write how many disposable cups of coffee you want to add:");
		CoffeeMachine.disposableCups += s.nextInt();
		s.nextLine();
	}

	public static void take(){
		System.out.println("I gave you $" + CoffeeMachine.money);
		CoffeeMachine.money = 0;
	}

	public static void mainMenu(){
		//https://stackoverflow.com/questions/50206675/how-to-use-scanner-in-both-main-and-method
		Scanner s = new Scanner(System.in);
		boolean stop = false;

		while(!stop){
			System.out.println("Write action (buy, fill, take, remaining, exit):");
			String action = s.nextLine();

			System.out.println();

			switch(action){
				case "buy": CoffeeMachine.buy(s); System.out.println();
					break;
				case "fill": CoffeeMachine.fill(s); System.out.println();
					break;
				case "take": CoffeeMachine.take(); System.out.println();
					break;
				case "remaining": CoffeeMachine.remaining(); System.out.println();
					break;
				case "exit": stop = true;
					break;
				default: break;
			}
		}
		
		s.close(); // Only close once
	}
}


