package com.depositsolutions.tests;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Class for initialising the test runner
 */
public class TestSuiteRunner {

	 public static void main(String[] args) {
		 
		 /**
		  * Initialise Result class for collecting the test case run details
		  */
	      Result result = JUnitCore.runClasses(TestSuiteClass.class);

	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
		
	      System.out.println("====="+result.wasSuccessful());
	   }
}
