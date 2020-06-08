package com.bridgelabz.blzlib;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class BLStdOut {

	//force Unicode UTF-8 encoding; otherwise it's system dependent
	private static final String CHARSET_NAME = "UTF-8";	
	
	//assuming language English, country = US for consistency with StdIn
	private static final Locale LOCALE = Locale.US;
	
	private static PrintWriter out;
	
	static{
		try{
			out = new PrintWriter(new OutputStreamWriter(System.out, CHARSET_NAME), true); 
		}
		catch(UnsupportedEncodingException e){
			System.out.println(e);
		}
	}
	
	//don't instantiate
	private BLStdOut(){}
	
	/**
     * Prints an String to standard output and flushes standard output.
     * 
     * @param x the String to print
     */
	public static void print(String x) {
        out.print(x);
        out.flush();
    }
	
	 /**
     * Prints a string to standard output and then terminates the line.
     *
     * @param x the string to print
     */
	public static void println(String x) {
	        out.println(x);
	}
	
	/**
     * Terminates the current line by printing the line-separator string.
     */
	public static void println() {
        out.println();
    }
	
	/**
     * Prints a formatted string to standard output, using the specified format
     * string and arguments, and then flushes standard output.
     *
     *
     * @param format the <a href = "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">format string</a>
     * @param args   the arguments accompanying the format string
     */
    public static void printf(String format, Object... args) {
        out.printf(LOCALE, format, args);
        out.flush();
    }
    
    public static void main(String[] args) {
		BLStdOut.printf("%.6f\n", 1.0/7.0);
		BLStdOut.print("Type a string: ");
	}
}
