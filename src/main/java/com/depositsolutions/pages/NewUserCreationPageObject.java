package com.depositsolutions.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.depositsolutions.utils.BaseTest;
import com.depositsolutions.utils.Constants;
import com.depositsolutions.utils.UtililtyFunctions;


/**
 * A page for a creating new user 
 */
public class NewUserCreationPageObject extends BaseTest{
	
	/**
     *  Constructor to assign driver of type WebDriver
     */
	public NewUserCreationPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	    }
	
	/**
     * Explicit wait of 10 secs
     */
		WebDriverWait wait = new WebDriverWait(driver, 10);
	
	/**
     * Creating util Object of class Utils
     */
	UtililtyFunctions util = new UtililtyFunctions(driver);
	
	
	/**
     * Creating allUsers Object of class AllUsersPageTest
     */
	AllUsersPageObject allUsers = new AllUsersPageObject(driver);
	
	/**
     * Username text edit area from the landing page
     */
	private static final String USER_NAME_TEXT_AREA = "name";

	/**
     *  Email text edit area from the landing page
     */
	private static final String EMAIL_TEXT_AREA = "email";
	
	/**
     *  Email text edit area from the landing page
     */
	private static final String PASSWORD_TEXT_AREA = "password";
	
	/**
     *  Email text edit area from the landing page
     */
	private static final String CONFIRMATION_PASSWORD_TEXT_AREA = "confirmationPassword";
	
	/**
     * Login button from the landing page
     */
	private static final String SUBMIT_BUTTON = "(.//*[normalize-space(text()) and normalize-space(.)='All User'])[1]/following::button[1]";
	
	/**
     *  All Users button from the landing page
     */
	private static final String ALL_USERS_BUTTON = "All User";
	
	/**
     *  New User page heading
     */
	private static final String NEW_USER_PAGE_HEADING = "(.//*[normalize-space(text()) and normalize-space(.)='New User'])[2]/following::label[1]";

	/**
     *  New User page heading
     */
	private static final String NAME_LABEL = "(.//*[normalize-space(text()) and normalize-space(.)='Name:'])[1]/following::label[1]";

	/**
     *  New User page heading
     */
	private static final String EMAIL_LABEL = "(.//*[normalize-space(text()) and normalize-space(.)='Email:'])[1]/following::label[1]";

	/**
     *  New User page heading
     */
	private static final String PASSWORD_LABEL = "(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::label[1]";

	/**
     *  New User page heading
     */
	private static final String CONFIRM_PASSWORD_LABEL = "/html/body/div/div/div/form/fieldset/div[4]/label";

	/**
     *   User name error element
     */
	private static final String USER_NAME_ERROR = "user.name.error";
	
	
	/**
     *   User email error element
     */
	private static final String USER_EMAIL_ERROR = "user.email.error";
	
	/**
     *   User password error element
     */
	private static final String USER_PASSWORD_ERROR = "user.password.error";
	
	/**
     *   User confirmation password error element
     */
	private static final String USER_CONF_PASSWORD_ERROR = "user.confirmationPassword.error";
	
	
	/**
     *   Declaring ENUMs for various kinds of submit operations
     */
	public static enum MODE{
		   SUBMIT_BUTTON_WITH_VALIDATION, ENTER_KEY_WITH_VALIDATION, SUBMIT_BUTTON_WITHOUT_VALIDATION;
		}
	/**
     * PageFactory element assignments  
     */
	@FindBy(id = USER_NAME_TEXT_AREA)
	private WebElement user_name_field;
	
	@FindBy(id = EMAIL_TEXT_AREA)
	private WebElement email_field;
	
	@FindBy(id = PASSWORD_TEXT_AREA)
	private WebElement password_field;
	
	@FindBy(id = CONFIRMATION_PASSWORD_TEXT_AREA)
	private WebElement confirmationPassword_field;
	
	@FindBy(xpath = SUBMIT_BUTTON)
	private WebElement submitButton;
	
	@FindBy(linkText = ALL_USERS_BUTTON)
	private WebElement allUsersButton;
	
	@FindBy(xpath = NEW_USER_PAGE_HEADING)
	private WebElement pageHeader;
	
	@FindBy(xpath = NAME_LABEL)
	private WebElement nameLabel;
	
	@FindBy(xpath = PASSWORD_LABEL)
	private WebElement passwordLabel;
	
	@FindBy(xpath = EMAIL_LABEL)
	private WebElement emailLabel;
	
	@FindBy(xpath = CONFIRM_PASSWORD_LABEL)
	private WebElement cnfPasswordLabel;
	
	@FindBy(id = USER_NAME_ERROR)
	private WebElement userNameError;
	
	@FindBy(id = USER_EMAIL_ERROR)
	private WebElement userEmailError;
	
	@FindBy(id = USER_PASSWORD_ERROR)
	private WebElement userPwdError;
	
	@FindBy(id = USER_CONF_PASSWORD_ERROR)
	private WebElement userConfPwdError;
	
	public String getNameFieldText(){
		return user_name_field.getText();
	}
	
	/**
     *   Method to get the text of email field
     *   @return String
     */
	public String getEmailFieldText(){
		return email_field.getText();
	}
	
	/**
     *   Method to get the text of password field
     *   @return String
     */
	public String getPasswordFieldText(){
		return password_field.getText();
	}
	
	/**
     *   Method to get the text of confirm password field
     *   @return String
     */
	public String getConfirmPasswordFieldText(){
		return confirmationPassword_field.getText();
	}
	
	/**
     *   Method to check if page header is displayed
     *   @return boolean
     */
	public boolean isHeaderDisplayed(){
		return UtililtyFunctions.isElementExists(pageHeader);
	}
	
	/**
     *   Method to check if Name label is displayed
     *   @return boolean
     */
	public boolean isNameLabelDisplayed(){
		return UtililtyFunctions.isElementExists(nameLabel);
	}
	
	/**
     *   Method to check if email label is displayed
     *   @return boolean
     */
	public boolean isEmailLabelDisplayed(){
		return UtililtyFunctions.isElementExists(emailLabel);
	}
	
	/**
     *   Method to check if password label is displayed
     *   @return boolean
     */
	public boolean isPasswordLabelDisplayed(){
		return UtililtyFunctions.isElementExists(passwordLabel);
	}
	
	/**
     *   Method to check if confirm password is displayed
     *   @return boolean
     */
	public boolean isConfirmPasswordDisplayed(){
		return UtililtyFunctions.isElementExists(cnfPasswordLabel);
	}
	
	
	/**
     *   Method to check if All users button is displayed
     *   @return boolean
     */
	public boolean isAllUsersButtonDisplayed(){
		return UtililtyFunctions.isElementExists(allUsersButton);
	}
	
	
	/**
     *   Method to check if Submit button is displayed
     *   @return boolean
     */
	public boolean isSubmitButtonDisplayed(){
		return UtililtyFunctions.isElementExists(submitButton);
	}
	
	
	/**
     *   Method to get field name placeholder text
     *   @return String
     */
	public String getNameFieldPlaceholderText(){
		return UtililtyFunctions.getPlaceholderAttributeValue(user_name_field);
	}
	
	
	/**
     *   Method to get field email placeholder text
     *   @return String
     */
	public String getEmailFieldPlaceholderText(){
		return UtililtyFunctions.getPlaceholderAttributeValue(email_field);
	}
	
	
	/**
     *   Method to get field password placeholder text
     *   @return String
     */
	public String getPasswordFieldPlaceholderText(){
		return UtililtyFunctions.getPlaceholderAttributeValue(password_field);
	}
	
	
	/**
     *   Method to get field confirm password placeholder text
     *   @return String
     */
	public String getConfirmPasswordFieldPlaceholderText(){
		return UtililtyFunctions.getPlaceholderAttributeValue(confirmationPassword_field);
	}
	
	/**
     *   Method to check if name error displayed
     *   @return boolean
     */
	public boolean isUserNameErrorExists(){
		return UtililtyFunctions.isElementExists(userNameError);
	}
	
	/**
     *   Method to check if email error displayed
     *   @return boolean
     */
	public boolean isUserEmailErrorExists(){
		return UtililtyFunctions.isElementExists(userEmailError);
	}
	
	/**
     *   Method to check if password error displayed
     *   @return boolean
     */
	public boolean isUserPasswordErrorExists(){
		return UtililtyFunctions.isElementExists(userPwdError);
	}
	
	
	/**
     *   Method to check if confirm password error displayed
     *   @return boolean
     */
	public boolean isUserConfirmPasswordErrorExists(){
		return UtililtyFunctions.isElementExists(userConfPwdError);
	}
	
	
	/**
     *   Method to click All User button
     */
	public void clickAllUsersButton(){
		try{
			allUsersButton.click();
		}catch(NoSuchElementException e){
			System.out.println("Element not present");
		}
}
	/**
     * Method to enter login credentials 
     */
	public void createNewUserFromMainPage(String user, String pwd, String email, String cnf_pwd) {
		try
		{
			user_name_field.clear();
			user_name_field.sendKeys(user);
			email_field.clear();
			email_field.sendKeys(email);
			password_field.clear();
			password_field.sendKeys(pwd);
			confirmationPassword_field.clear();
			confirmationPassword_field.sendKeys(cnf_pwd);
		}catch(NoSuchElementException e)
			{
			System.out.println("Element Not found");
		}
	}
	
	/**
     * Method to Submit the New user request based on the ENUM passed
     * @param enum MODE 
     */
	public void pressSubmit(MODE currentMode) throws InterruptedException{
		System.out.println(currentMode.toString());
		switch(currentMode){
			case SUBMIT_BUTTON_WITH_VALIDATION:
				wait.until(ExpectedConditions.elementToBeClickable(submitButton));
				submitButton.click();
				wait.until(ExpectedConditions.urlToBe(Constants.ALL_USERS));
				break;
			case ENTER_KEY_WITH_VALIDATION:
				submitButton.sendKeys(Keys.ENTER);
				wait.until(ExpectedConditions.urlToBe(Constants.ALL_USERS));
				break;
			case SUBMIT_BUTTON_WITHOUT_VALIDATION:
				wait.until(ExpectedConditions.elementToBeClickable(submitButton));
				submitButton.click();
				break; 
		}
	}
}
