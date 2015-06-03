package gol;

public class Throttle implements IThrottle {
	private static int TIME_BETWEEN_TURNS = 2 * 1000;
	
	private final int millisecondsToWait;
	
	public Throttle() {
		this(TIME_BETWEEN_TURNS);
	}
	
	public Throttle(int millisecondsToWait) {
		this.millisecondsToWait = millisecondsToWait;
	}
	
	@Override
	public void waitForABit() {
		try {
			Thread.sleep(millisecondsToWait);
		} catch (InterruptedException e) {
			throw new RuntimeException("Died in my sleep.");
		}
	}
}
