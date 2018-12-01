import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.smava.test.automation.utility.ResourceHelper;

public class BootstrapDropdwon {
	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		/*driver.get("http://www.rediff.com/");
		List<WebElement> lw = driver.findElements(By.tagName("a"));
		System.out.println(lw.size());
		
		for (int i = 0; i < lw.size(); i++) {

			String text = lw.get(i).getText();

			System.out.println(text);*/

			driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
			List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//li/a/label"));
			System.out.println(list.size());

			for (int j = 0; j < list.size(); j++) {
				System.out.println(list.get(j).getText());
				if (list.get(j).getText().contains("Python")) {
					list.get(j).click();

					break;

				}
			}

			driver.quit();
		}

		/*
		 * public void getAllDropDownData(WebElement element) { 
		 * Select select = new Select(element); 
		 * List<WebElement> elementlist = select.getOptions(); 
		 * for(WebElement ele : elementlist) { 
		 * ele.getText();
		 * 
		 * }
		 */
	}

