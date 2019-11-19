package com.applitools.traditional.approach.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.applitools.traditional.approach.base.BaseClass;
import com.applitools.traditional.approach.webpages.factory.LoginPage;

/**
 * This class contains test method for testing Login Page UI elements
 */
public class LoginPageUIElementsTest extends BaseClass {
	static LoginPage loginPage;

	/**
	 * Before class to create Page Factory Object
	 * 
	 * @throws InterruptedException
	 */
	@BeforeClass
	public static void setup() {
		loginPage = new LoginPage(getDriver());
	}

	/**
	 * Test method to validate Logo Presence
	 */
	@Test
	public void validateLogoPresence() {
		assertEquals(loginPage.isLogoPresentInHomePage(), true, "Logo Present");
	}

	/**
	 * Test method to validate to validate Login Form Text presence
	 */
	@Test
	public void validateLoginFormTextPresence() {
		assertEquals(loginPage.isLoginFormTextPresent(), true, "'Login Form' text present");
	}

	/**
	 * Test method to validate Login Form Text content
	 */
	@Test
	public void validateLoginFormText() {
		assertEquals(loginPage.isLoginFormTextMatches(), true, "Login Form text matched");
	}

	/**
	 * Test method to validate username label presence
	 */
	@Test
	public void validateUserNameLblPresence() {
		assertEquals(loginPage.isUserNameLabelPresent(), true, "UserName label present");
	}

	/**
	 * Test method to validate username label contents
	 */
	@Test
	public void validateUserNameLblText() {
		assertEquals(loginPage.isUserNameLabelMatches(), true, "UserName label text matched");
	}

	/**
	 * Test method to validate password label presence
	 */
	@Test
	public void validatePasswordlblPresence() {
		assertEquals(loginPage.isPasswordLabelPresent(), true, "Password label text present");
	}

	/**
	 * Test method to validate password label text content
	 */
	@Test
	public void validatePasswordlblText() {
		assertEquals(loginPage.isPasswordLabelMatches(), true, "Password label text matched");
	}

	/**
	 * Test method to validate username text field presence
	 */
	@Test
	public void validateUserNameTextField() {
		assertEquals(loginPage.isUserNameTextFieldPresent(), true, "UserName input field present");
	}

	/**
	 * Test method to validate username placehoder text
	 */
	@Test
	public void validateUserNameTextFieldPlaceholder() {
		assertEquals(loginPage.isUserNameLabelPlaceHolderMatches(), true, "UserName placeholder text matched");
	}

	/**
	 * Test method to validate password input field
	 */
	@Test
	public void validatePasswordTextField() {
		assertEquals(loginPage.isPasswordTextFieldPresent(), true, "Pasword input field present");
	}

	/**
	 * Test method to validate password field placeholder text
	 */
	@Test
	public void validatePasswordTextFieldPlaceholder() {
		assertEquals(loginPage.isPasswordLabelPlaceHolderMatches(), true, "Password field placeholder text matched");
	}

	/**
	 * Test method to validate user icon presence
	 */
	@Test
	public void validateUserIconPresence() {
		assertEquals(loginPage.isUserNameIconPresent(), true, "Login icon present");
	}

	/**
	 * Test method to validate password icon presence
	 */
	@Test
	public void validatePasswordIconPresence() {
		assertEquals(loginPage.isPasswordIconPresent(), true, "Password icon present");
	}

	/**
	 * Test method to validate Login button presence
	 */
	@Test
	public void validateLoginBtnPresence() {
		assertEquals(loginPage.isLoginButtonPresent(), true, "Login button present");
	}

	/**
	 * Test method to verify Login button text
	 */
	@Test
	public void validateLoginButtonText() {
		assertEquals(loginPage.isLoginBtnTextMatches(), true, "Login button text matched");
	}

	/**
	 * Test method to validate checkbox presence
	 */
	@Test
	public void validateCheckBoxPresence() {
		assertEquals(loginPage.isRememberMeCheckBoxPresent(), true, "Remember Me checkBox present");
	}

	/**
	 * Test method to validate checkbox text
	 */
	@Test
	public void validateCheckBoxText() {
		assertEquals(loginPage.isRememberMeTextMatches(), true, "Remember Me checkBox text matched");

	}
}
