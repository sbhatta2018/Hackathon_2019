package com.applitools.traditional.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.applitools.base.BaseClass;
import com.applitools.webpages.factory.DynamicContentPage;

/**
 * This class contains test methods for Dynamic Content Test
 */
public class DynamicContentTest extends BaseClass {
	static DynamicContentPage dynamicContentPage;

	/**
	 * Before class to create Page Factory Object
	 * 
	 * @throws InterruptedException
	 */
	@BeforeClass
	public static void setup() throws InterruptedException {
		dynamicContentPage = new DynamicContentPage(getDriver());
		dynamicContentPage.enterUserName("TestUser");
		dynamicContentPage.enterPassword("TestPassword");
		dynamicContentPage.clickOnLoginButton();
	}

	/**
	 * Test method to validate first GIF presence
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void validateFirstGIFPresence() throws InterruptedException {
		Thread.sleep(2000);
		assertEquals(dynamicContentPage.isFlashSaleFirstExists(), true, "First Flash Sell Exists");
	}

	/**
	 * Test method to validate second GIF presence
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void validateSecondGIFPresence() throws InterruptedException {
		Thread.sleep(2000);
		assertEquals(dynamicContentPage.isFlashSaleSecondExists(), true, "Second Flash Sell Exists");
	}

	/**
	 * Test method to verify different gif
	 */
	@Test
	public void verifyDifferentGIF() {
		/**
		 * This cannot be automated as Selenium WebDriver cannot compare images. This is
		 * one of the limitation in Selenium
		 */
	}

	/**
	 * After class to close browser window
	 */
	@AfterClass
	public static void closeBrowser() {
		closeBrowserWindow();
	}
}
