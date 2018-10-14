package com.depositsolutions.utils;

import org.apache.log4j.Logger;

public class Log {

	/**
	 * Initialize Logger class and create Log reference variable
	 */
	private static Logger Log =Logger.getLogger(Log.class.getName());
	
	/**
	 * Method to print starting of the test suite into log file
	 * @param String test case name 
	 */
	public static void startTestCase(String sTestCaseName){
		Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		}
	 
	/**
	 * Method to print ending of the test suite into log file
	 * @param String test case name 
	 */
	 
	 public static void endTestCase(String sTestCaseName){
	 
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
	 
		Log.info("X");
	 
		Log.info("X");
	 
		Log.info("X");
	 
		Log.info("X");
	 
		}
	 
	 /**
	  * 
	 	Log Level methods : info level   
	  */
	 public static void info(String message) {
	 
			Log.info(message);
	 
			}
	 
	 /**
	  * 
	 	Log Level methods : warn level   
	  */
	 public static void warn(String message) {
	 
	    Log.warn(message);
	 
		}
	 
	 /**
	  * 
	 	Log Level methods : error level   
	  */
	 public static void error(String message) {
	 
	    Log.error(message);
	 
		}
	 
	 /**
	  * 
	 	Log Level methods : fatal level   
	  */
	 public static void fatal(String message) {
	 
	    Log.fatal(message);
	 
		}
	 
	 /**
	  * 
	 	Log Level methods : debug level   
	  */
	 public static void debug(String message) {
	 
	    Log.debug(message);
	 
		}
}
