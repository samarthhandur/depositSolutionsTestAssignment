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
 * Test class for validating New Users Email field
 */
public class NewUserCreationNameFieldTests extends BaseTest{
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
	test = report.startTest("NewUserCreationGenericTests");
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
	Log.info("Leaving NewUserCreationNameFieldTests");
}

/**
 * Test case to verify error when trying to create new user of existing name
 * @throws IOException,InterruptedException 
 */
@Test
public void testCaseID_0021_VerifyCreatingNewUserWithExistingName() throws IOException, InterruptedException{
	Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
	try{
		NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
		JSONArray obj = new JSONArray(ServicePageObject.getUsers().string());
		name = obj.getJSONObject(0).getString("name");
		password = UtililtyFunctions.generateRandomCredentials(20, true);
		email = UtililtyFunctions.generateRandomCredentials(20, false);
    	System.out.println(email);
    	login.createNewUserFromMainPage(name, password, email, password);
    	login.pressSubmit(mode);
    	assertTrue(login.isUserEmailErrorExists());
		test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
		}catch(AssertionError e){
		test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
		}finally{
				allUsers.clickNewUser();
	}
}

/**
 * Test case to verify error when trying to create new user with name length >255
 * @throws IOException,InterruptedException 
 */
@Test
public void testCaseID_0022_VerifyCreatingNewUserWithMaxNameLength() throws IOException, InterruptedException{
	Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
	try
	{
		NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
		name = UtililtyFunctions.generateRandomCredentials(800, true);
		password = UtililtyFunctions.generateRandomCredentials(20, true);
		email = UtililtyFunctions.generateRandomCredentials(15, false);
		System.out.println(email);
		login.createNewUserFromMainPage(name, password, email, password);
		login.pressSubmit(mode);
		assertTrue(login.isUserNameErrorExists());
		test.log(LogStatus.PASS,UtililtyFunctions.getCurrentMethodName());
		Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+UtililtyFunctions.getCurrentMethodName());

		}finally{
			allUsers.clickNewUser();
}
}

/**
 * Test case to verify error when trying to create new user with blank Name field
 * @throws IOException,InterruptedException 
 */
@Test
public void testCaseID_0023_VerifyCreatingNewUserWithBlankName() throws IOException, InterruptedException{
	Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
	try{
		NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
		name = "";
		password = UtililtyFunctions.generateRandomCredentials(20, true);
		email = UtililtyFunctions.generateRandomCredentials(20, false);
		System.out.println(email);
		login.createNewUserFromMainPage(name, password, email, password);
		login.pressSubmit(mode);
		assertTrue(login.isUserEmailErrorExists());
		test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
	}catch(AssertionError e){
		test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+UtililtyFunctions.getCurrentMethodName());
		Log.endTestCase(UtililtyFunctions.getCurrentMethodName());

	}finally{
		allUsers.clickNewUser();
}
}


/**
 * Test case to verify the case sensitivity of new name 
 * @throws IOException,InterruptedException 
 */
@Test
public void testCaseID_0024_VerifyCreatingNewUserWithoutCaseSensitivity() throws IOException, InterruptedException{
	Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
	try{
		NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
		name = UtililtyFunctions.generateRandomCredentials(20, true);
		password = UtililtyFunctions.generateRandomCredentials(20, true);
		email = UtililtyFunctions.generateRandomCredentials(20, false);
		Log.info("NAME :: "+name);
		Log.info("EMAIL :: "+email);
		login.createNewUserFromMainPage(name, password, email, password);
		login.pressSubmit(mode);
		JSONArray obj = new JSONArray(ServicePageObject.getUsers().string());
		assertEquals(name, obj.getJSONObject(obj.length()-1).getString("name"));
		test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
		Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
	}catch(AssertionError e){
		test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
		Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
	}finally{
		allUsers.clickNewUser();
}
}
}
