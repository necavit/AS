package edu.upc.fib.wordguess.util;

public class Log {
	
	public static void debug(String tag, String message) {
		System.out.println(tag + ": " + message);
	}
	
	public static void error(String tag, String message) {
		System.err.println(tag + ": " + message);
	}
	
}
