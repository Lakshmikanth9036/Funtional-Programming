package com.bridgelabz.blzlib;

public class StopWatch {
	
	private final long start;
	
	/**
	 * Initialize a new StopWatch
	 */
	public StopWatch(){
		start = System.currentTimeMillis();
	}
	
	/**
	 * Returns the elapased CPU time (in seconds) since the stopwatch is created.
	 * 
	 * @return elapsed CPU time (in seconds) since the stopwatch was created
	 */
	
	public double elapsedTime(){
		long current = System.currentTimeMillis();
		return (current-start)/1000.0;
	}

}
