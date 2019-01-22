import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.smava.test.automation.utility.ResourceHelper;

public class HandleCalendar {

	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");

		driver.findElement(By.xpath("//input[@id='hp-widget__sfrom']")).sendKeys("New Delhi (DEL)");
		List<WebElement> listfrom = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li/div/p/span[1]"));
		System.out.println("City names: " + listfrom.size());

		for (int i = 0; i < listfrom.size(); i++) {
			//String names=listfrom.get(i).getText();
			//System.out.println(names);
			Random r = new Random();

			//if(listfrom.get(i).getText().equals("New Delhi, India")) {
               //listfrom.get(i).click();
			listfrom.get(r.nextInt()).click();
			break;

		//}
		}
		/*driver.findElement(By.xpath("//input[@id='hp-widget__sTo']")).sendKeys(Keys.ENTER);
		List<WebElement> listto = driver.findElements(By.xpath("//ul[@id='ui-id-2']//li/div/p/span[1]"));
		System.out.println("City names: " + list.size());

		for (int i = 0; i < listto.size(); i++) {
			String names=listto.get(i).getText();
			System.out.println(names);
			Random r1 = new Random();

			if(listto.get(i).getText().contains("Mumbai, India")) {
			listto.get(r1.nextInt(20)).click();
			break;*/

		}

}
