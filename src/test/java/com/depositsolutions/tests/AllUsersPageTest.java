package com.depositsolutions.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.json.JSONArray;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import com.depositsolutions.pages.AllUsersPageObject;
import com.depositsolutions.pages.NewUserCreationPageObject;
import com.depositsolutions.pages.NewUserCreationPageObject.MODE;
import com.depositsolutions.pages.ServicePageObject;
import com.depositsolutions.utils.BaseTest;
import com.depositsolutions.utils.Log;
import com.depositsolutions.utils.UtililtyFunctions;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Test class for validating All Users Page
 */
public class AllUsersPageTest extends BaseTest{
	
	static NewUserCreationPageObject login = new NewUserCreationPageObject(driver);
	static AllUsersPageObject allUsers = new AllUsersPageObject(driver);
	static String name;
	static String password;
	static String email;

	/**
	 * Create 5 new users before starting the tests
	 * @throws InterruptedException 
	 */
@BeforeClass
public static void createFiveNewUsers() throws InterruptedException{
	Log.info("Entering into AllUsersPageTest");
	test = report.startTest("AllUsersPageTest");
	for(int i =0;i<5;i++){
	try{
		NewUserCreationPageObject.MODE mode = MODE.ENTER_KEY_WITH_VALIDATION;
		name = UtililtyFunctions.generateRandomCredentials(15, true);
		password = UtililtyFunctions.generateRandomCredentials(20, true);
		email = UtililtyFunctions.generateRandomCredentials(20, false);
		Log.info("Email created :: "+email);
		login.createNewUserFromMainPage(name, password, email, password);
		login.pressSubmit(mode);
		}
	catch(NoSuchElementException e){
		System.out.println("Element not found");
		}finally{
			allUsers.clickNewUser();
			
		}
		}
	}


/**
 * Logging the ending of tests
 */
@AfterClass
public static void logTestEnd(){
	Log.info("Leaving AllUsersPageTest");
}


/**
 * Test case to verify page header on All users page
 * @throws IOException,InterruptedException 
 */
@Test
public void testCaseID_0031_VerifyAllUserPageHeader() throws IOException, InterruptedException{
	Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
	try{
		login.clickAllUsersButton();
		assertTrue(allUsers.isAllUsersHeaderDisplayed());
		test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		}finally{
			allUsers.clickNewUser();
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
		}
}

/**
 * Test case to verify New User button on All Users page
 * @throws IOException,InterruptedException 
 */
@Test
public void testCaseID_0032_VerifyNewUserButtonDisplay() throws IOException, InterruptedException{
	Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
	try{
		login.clickAllUsersButton();
		assertTrue(allUsers.isNewUsersButtonDisplayed());
		test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		}finally{
			allUsers.clickNewUser();
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
		}
}

/**
 * Test case to verify Users table size by comparing with REST GET service
 * @throws IOException,InterruptedException 
 */
@Test
public void testCaseID_0031_VerifyUsersTableSize() throws IOException, InterruptedException{
	Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
	login.clickAllUsersButton();
	Log.info("Total users :: "+ServicePageObject.getUsers().string());
	JSONArray obj = new JSONArray(ServicePageObject.getUsers().string());
	try{
		Assert.assertEquals(obj.length(), allUsers.userTableSize());
		test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		}finally{
			allUsers.clickNewUser();
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
		}
	}

/**
 * Test case to verify newly created user to be appearing at the bottom of table
 * @throws IOException,InterruptedException 
 */
@Test
public void testCaseID_0032_VerifyUsersCreatedListedAtTheLastRow() throws IOException, InterruptedException{
	Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
	NewUserCreationPageObject.MODE mode = MODE.ENTER_KEY_WITH_VALIDATION;
	name = UtililtyFunctions.generateRandomCredentials(15, true);
	password = UtililtyFunctions.generateRandomCredentials(20, true);
	email = UtililtyFunctions.generateRandomCredentials(20, false);
	Log.info("Email created :: "+email);
	login.createNewUserFromMainPage(name, password, email, password);
	login.pressSubmit(mode);
	try{
		assertTrue(allUsers.getElementTextFromUserTable(allUsers.userTableSize()-1).contains(email));
		test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
		}catch(AssertionError e){
			Log.error("FAILED ::  "+UtililtyFunctions.getCurrentMethodName());
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		}finally{
			allUsers.clickNewUser();
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
		}
	}
}
