package basictextadventure;

import java.util.Scanner;

public class Controller {
	Scanner scan = new Scanner(System.in);
	String name = "";
	boolean isGameOver = false;

	public static void main(String[] args) {
		new Controller();
	}

	public Controller() {
		String location = "beforeTower";
		introduction();
		while (!isGameOver) {
			switch (location) {
			case "beforeTower":
				location = beforeTower();
				break;
			case "insideTower":
				location = insideTower();
				break;
			case "topOfTower":
				location = topOfTower();
				break;
			case "insideInn":
				location = ending();
				break;
			default:
				System.out.println("Critical Error!" + location);
			}
		}

	}

	public void introduction() {
		System.out.println("All around you are tall stone walls guarding a small group of houses.");
		System.out.println(
				"You are standing infront of two soldiers with your hands bound, they are sorting out prisoners.");
		System.out.println("Groups of civilians are gathered around the area, watching intently at what is going on.");
		System.out.println("One of the guards then draws his attention to you.");

		System.out.println("\nWait... You there. Step forward.");
		name = getName(scan);
		System.out.println(
				"The guard mentions that you aren't on the list,\nbut despite this, his captain says that you will go to 'The Block'");
		System.out.println(
				"As you are pushed forward, you have no choice but to sit and watch\nas people around you are beheaded one by one.");
		System.out.println("In the distance, you hear a faint roaring...");

		System.out.println("\n" + name + "!");

		System.out.println("\nAs your name is called out, you are pushed towards the chopping block.");
		System.out.println(
				"You feel a boot pushing on your back, knocking you to your knees and your head hitting onto the chopping block.");
		System.out.println("You look up at you fate, the headsman raises his axe above his head.");
		System.out.println("A dragon flies in from the distance and lands on the tower behind the headsman.");
		System.out.println("The force of the dragon's landing forces the headsman to fall to his knees.");
		System.out.println(
				"The dragon roars again, causing balls of fire to rain from the skies. You take this chance to get to your feet.");
		System.out.println(
				"Some of the other prisoners are running into a nearby tower, one turns and calls for you to join them.");
	}

	public String beforeTower() {
		String input = "";
		do {
			System.out.println("\nWALLs are surrounding you, the TOWER is directly ahead of you.");
			input = scan.nextLine();
			input = input.trim().toUpperCase();
			switch (input) {
			case ("WALL"):
				System.out.println("Your hands are bound! You can't climb the wall.");
				input = "";
				break;
			case ("TOWER"):
				System.out.println("You run to the tower.");
				return "insideTower";
			default:
				System.out.println("Command not recognised.");
				input = "";
			}
		} while (input.isEmpty());
		return null;
	}

	private String insideTower() {
		String input = "";
		do {
			System.out.println("\nYou are inside the tower. One of the other prisoners is telling you to go UPSTAIRS. Behind you is the OUTSIDE.");
			input = scan.nextLine();
			input = input.trim().toUpperCase();
			switch (input) {
			case ("UPSTAIRS"):
				System.out.println("You make your way up the stairs.");
				return "topOfTower";
			case ("OUTSIDE"):
				System.out.println("You head back outside of the tower.");
				return "beforeTower";
			default:
				System.out.println("Command not recognised.");
				input = "";
			}
		} while (input.isEmpty());
		return null;
	}
	
	public String topOfTower() {
		String input = "";
		do {
			System.out.println("\nThe stairs further up the tower are blocked off by rubble. \n"
					+ "There is a hole in the wall large enough to climb through where you could jump to the top of the INN. The other prisoners are still DOWNSTAIRS.");
			input = scan.nextLine();
			input = input.trim().toUpperCase();
			switch (input) {
			case ("INN"):
				System.out.println("You jump through the hole in the wall to the nearby inn.");
				return "insideInn";
			case ("DOWNSTAIRS"):
				System.out.println("You head back down the stairs.");
				return "insideTower";
			default:
				System.out.println("Command not recognised.");
				input = "";
			}
		} while (input.isEmpty());
		return null;
	}
	
	public String ending() {
		String input = "";
		
			System.out.println("\nYou have successfully escaped!");
			isGameOver = true;
		return null;
	}
	
	public String getName(Scanner scan) {
		String name;
		String nameRegex = "\\w+(\\s\\w+)*";
		do {
			System.out.println("Who are you?");
			name = scan.nextLine();
			name = name.trim();
			if (!name.matches(nameRegex)) {
				System.out.println("Name is invalid");
				name = "";
			}
		} while (name.isEmpty());
		return name;
	}
}
