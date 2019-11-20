package com.applitools.visual.ai.approach.tests;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;

/**
 * Runs Applitools test for the hackathon app
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(DataProviderRunner.class)
public class VisualAITests extends VisualBaseClass {

	private static EyesRunner runner = getClassicRunner();
	private static Eyes eyes = getEyes();
	private static WebDriver driver = getDriver();
	private static TestResultsSummary allTestResults;
	private static Properties prop;
	// Page URL's
	private static String PAGE_URL = System.getProperty("APP_URL");
	private static String DYNAMIC_URL = System.getProperty("DYNAMIC_URL");


	@BeforeClass
	public static void setUp() {

		prop = new Properties();
		try {
			InputStream environmentFile = new FileInputStream(
					System.getProperty("user.dir") + File.separator + "visual_environment.properties");
			prop.load(environmentFile);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		driver.get(prop.getProperty(PAGE_URL));		
		
	}

	// Login page UI Elements test
	@Test
	public void test1_LoginPagUIElemenetsTest() {

		// Start the test
		eyes.open(driver, "Hackathon App", "Login Page UI Elements Test", new RectangleSize(1300, 580));

		// Take a screenshot capturing the login page elements.
		eyes.checkWindow("Login page UI elements");

		// End the test.
		eyes.closeAsync();

	}

	// Data Driven Login Functionality Test
	@Test
	@UseDataProvider("testData")
	public void test2_DataDrivenTest(String username, String password, String expected, String testName) {

		login(username, password, testName);

		if ((StringUtils.isEmpty(username)) || (StringUtils.isEmpty(password))) {

			String actual = driver.findElement(By.xpath("/html/body/div/div/div[3]")).getText();
			assertEquals(testName, expected, actual);

		} else {
			String loggedUserName = driver.findElement(By.id("logged-user-name")).getText();
			assertEquals(testName, expected, loggedUserName);
		}
	}

	// Table Sort Test
	@Test
	public void test3_TableSortTest() {

		// Start the test
		eyes.open(driver, "Hackathon App", "Table Sort Test", new RectangleSize(1300, 580));

		// Full page screenshot
		eyes.setForceFullPageScreenshot(true);

		// Take screenshot of the table before sorting
		eyes.checkWindow(" Table data before sorting ");

		// Click on the AMOUNT header of the "Recent Transactions" table
		driver.findElement(By.id("amount")).click();

		// Take screenshot of the table after sorting
		eyes.checkWindow(" Table data after sorting ");

		// End the test
		eyes.closeAsync();
	}

	// Canvas Chart Test
	@Test
	public void test4_CanvasChartTest() {

		// Start the test
		eyes.open(driver, "Hackathon App", "Canvas Chart Test", new RectangleSize(1300, 580));

		// Full page screenshot
		eyes.setForceFullPageScreenshot(true);

		// Click on the Compare Expenses link
		driver.findElement(By.id("showExpensesChart")).click();

		// Take screenshot of data for the years 2017 and 2018
		eyes.checkWindow("Data for the years 2017 and 2018");

		// Click on the "Show data for next year" button
		driver.findElement(By.id("addDataset")).click();

		// Take screenshot of data for the years 2017, 2018 and 2019
		eyes.checkWindow("Data for the years 2017, 2018 and 2019");

		// End the test
		eyes.closeAsync();
	}

	// Dynamic Content Test
	@Test
	public void test5_DynamicContentTest() {

		// Set Layout Mode
		eyes.setMatchLevel(MatchLevel.LAYOUT2);

		// Start the test
		eyes.open(driver, "Hackathon App", "Dynamic Content Test", new RectangleSize(1300, 580));

		// Open the dynamic content URL
		driver.get(prop.getProperty(DYNAMIC_URL));		

		// Login to the application
		validLogin();
		
		// Timeout so that all the gifs are loaded 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Take screenshot of both the gifs
		eyes.checkWindow("For both flash sale gifs");

		// End the test
		eyes.closeAsync();
	}

	@DataProvider
	public static Object[][] testData() {
		return new Object[][] {
				{ "", "", "Both Username and Password must be present",
						"Login test - Both username and password fields empty" },
				{ "someUserName", "", "Password must be present", "Login test - Password is empty" },
				{ "", "somePassword", "Username must be present", "Login test - Username is empty" },
				{ "someUserName", "somePassword", "Jack Gomez", "Login test - Success" } };

	}

	public void login(String username, String password, String testName) {
		eyes.open(driver, "Hackathon App", testName, new RectangleSize(1300, 580));
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("log-in")).click();
		eyes.check(testName, Target.window().ignoreDisplacements());
		eyes.closeAsync();

	}

	// Login with valid login credentials
	public void validLogin() {

		// Enter the username
		driver.findElement(By.id("username")).sendKeys("someUserName");

		// Enter only the password
		driver.findElement(By.id("password")).sendKeys("somePassword");

		// Click on the login button
		driver.findElement(By.id("log-in")).click();
	}

	@AfterClass
	public static void tearDown() {

		// Close browser and eye
		closeBrowserWindowAndEyes();

		// Wait and collect all test results
		allTestResults = runner.getAllTestResults(); 

		// Print results
		System.out.println(allTestResults);

	}

}
