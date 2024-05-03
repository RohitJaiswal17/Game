package com.game;

public class Player {

	private int row;
	private int col;

	public Player(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void move(int newRow, int newCol) {
		row = newRow;
		col = newCol;
	}

	public int[] getNewPosition(char direction) {
		int[] newPosition = new int[2];
		switch (direction) {
		case 'W':
			newPosition[0] = row - 1;
			newPosition[1] = col;
			break;
		case 'S':
			newPosition[0] = row + 1;
			newPosition[1] = col;
			break;
		case 'A':
			newPosition[0] = row;
			newPosition[1] = col - 1;
			break;
		case 'D':
			newPosition[0] = row;
			newPosition[1] = col + 1;
			break;
		default:
			break;
		}
		return newPosition;
	}
}
