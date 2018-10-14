package com.depositsolutions.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Class for setting up the excel file for data driven approach
 */
public class UtililtyFunctions extends BaseTest{
	@SuppressWarnings("rawtypes")
	
	/**
	 * Defining ExcelWorksheet 
	 */
	private static XSSFSheet ExcelWSheet;
	 
	/**
	 * Defining ExcelWorkbook 
	 */
	private static XSSFWorkbook ExcelWBook;

	/**
	 * Defining ExcelWorksheet cell 
	 */
	private static XSSFCell Cell;

	/**
	 * Defining ExcelWorksheet row
	 */
	private static XSSFRow Row;
	
	private static MissingCellPolicy xRow;
	
	/**
	 * Constructor to initialize Utils class
	 * @param WebDriver driver 
	 */
	public UtililtyFunctions(WebDriver driver) {
		PageFactory.initElements(driver, this);
	    }
		
	/**
	 * Instance method to scroll into the web page
	 * @param WebElement 
	 */
	public void scrollTillElement(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);" , element);
	}

	/**
	 * Initializing the excel file 
	 * @param Path, SheetName
	 */
	public static void setExcelFile(String Path,String SheetName) throws Exception {
		 
			try {

   			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			} catch (Exception e){

				throw (e);

			}

	}

	/**
	 * This method is to read the test data from the Excel cell
	 * @param rownNum, ColNum 
	 */
    public static String getCellData(int RowNum, int ColNum) throws Exception{
    	DataFormatter formatter = new DataFormatter();
			try{
			
  			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
  			
  			String CellData = formatter.formatCellValue(Cell);
  			return CellData;

  			}catch (Exception e){
  				System.out.println(e);
				return"";
  			}
    }

     /**
	 * This method is to write the test data to the Excel cell
	 * @param rownNum, ColNum 
	 */
	@SuppressWarnings("static-access")
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception	{
			try{

  			Row  = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, xRow.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

				} else {

					Cell.setCellValue(Result);

				}

  // Constant variables Test Data path and Test Data file name

  				FileOutputStream fileOut = new FileOutputStream(Constants.PATH_ROOT + Constants.FILE_TEST_DATA);

  				ExcelWBook.write(fileOut);

  				fileOut.flush();

					fileOut.close();

				}catch(Exception e){

					throw (e);
			}
		}
	
	 /**
    * This method will check if an element exists on the page
    * @param WebElement 
    * @return boolean
	*/
	public static boolean isElementExists(WebElement ele){
		try{
			ele.isDisplayed();
			return true;
		}catch(Exception e){
			return false;
		}
	}

	 /**
	* This method will get the placeholder attribute value of an element
    * @param WebElement 
    * @return String
	*/
	public static String getPlaceholderAttributeValue(WebElement ele){
		System.out.println(ele.getAttribute("placeholder"));
		return ele.getAttribute("placeholder");
	}
	
	 /**
    * This method will refresh the page 
	*/
	public static void refreshPage(){
		driver.navigate().refresh();
	}
	
	
	/**
	 * @Purpose This method will generate a random integer
	 * @param length --> the length of the random emails we want to generate
	 * @return method will return a random email String
	 */
	public static String generateRandomCredentials(int length, boolean str) {
	    String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-*#$%^&*";
	    String email = "";
	    String temp = RandomStringUtils.random(length, allowedChars);
	    
	    /**
		 * if str is true, Generate a string without @testData.com., for name and password
		 */
	    if(str){
	    	 Log.info("Generating a Random String");
	    	return temp.substring(0, temp.length() - 9);
	    }
	    
	    /**
		 * if str is false, Generate a string with @testData.com., for email
		 */
	    else if(!str){
	    	 Log.info("Generating a Random email String");
	    	 email = temp.substring(0, temp.length() - 9) + "@testdata.com";
	 	    return email;
	    }
		return null;
	   
	}
	
	/**
	 * Capture screenshot and save in screenshots folder
	 * @return screenshot file path
	 */
	public static String capture(WebDriver driver) throws IOException {
		//source file location
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//Destination file location
		File Dest = new File(Constants.TEST_SCREENSHOTS + System.currentTimeMillis()
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		
		//Move file from source to destination 
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}
	
	/**
	 * Get the name of currently executed function
	 * @return String 
	 */
	public static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getClassName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}

