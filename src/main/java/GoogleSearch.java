import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.smava.test.automation.utility.ResourceHelper;

public class GoogleSearch {
	public static WebDriver driver;
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
		driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Constructor");
		List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@role='option']/div/span"));
		System.out.println("no of suggestions in search box: " +list.size());
		
		for (int i=0;i<list.size();i++){
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("constructor in java")) {
			list.get(i).click();
			break;
		}
		}
}
}