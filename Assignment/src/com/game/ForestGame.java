package com.game;

import java.util.Scanner;

public class ForestGame {
	public static void main(String[] args) {
		// Create the game and start it
		Forest forest = new Forest(5, 5);
		forest.display();
		char direction = getUserInput();
		forest.movePlayer(direction);
		forest.display();
	}

	private static char getUserInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter direction (W/S/A/D): ");
		return scanner.next().charAt(0);

	}
	
}
