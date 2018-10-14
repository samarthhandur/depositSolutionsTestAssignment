
# DepositSolutions Automation Assignment (Selenium-WebDriver + Java)

## Project Structure

```
pom.xml
logfile.log
DepositSolutionsTestReport.html
screenshots
targets
src
└── main
    └── java
        └── com
            └── depositsolutions
                └── utils
                    ├── BaseTest.java : Base class with driver config
                    ├── UtilityFunctions.java : Utlity functions with super driver
                    ├── Log.java : Log class for defining log params
                    ├── Constant.java : class to keep test constants
                ├── pages   
                    └── AllUsersPageObject.java : Class for All Users page 
                    ├── NewUserCreationPageObject.java : Class for creating new users
                    ├── ServicePageObject.java : Class for interacting with REST Services
                    ├── PaymentConfirmationPageObject.java : Class for completing the payment for 
 test
 └──
    main
    └── java
        └── com
            └── depositsolutions
            	└── tests
                    ├── AllUsersPageTest.java : All Users page tests 
                    ├── NewUserCreationEmailFieldTests.java : Test class for email field
                    ├── NewUserCreationNameFieldTests.java : Test class for name field
                    ├── NewUserCreationPasswordFieldTests.java : Test class for password field
                    ├── NewUserCreationGenericTests.java : Test class for generic new user tests
                    ├── TestRunnerClass.java : Main class for running test suite
                    ├── TestSuiteClass.java : Test suite to define the collection of test classes.
                                    
```

Libraries:

- JUnit 4
- selenium-java Client 3.14.0
- webdrivermanager 3.0.0
- extentreports 2.41.2
- log4j 1.2.17
- org.json 20180813



## Requirements

- Chrome browser to be installed (chromeDriver =>2.30)
- Maven 3.0 installed
- Selenium webdriver installed

## Framework
 - Maven build tool, maintaining all the library definition in pom 
 - Page Object Model design pattern for maintaining the separate class for each feature
 - Page Factory Model for defining and locating web elements
 - Logforj logger for defining and logging events
 - Extentreport for effective reporting


## Java
 -java version "1.8.0_112"
 -Java(TM) SE Runtime Environment (build 1.8.0_112-b16)
 -Java HotSpot(TM) 64-Bit Server VM (build 25.112-b16, mixed mode)
 
## Start the tests

Open terminal, browse to root directory of project, run the test suite:

	mvn clean install test -Dtest=TestSuiteClass


## Test Cases

Please find test cases excel sheet at root folder

/TestCasesDepositSolutions.xlsx


## Test Report Location

Please find test report under below path 

/DepositSolutionsTestReport.html

##Test Report screenshot

<img width="1237" alt="screen shot 2018-10-14 at 8 51 24 pm" src="https://user-images.githubusercontent.com/14192186/46919748-5dad8e00-d001-11e8-959a-5c68a0b17a93.png">


## Test Screen Recording

Please find the screen recording of the tests 

/DepositSolutionsTestAssignment.mp4  
 
 ## GoogleDrive link
 
 https://drive.google.com/open?id=1Nd0KfrYltyuvcND2g6Z-vJ0Ar9q_ZKRD


