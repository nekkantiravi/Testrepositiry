package com.smava.test.automation.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.smava.test.automation.wrapperMethods.Wrappers;

public class LoanPage {
	
	WebDriver driver;
	
	public LoanPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//select[@id='applicant0.loan.selection.category']")
	WebElement creditLoanAmountCategory;
	
	@FindBy(xpath="//select[@id='applicant0.loan.selection.amount']")
	WebElement creditLoanAmount;
	
	@FindBy(xpath="//select[@id='applicant0.loan.selection.duration']")
	WebElement creditLoanDuration;
	
    public String getLoanCategory() throws InterruptedException{
		return Wrappers.getSelectedOptionFromDropDown(creditLoanAmountCategory);
	}
	
	public String getLoanAmount() throws InterruptedException{
	    return Wrappers.getSelectedOptionFromDropDown(creditLoanAmount);
		
	}
	
	public String getLoanDuration() throws InterruptedException{
		return Wrappers.getSelectedOptionFromDropDown(creditLoanDuration);
	}
	
}
