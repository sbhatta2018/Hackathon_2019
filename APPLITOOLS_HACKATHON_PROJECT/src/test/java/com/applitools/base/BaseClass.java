package com.applitools.base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Base Class to get and close web driver object
 */
public class BaseClass {
	static WebDriver driver = null;

	/**
	 * This method returns web driver object
	 * 
	 * @return
	 */
	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator
					+ "Chrome_Driver" + File.separator + "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		return driver;
	}

	/**
	 * This method closes browser
	 */
	public static void closeBrowserWindow() {
		if (driver != null) {
			driver.close();
		}
	}
}
