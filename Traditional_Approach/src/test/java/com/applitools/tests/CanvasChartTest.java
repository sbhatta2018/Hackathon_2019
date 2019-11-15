package com.applitools.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.applitools.base.BaseClass;
import com.applitools.webpages.factory.CanvasChart;

/**
 * This class contains test class for testing canvas page
 */
public class CanvasChartTest extends BaseClass {
	static CanvasChart canvasChart;

	/**
	 * Before class to create Page Factory Object
	 * 
	 * @throws InterruptedException
	 */
	@BeforeClass
	public static void setup() throws InterruptedException {
		canvasChart = new CanvasChart(getDriver());
	}

	/**
	 * Test method to validate bar chart numbers and heights
	 */
	@Test
	public void validateBarChartsNumberAndHeights() {
		canvasChart.clickOnShowExpenseChartButton(getDriver());
		/**
		 * This cannot be automated as Selenium WebDriver cannot extract data from
		 * Canvas. This is one of the limitation in Selenium that it does not supports
		 * OCR
		 */
	}

	/**
	 * Test class to validate next year expense data
	 */
	@Test
	public void validateNextYearExpenseData() {
		canvasChart.clickOnShowNextYearExpenseData();
		/**
		 * This cannot be automated as Selenium WebDriver cannot extract data from
		 * Canvas. This is one of the limitation in Selenium that it does not supports
		 * OCR
		 */
	}
}
