import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

import com.smava.test.automation.utility.ResourceHelper;

public class FrameHandler {

	public static WebDriver driver;

//public static void flash(WebElement element, WebDriver driver) {

	/*
	 * //Execute script-->to execute java script code JavascriptExecutor
	 * js=((JavascriptExecutor)driver); String color=element.getCssValue("bgcolor");
	 * js.executeScript("", "");
	 * 
	 * }
	 */

	public static void main(String[] args) {
		/*
		 * Actions action=new Actions(driver); driver.findElement(new
		 * ByAll(By.id(""),(By.name("")))); driver.findElement(new
		 * ByChained(By.linkText(""),(By.name(""))));
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		 */

		// WebDriver driver=new SafariDriver();

		System.setProperty("webdriver.chrome.driver",
				ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("WINDOW-SIZE=1400,800");	
		options.addArguments("headless");

		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		driver.get("https://www.freecrm.com");
		driver.getTitle();
	}

}
