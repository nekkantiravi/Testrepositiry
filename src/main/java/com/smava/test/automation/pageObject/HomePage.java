package com.smava.test.automation.pageObject;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.smava.test.automation.JsonReader.*;
import com.smava.test.automation.model.LoanInfo;
import com.smava.test.automation.utility.ResourceHelper;
import com.smava.test.automation.wrapperMethods.Wrappers;






public class HomePage {
	
	WebDriver driver;
	JsonReader jsonReader;
	File file=new File(ResourceHelper.getResourcePath("/src/main/resources/data/loanDetails.json"));
	LoanInfo loanInfo=JsonReader.convertJsonToJava(file, LoanInfo.class);
	
	public String selectedLoanAmount=loanInfo.getLoanAmount();
	public String selectedLoanTendure=loanInfo.getLoanTendure();
	public String selectedLoanType=loanInfo.getLoanType();
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By loanAmount=By.xpath("//*[@id='myselect']/div/input[@class='search']");
	By weiterButton=By.xpath("//a[@id='forwardButtonkredit2day']");
	By anmeldenLink=By.xpath("//a[@class='item login-popup uppercase']");
	
	public void selectLoanAmount() throws InterruptedException{
	    Wrappers.typeText(loanAmount, selectedLoanAmount);
		Wrappers.keysEnter();
	    Wrappers.keysTab();
	}
	
	public void selectLoanTendure() throws InterruptedException{
	    Wrappers.keysDown();
	    Wrappers.keysEnter();
	    Wrappers.keysTab();
	}

	public void selectLoanType() throws InterruptedException{
		for(int i=0;i<=1;i++)
			Wrappers.keysUp();
		Wrappers.keysEnter();
	}
	
	public void clickOnWeiterButton() throws InterruptedException{
		Wrappers.click(weiterButton);
	}
	
	public void clickAnmeldenLink(){
		Wrappers.click(anmeldenLink);
	}
}
