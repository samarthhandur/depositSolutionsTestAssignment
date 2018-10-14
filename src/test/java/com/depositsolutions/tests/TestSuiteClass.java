package com.depositsolutions.tests;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.depositsolutions.utils.BaseTest;
import com.depositsolutions.utils.Constants;
import com.depositsolutions.utils.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



/**
 * Empty Class for initialising the test suite by using @RunWith annotation
 * @param SuiteClass name
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
	NewUserCreationGenericTests.class,
	NewUserCreationEmailFieldTests.class,
	NewUserCreationNameFieldTests.class,
	NewUserCreationPasswordFieldTests.class,
	AllUsersPageTest.class
})

public class TestSuiteClass extends BaseTest{
	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setTests() throws IOException{
		report = new ExtentReports(Constants.PATH_ROOT.concat(Constants.TEST_REPORT_FILE));
		FileUtils.write(new File(Constants.PATH_ROOT.concat(Constants.TEST_LOGS)), "");
	}
	@AfterClass
	public static void finishTests(){
		   if (driver != null) {
	        	Log.info("=====Browser Session Ended=====");
	            driver.quit();
	            report.flush();
	        }
	}
}
