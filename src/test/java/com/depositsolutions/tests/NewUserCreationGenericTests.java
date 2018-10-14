package com.depositsolutions.tests;
import com.depositsolutions.pages.AllUsersPageObject;
import com.depositsolutions.pages.NewUserCreationPageObject;
import com.depositsolutions.pages.ServicePageObject;
import com.depositsolutions.pages.NewUserCreationPageObject.MODE;
import com.depositsolutions.utils.BaseTest;
import com.depositsolutions.utils.Log;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.junit.After;
import org.junit.BeforeClass;

import com.depositsolutions.utils.UtililtyFunctions;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Test class for validating Generic features of New Users page
 */
public class NewUserCreationGenericTests extends BaseTest{
	NewUserCreationPageObject login = new NewUserCreationPageObject(driver);
	AllUsersPageObject allUsers = new AllUsersPageObject(driver);
	String name, password,email;
	

	/**
	 * Create one new user before starting the test
	 */
	@BeforeClass
	public static void setUpTestName(){
		test = report.startTest("NewUserCreationGenericTests");
	}
	
	/**
	 * Test case to verify Page Header Label display
	 * @throws IOException 
	 */
	@Test
	public void testCaseID_001_VerifyPageHeaderLabelDisplay() throws IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
		try{
			assertTrue(login.isHeaderDisplayed());
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());
		}
		
	}
	
	/**
	 * Test case to verify Name Label display
	 * @throws IOException 
	 */
	@Test
	public void testCaseID_002_VerifyNameLabelDisplay() throws IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());
		try{
			assertTrue(login.isNameLabelDisplayed());
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}
		}
	
	/**
	 * Test case to verify email Label display
	 * @throws IOException 
	 */
	@Test
	public void testCaseID_003_VerifyEmailLabelDisplay() throws IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());	
		try{
			assertTrue(login.isEmailLabelDisplayed());
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());		
		}
	}
	
	/**
	 * Test case to verify password  Label display
	 * @throws IOException 
	 */
	@Test
	public void testCaseID_004_VerifyPasswordLabelDisplay() throws IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());	
		try{
			assertTrue(login.isPasswordLabelDisplayed());
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());		
		}
	}
	
	
	/**
	 * Test case to verify confirm password Label display
	 * @throws IOException 
	 */
	@Test
	public void testCaseID_005_VerifyConfirmPasswordLabelDisplay() throws IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());	
		try{
			assertTrue(login.isConfirmPasswordDisplayed());
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());		
		}
	}
	
	
	/**
	 * Test case to verify All Users button display
	 * @throws IOException 
	 */
	@Test
	public void testCaseID_006_VerifyAllUsersButtonDisplay() throws IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());	
		try{
			assertTrue(login.isAllUsersButtonDisplayed());
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());		
		}
	}
	
	
	/**
	 * Test case to verify Submit button display
	 * @throws IOException 
	 */
	@Test
	public void testCaseID_007_VerifySubmitButtonDisplay() throws IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());	
		try{
			assertTrue(login.isSubmitButtonDisplayed());
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());		
		}
	}
	
	/**
	 * Test case to verify Name placeholder text 
	 * @throws IOException 
	 */
	@Test
	public void testCaseID_008_VerifyNamePlaceholderText() throws IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());	
		try{
			assertEquals(login.getNameFieldPlaceholderText(),"name");
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());		
		}
	}
	
	/**
	 * Test case to verify email placeholder text 
	 * @throws IOException 
	 */
	@Test
	public void testCaseID_009_VerifyEmailPlaceholderText() throws IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());	
		try{
			assertEquals(login.getEmailFieldPlaceholderText(),"your@email.com");
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());		
		}
	}
	
	/**
	 * Test case to verify password placeholder text 
	 * @throws IOException 
	 */
	@Test
	public void testCaseID_0010_VerifyPasswordPlaceholderText() throws IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());	
		try{
			assertEquals(login.getPasswordFieldPlaceholderText(),"min 6 characters");
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());		
		}
	}
	
	/**
	 * Test case to verify confirm password placeholder text 
	 * @throws IOException 
	 */
	@Test
	public void testCaseID_0011_VerifyConfirmPasswordPlaceholderText() throws IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());	
		try{
			assertEquals(login.getConfirmPasswordFieldPlaceholderText(),"min 6 characters");
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());		
		}
	}
	
	
	/**
	 * Test case to verify creating user by all valid credentials by clicking SUBMIT button
	 * @throws IOException , InterruptedException
	 */
	@Test
	public void testCaseID_0012_VerifyCreateUserByEnteringValidCredentials() throws InterruptedException, IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());	
		NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITH_VALIDATION;
		String name = UtililtyFunctions.generateRandomCredentials(15, true);
		String password = UtililtyFunctions.generateRandomCredentials(20, true);
		String email = UtililtyFunctions.generateRandomCredentials(10, false);
		login.createNewUserFromMainPage(name, password, email, password);
		login.pressSubmit(mode);
		try{
			assertTrue(allUsers.isAllUsersHeaderDisplayed());
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}finally{
			allUsers.clickNewUser();
		}
	}
	
	/**
	 * Test case to verify creating user by all valid credentials by clicking ENTER button
	 * @throws IOException , InterruptedException
	 */
	@Test
	public void testCaseID_0013_VerifyCreateUserByEnteringENTERButton() throws InterruptedException, IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());	
		name = UtililtyFunctions.generateRandomCredentials(15, true);
		password = UtililtyFunctions.generateRandomCredentials(20, true);
		email = UtililtyFunctions.generateRandomCredentials(10, false);
		login.createNewUserFromMainPage(name, password, email, password);
		NewUserCreationPageObject.MODE mode = MODE.ENTER_KEY_WITH_VALIDATION;
		login.pressSubmit(mode);
		try{
			assertTrue(allUsers.isAllUsersHeaderDisplayed());
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}finally{
			allUsers.clickNewUser();
		}
	}
	
	
	/**
	 * Test case to verify error on creating user by all blank text fields 
	 * @throws IOException , InterruptedException
	 */
	@Test
	public void testCaseID_0014_VerifyCreateUserByAllFieldsBlank() throws InterruptedException, IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());	
		NewUserCreationPageObject.MODE mode = MODE.SUBMIT_BUTTON_WITHOUT_VALIDATION;
		name = "";
		password = "";
		email = "";
		login.createNewUserFromMainPage(name, password, email , password);
		login.pressSubmit(mode);
		try{
			assertTrue(login.isUserNameErrorExists());
			assertTrue(login.isUserEmailErrorExists());
			assertTrue(login.isUserPasswordErrorExists());	
			test.log(LogStatus.PASS, UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}catch(AssertionError e){
			test.log(LogStatus.FAIL,test.addScreenCapture(UtililtyFunctions.capture(driver))+ UtililtyFunctions.getCurrentMethodName());
			Log.endTestCase(UtililtyFunctions.getCurrentMethodName());	
		}finally{
			allUsers.clickNewUser();
	}
	}
	
	
	/**
	 * Test case to verify all the fields to reset on page refresh 
	 * @throws IOException , InterruptedException
	 */
	@Test
	public void testCaseID_0015_VerifyPageRefreshAfterFieldsEntry() throws InterruptedException, IOException{
		Log.startTestCase(UtililtyFunctions.getCurrentMethodName());	
		name = "";
		password = "";
		email = "";
		login.createNewUserFromMainPage(name, password, email, password);
		UtililtyFunctions.refreshPage();
		try{
			assertEquals(login.getNameFieldText(), "");
			assertEquals(login.getEmailFieldText(), "");
			assertEquals(login.getPasswordFieldText(), "");	
			assertEquals(login.getConfirmPasswordFieldText(), "");
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
