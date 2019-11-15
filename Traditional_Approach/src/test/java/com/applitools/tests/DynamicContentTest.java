package com.applitools.tests;

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
	 */
	@Test
	public void validateFirstGIFPresence() {
		assertEquals(dynamicContentPage.isFlashSaleFirstExists(), true, "First Flash Sell Exists");
	}

	/**
	 * Test method to validate second GIF presence
	 */
	@Test
	public void validateSecondGIFPresence() {
		assertEquals(dynamicContentPage.isFlashSaleSecondExists(), true, "Second Flash Sell Exists");
	}

	/**
	 * After class to close browser window
	 */
	@AfterClass
	public static void closeBrowser() {
		closeBrowserWindow();
	}
}
