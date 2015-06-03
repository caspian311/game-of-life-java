package gol;

public class Main {
	public static void main(String[] args) {
		IDisplay display = new Display(System.out);
		IThrottle throttle = new Throttle();

		GameOfLife gol = new GameOfLife();
		gol.play();
	}
}
