package com.applitools.visual.ai.approach.base;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

/**
 * Base Class to get and close web driver object
 */

public class VisualBaseClass {

	static WebDriver driver = null;
	static EyesRunner runner = null;
	static Eyes eyes = null;
	static BatchInfo batch = null;

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
	public static void closeBrowserWindowAndEyes() {
		if (driver != null) {
			driver.close();
		}
		if (eyes != null) {
			eyes.abortIfNotClosed();
		}
	}

	public static BatchInfo getBatchInfo() {
		if (batch == null) {
			batch = new BatchInfo("Hackathon");
		}
		return batch;
	}

	public static EyesRunner getClassicRunner() {
		// Initialize the Runner for your test.
		if (runner == null) {
			runner = new ClassicRunner();
		}
		return runner;
	}

	public static Eyes getEyes() {
		// Initialize the eyes SDK
		if (eyes == null) {

			eyes = new Eyes(getClassicRunner());
			// Set your personal Applitols API Key from your environment variables.
			// Raise an error if no API Key has been found.
			if (isNullOrEmpty(System.getenv("APPLITOOLS_API_KEY"))) {
				throw new RuntimeException("No API Key found; Please set environment variable 'APPLITOOLS_API_KEY'.");
			}
			eyes.setApiKey(System.getenv("APPLITOOLS_API_KEY"));
			// set batch name
			eyes.setBatch(getBatchInfo());
		}
		return eyes;
	}

}
