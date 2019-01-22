import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.smava.test.automation.utility.ResourceHelper;

public class ScrollPage {
	 public static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
		driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
	       driver.findElement(By.xpath("//button[ends-with(@id,'-submit')]")).click();
		
		//js.executeScript("arguments[0].scrollIntoView();", scroll);
		//driver.quit();
		
		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		action.keyUp(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
	
	}

}
