package com.depositsolutions.utils;

/**
 * Constant class for all the test constants
 */
public class Constants {

	 /**
     * Test URL definition
     */
	public static final String URL = "http://85.93.17.135:9000/user/new";

	 /**
     * Get ALL USERS API URL definition
     */
	public static final String GET_USERS = "http://85.93.17.135:9000/user/all/json";
	
	 /**
     * Delete ALL USERS API URL definition
     */
	public static final String DELETE_USERS = "http://85.93.17.135:9000/user/all";
	
	/**
     *  ALL USERS URL definition
     */
	public static final String ALL_USERS = "http://85.93.17.135:9000/users/all";
	 /**
     * Root folder path for the excel data file
     */
    public static final String PATH_ROOT = System.getProperty("user.dir");

    /**
     * Name of the test data file
     */
    public static final String FILE_TEST_DATA = "/TestData.xlsx";
    
    /**
     * Test Report file
     */
    public static final String TEST_REPORT_FILE = "/DepositSolutionsTestReport.html";
    
    /**
     * Test Screenshots folder location
     */
    public static final String TEST_SCREENSHOTS = "screenshots/";
    
    /**
     * Test logs location
     */
    public static final String TEST_LOGS = "/logfile.log";
}

