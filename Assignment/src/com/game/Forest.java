package com.game;

import java.util.Random;

public class Forest {
	private char[][] grid;
	private Player player;
	private static final char TREE = 'T';
	private static final char OPEN_SPACE = '.';
	private static final char PLAYER = 'P';
	private static final int TREE_PROBABILITY = 30;
	private Random rand;

	public Forest(int rows, int cols) {
		grid = new char[rows][cols];
		rand = new Random();
		generateForest();
		placePlayer();
	}

	private void generateForest() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (rand.nextInt(100) < TREE_PROBABILITY) {
					grid[i][j] = TREE;
				} else {
					grid[i][j] = OPEN_SPACE;
				}
			}
		}
	}

	private void placePlayer() {
		int row, col;
		do {
			row = rand.nextInt(grid.length);
			col = rand.nextInt(grid[0].length);
		} while (grid[row][col] == TREE);
		player = new Player(row, col);
		grid[row][col] = PLAYER;
	}

	public void display() {
		for (char[] row : grid) {
			for (char cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void movePlayer(char direction) {
		int[] newPosition = player.getNewPosition(direction);

		int newRow = newPosition[0];
		int newCol = newPosition[1];

		if (isValidMove(newRow, newCol)) {
			grid[player.getRow()][player.getCol()] = OPEN_SPACE;
			player.move(newRow, newCol);
			grid[newRow][newCol] = PLAYER;
		} else {
			System.out.println("Invalid move!");
		}
	}

	private boolean isValidMove(int row, int col) {
		return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != TREE;
	}
}
