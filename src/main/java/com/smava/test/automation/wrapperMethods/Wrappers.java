package com.smava.test.automation.wrapperMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.smava.test.automation.testBase.TestBase;

public class Wrappers {
	static Actions action;
	
	public static void click(By by) {
	    try {
	        (new WebDriverWait(TestBase.driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
	        TestBase.driver.findElement(by).click();
	    }
	    catch (StaleElementReferenceException sere) {
	        // simply retry finding the element in the refreshed DOM
	        TestBase.driver.findElement(by).click();
	    }
	    catch (TimeoutException toe) {
	    	toe.printStackTrace();
	    }
	}
	
	
	public static void typeText(By by,String data){
		 try {
		        (new WebDriverWait(TestBase.driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(by));
		        TestBase.driver.findElement(by).sendKeys(data);
		    }
		    catch (StaleElementReferenceException sere) {
		        // simply retry finding the element in the refreshed DOM
		        TestBase.driver.findElement(by).sendKeys(data);
		    }
		    catch (TimeoutException toe) {
		    	toe.printStackTrace();
		    }
	}
	
	public static String getSelectedOptionFromDropDown(WebElement element){
		TestBase.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select select=new Select(element);	
		return select.getFirstSelectedOption().getText();
	}
	
	public static void keysTab() throws InterruptedException{
		action=new Actions(TestBase.driver);
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).build().perform();
		
	}
	
	public static void keysUp() throws InterruptedException{
		action=new Actions(TestBase.driver);
		Thread.sleep(1000);
		action.sendKeys(Keys.UP).build().perform();
		
	}
	
	public static void keysDown() throws InterruptedException{
		action=new Actions(TestBase.driver);
		Thread.sleep(1000);
		action.sendKeys(Keys.DOWN).build().perform();
		
	}
	
	public static void keysEnter() throws InterruptedException{
		action=new Actions(TestBase.driver);
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).build().perform();
		
	}

}
