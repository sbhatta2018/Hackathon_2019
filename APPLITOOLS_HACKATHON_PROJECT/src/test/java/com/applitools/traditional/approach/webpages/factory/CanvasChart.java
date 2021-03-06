package com.applitools.traditional.approach.webpages.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CanvasChart {
	public CanvasChart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "showExpensesChart")
	private WebElement showExpenseChartBtn;

	// Show Next year expense button
	@FindBy(id = "addDataset")
	private WebElement showNxtYearExpenseBtn;

	// Click on show expense button
	public void clickOnShowExpenseChartButton(WebDriver driver) {
		showExpenseChartBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(showNxtYearExpenseBtn));
	}

	// Click on show next year expense button
	public void clickOnShowNextYearExpenseData() {
		showNxtYearExpenseBtn.click();
	}
}
