package com.applitools.traditional.approach.tests;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.applitools.traditional.approach.base.BaseClass;
import com.applitools.traditional.approach.webpages.factory.ExpensePage;

/**
 * This class contains test method to test table data sorting and data mismatch
 * after sorting
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	@Test
	public void testTableDataIntactAfterSort() {
		// Get Transaction Before Sort
		tansactionBeforeSort = expensePage.fetchTransactionList();
		// Click on Amount Method
		expensePage.clickOnAmountTab();
		// Get Transaction After Sort
		tansactionAfterSort = expensePage.fetchTransactionList();
		// Compare values are retained or not
		assertEquals("Row's data are intact after sorting", true, tansactionBeforeSort.equals(tansactionAfterSort));
	}

	/**
	 * Test method to validate amount gets sorted properly
	 */
	@Test
	public void testTableDataSort() {
		assertEquals("Account is in sorted order", true, expensePage.validateIfAmountIsSorted());
	}

}
