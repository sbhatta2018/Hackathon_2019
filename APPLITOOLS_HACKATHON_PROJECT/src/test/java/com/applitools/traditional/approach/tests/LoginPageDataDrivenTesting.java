package com.applitools.traditional.approach.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;
import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

import com.applitools.traditional.approach.base.BaseClass;
import com.applitools.traditional.approach.webpages.factory.LoginPage;

/**
 * This class tests login functionality using Data Driven Testing
 */
public class LoginPageDataDrivenTesting extends BaseClass {
	static LoginPage loginPage;

	/**
	 * Before class to create Page Factory Object
	 * 
	 * @throws InterruptedException
	 */
	@BeforeClass
	public static void setup() throws InterruptedException {
		loginPage = new LoginPage(getDriver());
	}

	/**
	 * Data Provider to provide data to Test method
	 * 
	 * @return
	 * @throws IOException
	 */
	@DataProvider(name = "Authentication")
	public static Object[][] getCredentials() throws IOException {
		File dataFile = new File(
				System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "data.xls");
		Workbook workbook;
		Sheet sheet = null;
		int numRow = 0;
		try {
			workbook = Workbook.getWorkbook(dataFile);
			sheet = workbook.getSheet(0);
			numRow = sheet.getRows();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Create 2 D array and pass row and columns
		Object[][] data = new Object[numRow][sheet.getColumns()];
		// This will run a loop and each iteration it will fetch new row
		for (int i = 0; i < numRow; i++) {
			// Fetch first row username
			data[i][0] = sheet.getCell(0, i).getContents();
			// Fetch first row password
			data[i][1] = sheet.getCell(1, i).getContents();
		}
		// Return 2d array object so that test script can use the same
		return data;
	}

	/**
	 * Data Provider test for Login Page
	 * 
	 * @param username
	 * @param password
	 */
	@Test(dataProvider = "Authentication")
	public void testDataDrivenFunctionality(String username, String password) {
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		if (StringUtils.isEmpty(username) && StringUtils.isEmpty(password)) {
			assertEquals(loginPage.validateEmptyUserNamePassword(), true, "Empty username /  password error message");
		} else if (StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
			assertEquals(loginPage.validateErrorUserNameMsg(), true, "Empty user name error message");
		} else if (StringUtils.isEmpty(password) && !StringUtils.isEmpty(username)) {
			assertEquals(loginPage.validateErrorPasswordMsg(), true, "Empty password error message");
		} else {
			assertEquals(loginPage.isPageOpened(getDriver()), true, "Logged in Successfully");
		}
	}
}
