package gol;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ThrottleTest {
	
	@Test
	public void whenWeLongerThanTheAllottedTime() throws InterruptedException {
		final int timeToWait = 500; 
		final Flag flag = new Flag();
		new Thread(new Runnable() {
			@Override
			public void run() {
				new Throttle(timeToWait).waitForABit();
				flag.isSet = true;
			}
		}).start();
		
		Thread.sleep(timeToWait + 50);
		
		assertTrue(flag.isSet);
	}
	
	@Test
	public void whenWeHaventFinishedWaitingLongEnough() throws InterruptedException {
		final int timeToWait = 500; 
		final Flag flag = new Flag();
		new Thread(new Runnable() {
			@Override
			public void run() {
				new Throttle(timeToWait).waitForABit();
				flag.isSet = true;
			}
		}).start();
		
		Thread.sleep(10);
		
		assertFalse(flag.isSet);
	}
	
	private static final class Flag {
		private boolean isSet;
	}
}
