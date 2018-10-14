package com.depositsolutions.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.json.JSONArray;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.depositsolutions.pages.AllUsersPageObject;
import com.depositsolutions.pages.NewUserCreationPageObject;
import com.depositsolutions.pages.ServicePageObject;
import com.depositsolutions.pages.NewUserCreationPageObject.MODE;
import com.depositsolutions.utils.BaseTest;
import com.depositsolutions.utils.Log;
import com.depositsolutions.utils.UtililtyFunctions;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Test class for validating Password field
 */
public class NewUserCreationPasswordFieldTests extends BaseTest{
	static NewUserCreationPageObject login = new NewUserCreationPageObject(driver);
	static AllUsersPageObject allUsers = new AllUsersPageObject(driver);
	static String name;
	static String password;
	static String email;

	/**
	 * Create one new user before starting the test
	 */
@BeforeClass
public static void createNewUser() throws InterruptedException{
	test = report.startTest("NewUserCreationPasswordFieldTests");
	try{
		NewUserCreationPageObject.MODE mode = MODE.ENTER_KEY_WITH_VALIDATION;
		name = UtililtyFunctions.generateRandomCredentials(15, true);
		password = UtililtyFunctions.generateRandomCredentials(20, true);
		email = UtililtyFunctions.generateRandomCredentials(10, false);
		System.out.println(email);
		login.createNewUserFromMainPage(name, password, email, password);
		login.pressSubmit(mode);
		}
		catch(NoSuchElementException e){
			System.out.println("Element not found");
			}finally
				{
					allUsers.clickNewUser();
				}
}

/**
 * Logging the ending of tests
 */
@AfterClass
public static void logTestEnd(){
	Log.info("Leaving NewUserCreationPasswordFieldTests");
}


/**
 * Test case to verify error when trying to create new user with blank password 
 * field and valid confirm password field
 * @throws IOException,InterruptedException 
 */
@Test
public void testCaseID_0025_VerifyCreatingNewUserWithBlankPwdFieldAndValidCnfPasswordField() throws IOException, InterruptedException{
	Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
	try{
		NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
		name = UtililtyFunctions.generateRandomCredentials(20, true);
		password = UtililtyFunctions.generateRandomCredentials(20, true);
		email = UtililtyFunctions.generateRandomCredentials(20, false);
    	System.out.println(email);
    	login.createNewUserFromMainPage(name, "", email, password);
    	login.pressSubmit(mode);
    	assertTrue(login.isUserEmailErrorExists());
    	test.log(LogStatus.PASS,UtililtyFunctions.getCurrentMethodName());
		Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
	}catch(AssertionError e){
		test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+UtililtyFunctions.getCurrentMethodName());
		Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
	}
	}

/**
 * Test case to verify error when trying to create new user with valid password 
 * field and blank confirm password field
 * @throws IOException,InterruptedException 
 */
@Test
public void testCaseID_0026_VerifyCreatingNewUserWithValidPwdFieldAndBlankCnfPasswordField() throws IOException, InterruptedException{
	Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
	try{
		NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
		name = UtililtyFunctions.generateRandomCredentials(20, true);
		password = UtililtyFunctions.generateRandomCredentials(20, true);
		email = UtililtyFunctions.generateRandomCredentials(20, false);
    	System.out.println(email);
    	login.createNewUserFromMainPage(name, password, email, "");
    	login.pressSubmit(mode);
    	assertTrue(login.isUserEmailErrorExists());
    	test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
    	Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
	}catch(AssertionError e){
		test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
	}
	}

/**
 * Test case to verify error when trying to create new user with valid password 
 * field and different confirm password field
 * @throws IOException,InterruptedException 
 */
@Test
public void testCaseID_0027_VerifyCreatingNewUserWithValidPwdFieldAndDifferentCnfPasswordField() throws IOException, InterruptedException{
	Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
	try{
		NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
		name = UtililtyFunctions.generateRandomCredentials(20, true);
		password = UtililtyFunctions.generateRandomCredentials(20, true);
		email = UtililtyFunctions.generateRandomCredentials(20, false);
		String conf_email = UtililtyFunctions.generateRandomCredentials(20, true);
    	System.out.println(email);
    	login.createNewUserFromMainPage(name, password, email, conf_email);
    	login.pressSubmit(mode);
    	assertTrue(login.isUserEmailErrorExists());
    	test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
    	Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
	}catch(AssertionError e){
		test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
	}
	}

/**
 * Test case to verify error when trying to create new user with password length > 255
 * @throws IOException,InterruptedException 
 */
@Test
public void testCaseID_0028_VerifyCreatingNewUserWithPasswordMaxLength() throws IOException, InterruptedException{
	Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
	try{
		NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
		name = UtililtyFunctions.generateRandomCredentials(20, true);
		password = UtililtyFunctions.generateRandomCredentials(800, true);
		email = UtililtyFunctions.generateRandomCredentials(20, false);
    	System.out.println(email);
    	login.createNewUserFromMainPage(name, password, email, password);
    	login.pressSubmit(mode);
    	assertTrue(login.isUserEmailErrorExists());
    	test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
    	Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
	}catch(AssertionError e){
		test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
	}
	}

/**
 * Test case to verify error when trying to create new user with password length < 6
 * @throws IOException,InterruptedException 
 */
@Test
public void testCaseID_0029_VerifyCreatingNewUserWithPasswordMinLength() throws IOException, InterruptedException{
	Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
	try{
		NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
		name = UtililtyFunctions.generateRandomCredentials(20, true);
		password = UtililtyFunctions.generateRandomCredentials(10, true);
		email = UtililtyFunctions.generateRandomCredentials(20, false);
    	System.out.println(email);
    	login.createNewUserFromMainPage(name, password, email, password);
    	login.pressSubmit(mode);
    	assertTrue(login.isUserEmailErrorExists());
    	test.log(LogStatus.PASS,UtililtyFunctions.getCurrentMethodName());
    	Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
	}catch(AssertionError e){
		test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ "testCaseID_0029_VerifyCreatingNewUserWithPasswordMinLength");
		Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
	}
	}

/**
 * Test case to verify the password entered is encrypted one
 * @throws IOException,InterruptedException 
 */
@Test
public void testCaseID_0030_VerifyPasswordEnteredIsEncrypted() throws IOException, InterruptedException{
	Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
	try{
		NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
		name = UtililtyFunctions.generateRandomCredentials(20, true);
		password = UtililtyFunctions.generateRandomCredentials(10, true);
		email = UtililtyFunctions.generateRandomCredentials(20, false);
    	System.out.println(email);
    	login.createNewUserFromMainPage(name, password, email, password);
    	assertEquals(login.getConfirmPasswordFieldText(), "");
    	test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
    	Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
	}catch(AssertionError e){
		test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
	}
	}
}
