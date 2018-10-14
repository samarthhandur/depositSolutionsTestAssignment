package com.depositsolutions.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.depositsolutions.utils.BaseTest;
import com.depositsolutions.utils.Log;
import com.depositsolutions.utils.UtililtyFunctions;

/**
 * Page object class for All users page
 */
public class AllUsersPageObject extends BaseTest{

	/**
     *  Constructor to assign driver of type WebDriver
     */
	public AllUsersPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	    }
	
	/**
     * Explicit wait of 10 secs
     */
		WebDriverWait wait = new WebDriverWait(driver, 10);
	
	/**
     * Creating util Object of class UtililtyFunctions
     */
	UtililtyFunctions util = new UtililtyFunctions(driver);
	
	
	/**
     *  All User page heading
     */
	private static final String ALL_USERS_PAGE_HEADER = "(.//*[normalize-space(text()) and normalize-space(.)='Name'])[1]/preceding::h1[1]";
	
	/**
     *  All Users table locator
     */
	private static final String ALL_USERS_TABLE_LOCATOR = "//*[@id=\"users\"]/tbody/tr";
	
	/**
     *  New User button 
     */
	private static final String NEW_USERS_BUTTON = "New User";
	
	/**
     *  Page Factory for element locations
     */
	
	@FindBy(xpath = ALL_USERS_PAGE_HEADER)
	private WebElement allUsersPageHeader;
	
	@FindBy(linkText = NEW_USERS_BUTTON)
	private WebElement newUserButton;
	
	@FindBy(xpath = ALL_USERS_TABLE_LOCATOR)
	private List<WebElement> allUserTable;
	
	/**
	 *  Method to check presence of All Users Header
     *  @return boolean 
     */
	public boolean isAllUsersHeaderDisplayed(){
		return UtililtyFunctions.isElementExists(allUsersPageHeader);
	}
	
	/**
	 *  Method to check presence of New Users Button
     *  @return boolean 
     */
	public boolean isNewUsersButtonDisplayed(){
		return UtililtyFunctions.isElementExists(newUserButton);
	}
	
	/**
	 *  Method to get user table size
     *  @return int size of array 
     */
	public int userTableSize(){
		return allUserTable.size();
	}
	
	/**
	 *  Method to get table row from user table
	 *  @param index
     *  @return String  
     */
	public String getElementTextFromUserTable(int index){
		return allUserTable.get(index).getText();
	}
	
	/**
	 *  Method to click New User button
     */
	public void clickNewUser(){
		try{
			newUserButton.click();
		}catch(NoSuchElementException e){
			Log.error("newUserButton element not found");
		}
	}
}
