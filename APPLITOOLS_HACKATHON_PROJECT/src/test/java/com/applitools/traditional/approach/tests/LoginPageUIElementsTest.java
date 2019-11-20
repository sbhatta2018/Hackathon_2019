package com.applitools.traditional.approach.tests;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

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
		assertEquals("Logo Present", true, loginPage.isLogoPresentInHomePage());
	}

	/**
	 * Test method to validate to validate Login Form Text presence
	 */
	@Test
	public void validateLoginFormTextPresence() {
		assertEquals("'Login Form' text present", true, loginPage.isLoginFormTextPresent());
	}

	/**
	 * Test method to validate Login Form Text content
	 */
	@Test
	public void validateLoginFormText() {
		assertEquals("Login Form text matched", true, loginPage.isLoginFormTextMatches());
	}

	/**
	 * Test method to validate username label presence
	 */
	@Test
	public void validateUserNameLblPresence() {
		assertEquals("UserName label present", true, loginPage.isUserNameLabelPresent());
	}

	/**
	 * Test method to validate username label contents
	 */
	@Test
	public void validateUserNameLblText() {
		assertEquals("UserName label text matched", true, loginPage.isUserNameLabelMatches());
	}

	/**
	 * Test method to validate password label presence
	 */
	@Test
	public void validatePasswordlblPresence() {
		assertEquals("Password label text present", true, loginPage.isPasswordLabelPresent());
	}

	/**
	 * Test method to validate password label text content
	 */
	@Test
	public void validatePasswordlblText() {
		assertEquals("Password label text matched", true, loginPage.isPasswordLabelMatches());
	}

	/**
	 * Test method to validate username text field presence
	 */
	@Test
	public void validateUserNameTextField() {
		assertEquals("UserName input field present", true, loginPage.isUserNameTextFieldPresent());
	}

	/**
	 * Test method to validate username placehoder text
	 */
	@Test
	public void validateUserNameTextFieldPlaceholder() {
		assertEquals("UserName placeholder text matched", true, loginPage.isUserNameLabelPlaceHolderMatches());
	}

	/**
	 * Test method to validate password input field
	 */
	@Test
	public void validatePasswordTextField() {
		assertEquals("Pasword input field present", true, loginPage.isPasswordTextFieldPresent());
	}

	/**
	 * Test method to validate password field placeholder text
	 */
	@Test
	public void validatePasswordTextFieldPlaceholder() {
		assertEquals("Password field placeholder text matched", true, loginPage.isPasswordLabelPlaceHolderMatches());
	}

	/**
	 * Test method to validate user icon presence
	 */
	@Test
	public void validateUserIconPresence() {
		assertEquals("Login icon present", true, loginPage.isUserNameIconPresent());
	}

	/**
	 * Test method to validate password icon presence
	 */
	@Test
	public void validatePasswordIconPresence() {
		assertEquals("Password icon present", true, loginPage.isPasswordIconPresent());
	}

	/**
	 * Test method to validate Login button presence
	 */
	@Test
	public void validateLoginBtnPresence() {
		assertEquals("Login button present", true, loginPage.isLoginButtonPresent());
	}

	/**
	 * Test method to verify Login button text
	 */
	@Test
	public void validateLoginButtonText() {
		assertEquals("Login button text matched", true, loginPage.isLoginBtnTextMatches());
	}

	/**
	 * Test method to validate checkbox presence
	 */
	@Test
	public void validateCheckBoxPresence() {
		assertEquals("Remember Me checkBox present", true, loginPage.isRememberMeCheckBoxPresent());
	}

	/**
	 * Test method to validate checkbox text
	 */
	@Test
	public void validateCheckBoxText() {
		assertEquals("Remember Me checkBox text matched", true, loginPage.isRememberMeTextMatches());

	}
}
