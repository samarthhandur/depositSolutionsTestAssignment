package com.depositsolutions.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.AfterClass;
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
 * Test class for validating New Users Email field
 */
public class NewUserCreationEmailFieldTests extends BaseTest{
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
	Log.info("Entering into NewUserCreationEmailFieldTests");
	test = report.startTest("NewUserCreationEmailFieldTests");
	try{
		NewUserCreationPageObject.MODE mode = MODE.ENTER_KEY_WITH_VALIDATION;
		name = UtililtyFunctions.generateRandomCredentials(15, true);
		password = UtililtyFunctions.generateRandomCredentials(20, true);
		email = UtililtyFunctions.generateRandomCredentials(20, false);
		Log.info("Email :: "+email);
		login.createNewUserFromMainPage(name, password, email, password);
		login.pressSubmit(mode);
		}
		catch(NoSuchElementException e){
			Log.error("Element not found");
			}finally{
				allUsers.clickNewUser();
			}
}

/**
 * Logging the ending of tests
 */
@AfterClass
public static void logTestEnd(){
	Log.info("Leaving NewUserCreationEmailFieldTests");
}

/**
 * Test case to verify error when trying to create new user of existing email
 * @throws IOException,InterruptedException 
 */
	@Test
	public void testCaseID_0016_VerifyCreatingNewUserWithExistingEmail() throws IOException, InterruptedException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
		try{
			NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
			name = UtililtyFunctions.generateRandomCredentials(15, true);
			password = UtililtyFunctions.generateRandomCredentials(20, true);
			JSONArray obj = new JSONArray(ServicePageObject.getUsers().string());
			email = obj.getJSONObject(0).getString("email");
			Log.info("Email :: "+email);
			login.createNewUserFromMainPage(name, password, email, password);
			login.pressSubmit(mode);
			assertTrue(login.isUserEmailErrorExists());
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
		}catch(AssertionError e){
			Log.error("Element not found");
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		}
	}
	
	/**
	 * Test case to verify error when trying to create new user with email length >255
	 * @throws IOException,InterruptedException 
	 */
	@Test
	public void testCaseID_0017_VerifyCreatingNewUserWithMaxEmailLength() throws IOException, InterruptedException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
		try{
			NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
			name = UtililtyFunctions.generateRandomCredentials(15, true);
			password = UtililtyFunctions.generateRandomCredentials(20, true);
			email = UtililtyFunctions.generateRandomCredentials(300, false);
			Log.info("Email :: "+email);
			login.createNewUserFromMainPage(name, password, email, password);
			login.pressSubmit(mode);
			assertTrue(login.isUserEmailErrorExists());
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
		}catch(AssertionError e){
			Log.error("Element not found");
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		}
	}
	
	/**
	 * Test case to verify error when trying to create new user without "@" symbol in email
	 * @throws IOException,InterruptedException 
	 */
	@Test
	public void testCaseID_0018_VerifyCreatingNewUserWithoutAtSymbolInEmail() throws IOException, InterruptedException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
		try{
			NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
			name = UtililtyFunctions.generateRandomCredentials(15, true);
			password = UtililtyFunctions.generateRandomCredentials(20, true);
			email = UtililtyFunctions.generateRandomCredentials(20, true);
			Log.info("Email :: "+email);
			login.createNewUserFromMainPage(name, password, email, password);
			login.pressSubmit(mode);
			assertTrue(login.isUserEmailErrorExists());
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
		}catch(AssertionError e){
			Log.error("Element not found");
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		}
	}
	
	/**
	 * Test case to verify error when trying to create new user of without ".com" in the email
	 * @throws IOException,InterruptedException 
	 */
	@Test
	public void testCaseID_0019_VerifyCreatingNewUserWithoutdotcomInEmail() throws IOException, InterruptedException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
		try{
			NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
			name = UtililtyFunctions.generateRandomCredentials(15, true);
			password = UtililtyFunctions.generateRandomCredentials(20, true);
			email = UtililtyFunctions.generateRandomCredentials(20, true).concat("@testData");
			Log.info("Email :: "+email);
			login.createNewUserFromMainPage(name, password, email, password);
			login.pressSubmit(mode);
			assertTrue(login.isUserEmailErrorExists());
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
		}catch(AssertionError e){
			Log.error("Element not found");
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		}
	}
	
	/**
	 * Test case to verify error when trying to create new user without prefix in email
	 * @throws IOException,InterruptedException 
	 */
	@Test
	public void testCaseID_0020_VerifyCreatingNewUserWithoutPrefixInEmail() throws IOException, InterruptedException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
		try{
			NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
			name = UtililtyFunctions.generateRandomCredentials(15, true);
			password = UtililtyFunctions.generateRandomCredentials(20, true);
			email = "@testData.com";
			Log.info("Email :: "+email);
			login.createNewUserFromMainPage(name, password, email, password);
			login.pressSubmit(mode);
			assertTrue(login.isUserEmailErrorExists());
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
		}catch(AssertionError e){
			Log.error("Element not found");
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		}
	}
}
