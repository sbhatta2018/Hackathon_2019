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


public class DynamicContentPage {
	// Page URL
	private static String PAGE_URL = System.getProperty("DYNAMIC_URL");

	// Constructor
	public DynamicContentPage(WebDriver driver) {
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

	// Username text field
	@FindBy(id = "username")
	private WebElement userNameTextField;

	// Password text field
	@FindBy(id = "password")
	private WebElement passwordTextField;
	// Login Button Id
	@FindBy(id = "log-in")
	private WebElement logInBtn;

	// Flash sell add 1
	@FindBy(id = "flashSale")
	private List<WebElement> flashSale1;

	// Flash sell add 2
	@FindBy(id = "flashSale2")
	private List<WebElement> flashSale2;

	// Enter username
	public void enterUserName(String userName) {
		userNameTextField.clear();
		userNameTextField.sendKeys(userName);
	}

	// Enter password
	public void enterPassword(String password) {
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
	}

	// Click on LoginIn button
	public void clickOnLoginButton() {
		logInBtn.click();
	}

	public boolean isFlashSaleFirstExists() {
		return flashSale1.size() == 1;
	}

	public boolean isFlashSaleSecondExists() {
		return flashSale2.size() == 1;
	}
}
