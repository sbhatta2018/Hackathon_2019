package com.applitools.traditional.approach.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.applitools.traditional.approach.base.BaseClass;
import com.applitools.traditional.approach.webpages.factory.LoginPage;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

/**
 * This class tests login functionality using Data Driven Testing
 */
@RunWith(DataProviderRunner.class)
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
	@DataProvider
	public static Object[][] testData() {
		return new Object[][] { { "", "" }, { "someUserName", "" }, { "", "somePassword" },
				{ "someUserName", "somePassword" } };
	}

	/**
	 * Data Provider test for Login Page
	 * 
	 * @param username
	 * @param password
	 */
	@Test
	@UseDataProvider("testData")
	public void testDataDrivenFunctionality(String username, String password) {
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		if (StringUtils.isEmpty(username) && StringUtils.isEmpty(password)) {
			assertEquals("Empty username /  password error message", true, loginPage.validateEmptyUserNamePassword());
		} else if (StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
			assertEquals("Empty user name error message", true, loginPage.validateErrorUserNameMsg());
		} else if (StringUtils.isEmpty(password) && !StringUtils.isEmpty(username)) {
			assertEquals("Empty password error message", true, loginPage.validateErrorPasswordMsg());
		} else {
			assertEquals("Logged in Successfully", true, loginPage.isPageOpened(getDriver()));
		}
	}
}
