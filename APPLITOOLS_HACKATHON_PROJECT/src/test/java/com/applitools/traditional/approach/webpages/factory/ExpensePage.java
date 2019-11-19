package com.applitools.traditional.approach.webpages.factory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpensePage {
	public ExpensePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div/div[3]/div[2]/div/div/div[2]/div/div/table/tbody")
	private WebElement transactionTableBody;

	@FindBy(tagName = "tr")
	private WebElement tableRow;

	@FindBy(tagName = "td")
	private WebElement tableColumn;

	@FindBy(xpath = "/html/body/div/div[3]/div[2]/div/div/div[2]/div/div/table/tbody/tr")
	private List<WebElement> transactionTableRow;

	@FindBy(xpath = "/html/body/div/div[3]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td")
	private List<WebElement> transactionTableColumn;

	@FindBy(id = "amount")
	private WebElement amountTab;

	@FindBy(xpath = "/html/body/div/div[3]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[5]")
	private List<WebElement> amountValue;

	// Fetch Transaction Details
	public LinkedHashMap<String, String> fetchTransactionList() {
		String value = "";
		List<WebElement> tableCell;
		LinkedHashMap<String, String> transactionMap = new LinkedHashMap<String, String>();
		for (WebElement w : transactionTableRow) {
			tableCell = w.findElements(By.tagName("td"));
			for (int i = 0; i < tableCell.size(); i++) {
				value = value + tableCell.get(i).getText().toString() + " ";
				transactionMap.put(tableCell.get(2).getText().toString(), value);
			}
			value = "";
		}

		return transactionMap;
	}

	// Click on Amount Tab
	public void clickOnAmountTab() {
		amountTab.click();
	}

	// Retrieve amounts
	public boolean validateIfAmountIsSorted() {
		List<Double> amountList = new ArrayList<Double>();
		String amount;
		boolean isSorted = true;
		for (int i = 0; i < amountValue.size(); i++) {
			amount = amountValue.get(i).getText().toString().trim().replaceAll("USD", "").replaceAll(" ", "")
					.replaceAll(",", "").replaceAll("\\+", "");
			amountList.add(Double.parseDouble(amount));
		}
		for (int i = 1; i < amountList.size(); i++) {
			if (amountList.get(i - 1) > amountList.get(i)) {
				isSorted = false;
				break;
			}
		}
		return isSorted;
	}
}
