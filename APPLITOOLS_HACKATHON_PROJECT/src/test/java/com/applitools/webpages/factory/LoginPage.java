package com.applitools.webpages.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	// Page URL
	private static String PAGE_URL = System.getProperty("APP_URL");

	// Constructor
	public LoginPage(WebDriver driver) {
		Properties prop = new Properties();
		try {
			InputStream environmentFile = new FileInputStream(
					System.getProperty("user.dir") + File.separator + "environment.properties");
			prop.load(environmentFile);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		driver.get(prop.getProperty(PAGE_URL));
		PageFactory.initElements(driver, this);
	}

	// Logo
	@FindBy(className = "logo-w")
	private List<WebElement> logo;

	// Login Form Heading
	@FindBy(className = "auth-header")
	private List<WebElement> loginFormHeading;

	// Username Label
	@FindBy(xpath = "/html/body/div/div/form/div[1]/label")
	private List<WebElement> userNameLabel;

	// Password Label
	@FindBy(xpath = "/html/body/div/div/form/div[2]/label")
	private List<WebElement> passwordLabel;

	// Username text field
	@FindBy(id = "username")
	private List<WebElement> userNameTextField;

	// Password text field
	@FindBy(id = "password")
	private List<WebElement> passwordTextField;

	// Username Icon
	@FindBy(xpath = "/html/body/div/div/form/div[1]/div")
	private List<WebElement> userNameIcon;

	// Password Icon
	@FindBy(xpath = "/html/body/div/div/form/div[2]/div")
	private List<WebElement> passwordIcon;

	// Login Button Id
	@FindBy(id = "log-in")
	private List<WebElement> logInBtn;

	// Remember Me checkbox
	@FindBy(xpath = "/html/body/div/div/form/div[3]/div[1]/label")
	private List<WebElement> rememberMeCheckBox;

	// Username / Password error message
	@FindBy(xpath = "/html/body/div/div/div[3]")
	private WebElement errorMessage;

	// Compare Page Logo Heading
	@FindBy(className = "logo-label")
	private WebElement expenseChartLogo;
	
	//Credit Card Text
	@FindBy(xpath = "/html/body/div/div[3]/div[1]/ul/li[2]/a/span")
	private WebElement creditCards;

	// Verify if logo image present
	public boolean isLogoPresentInHomePage() {
		return logo.size() == 1;
	}

	// Verify Login Form Text Presence
	public boolean isLoginFormTextPresent() {
		return loginFormHeading.size() == 1;
	}

	// Verify Login Form Text
	public boolean isLoginFormTextMatches() {
		return loginFormHeading.get(0).getText().toString().equals("Login Form");
	}

	// Verify Username Label Text Presence
	public boolean isUserNameLabelPresent() {
		return userNameLabel.size() == 1;
	}

	// Verify Username Label Text
	public boolean isUserNameLabelMatches() {
		return userNameLabel.get(0).getText().toString().equals("Username");
	}

	// Verify Password Label Text Presence
	public boolean isPasswordLabelPresent() {
		return passwordLabel.size() == 1;
	}

	// Verify Password Label Text
	public boolean isPasswordLabelMatches() {
		return passwordLabel.get(0).getText().toString().equals("Password");
	}

	// Verify Username text field present
	public boolean isUserNameTextFieldPresent() {
		return userNameTextField.size() == 1;
	}

	// Verify Username label placeholder text
	public boolean isUserNameLabelPlaceHolderMatches() {
		return userNameTextField.get(0).getAttribute("placeholder").toString().equals("Enter your username");
	}

	// Verify Password text field presence
	public boolean isPasswordTextFieldPresent() {
		return passwordTextField.size() == 1;
	}

	// Verify Password label placeholder text
	public boolean isPasswordLabelPlaceHolderMatches() {
		return passwordTextField.get(0).getAttribute("placeholder").toString().equals("Enter your password");
	}

	// Verify Username Icon Presence
	public boolean isUserNameIconPresent() {
		return userNameIcon.size() == 1;
	}

	// Verify Password Icon Presence
	public boolean isPasswordIconPresent() {
		return passwordIcon.size() == 1;
	}

	// Verify Login Button Present
	public boolean isLoginButtonPresent() {
		return logInBtn.size() == 1;
	}

	// Verify Login button Text
	public boolean isLoginBtnTextMatches() {
		return logInBtn.get(0).getText().toString().equals("Log In");
	}

	// Verify Remember Me Checkbox Presence
	public boolean isRememberMeCheckBoxPresent() {
		return rememberMeCheckBox.size() == 1;
	}

	// Verify Remember Me Checkbox Text
	public boolean isRememberMeTextMatches() {
		return rememberMeCheckBox.get(0).getText().toString().equals("Remember Me");
	}

	// Enter username
	public void enterUserName(String userName) {
		userNameTextField.get(0).clear();
		userNameTextField.get(0).sendKeys(userName);
	}

	// Enter password
	public void enterPassword(String password) {
		passwordTextField.get(0).clear();
		passwordTextField.get(0).sendKeys(password);
	}

	// Validate error username message
	public boolean validateErrorUserNameMsg() {
		return errorMessage.getText().toString().equals("Username must be present");
	}

	// Validate error password message
	public boolean validateErrorPasswordMsg() {
		return errorMessage.getText().toString().equals("Password must be present");
	}

	// Validate if both username and password are empty
	public boolean validateEmptyUserNamePassword() {
		return errorMessage.getText().toString().equals("Both Username and Password must be present");
	}

	// Click on LoginIn button
	public void clickOnLoginButton() {
		logInBtn.get(0).click();
	}

	// Verify if page opened
	public boolean isPageOpened(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(expenseChartLogo));
		return creditCards.getText().toString().equals("Credit cards");
	}
}
