package gol;

public class Board {
	private final boolean[][] grid;
	
	public Board(boolean[][] grid) {
		this.grid = grid;
	}
	
	public boolean[][] getGrid() {
		return grid;
	}
}
