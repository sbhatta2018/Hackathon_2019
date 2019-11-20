package com.applitools.traditional.approach.tests;


import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.applitools.traditional.approach.base.BaseClass;
import com.applitools.traditional.approach.webpages.factory.DynamicContentPage;

/**
 * This class contains test methods for Dynamic Content Test
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
		assertEquals("First Flash Sell Exists",true,dynamicContentPage.isFlashSaleFirstExists());
	}

	/**
	 * Test method to validate second GIF presence
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void validateSecondGIFPresence() throws InterruptedException {
		Thread.sleep(2000);
		assertEquals("Second Flash Sell Exists",true,dynamicContentPage.isFlashSaleSecondExists());
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
