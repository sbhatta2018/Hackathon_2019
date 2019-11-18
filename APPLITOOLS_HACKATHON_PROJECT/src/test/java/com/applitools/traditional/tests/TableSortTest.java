package com.applitools.traditional.tests;

import static org.testng.Assert.assertEquals;
import java.util.LinkedHashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.applitools.base.BaseClass;
import com.applitools.webpages.factory.ExpensePage;

/**
 * This class contains test method to test table data sorting and data mismatch
 * after sorting
 */
public class TableSortTest extends BaseClass {
	static ExpensePage expensePage;
	static LinkedHashMap<String, String> tansactionBeforeSort;
	static LinkedHashMap<String, String> tansactionAfterSort;

	/**
	 * Before class to create Page Factory Object
	 * 
	 * @throws InterruptedException
	 */
	@BeforeClass
	public static void setup() {
		expensePage = new ExpensePage(getDriver());
		tansactionBeforeSort = new LinkedHashMap<String, String>();
		tansactionAfterSort = new LinkedHashMap<String, String>();
	}

	/**
	 * Test data to validate data is still intact after sorting
	 */
	@Test(priority = 1)
	public void testTableDataIntactAfterSort() {
		// Get Transaction Before Sort
		tansactionBeforeSort = expensePage.fetchTransactionList();
		// Click on Amount Method
		expensePage.clickOnAmountTab();
		// Get Transaction After Sort
		tansactionAfterSort = expensePage.fetchTransactionList();
		// Compare values are retained or not
		assertEquals(tansactionBeforeSort.equals(tansactionAfterSort), true, "Row's data are intact after sorting");
	}

	/**
	 * Test method to validate amount gets sorted properly
	 */
	@Test(priority = 2)
	public void testTableDataSort() {
		assertEquals(expensePage.validateIfAmountIsSorted(), true, "Account is in sorted order");
	}

}
