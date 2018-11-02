package com.smava.test.automation.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.smava.test.automation.configuration.ConfigReader;
import com.smava.test.automation.configuration.PropertyFileReader;
import com.smava.test.automation.wrapperMethods.Wrappers;

public class LoginPage {
	ConfigReader reader=new PropertyFileReader();
	
	WebDriver driver;
	
	public String actualErrorMessage="Ihre Angaben zum Einloggen sind ungültig. Bitte versuchen Sie es erneut. Bitte beachten Sie, dass Ihr Zugang bei 3 Fehlversuchen von uns vorläufig gesperrt wird.";
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By emailTxtBox=By.xpath("//input[@id='signonForm.email']");
	By passwordTxtBox=By.xpath("//input[@id='signonForm.password']");
	By anmeldenButton=By.xpath("//button[@class='ui right labeled icon fluid button']");
	
	@FindBy(xpath="//*[@id='layout-wrapper']/div[3]/div[1]/div/div/div[1]/div/ul/li")
	public
	WebElement loginErrorMessage;
	
	
	public void enterEmailId(){
		Wrappers.typeText(emailTxtBox, reader.getEmailId());
	}
	
	public void enterPassword(){
		Wrappers.typeText(passwordTxtBox, reader.getPassword());
	}
	
	public void clickAnmeldenButton(){
		Wrappers.click(anmeldenButton);
	}
}
