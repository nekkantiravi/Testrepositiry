import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.smava.test.automation.utility.ResourceHelper;

public class HandleWindowPopup {
public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #3')]")).click();
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it = handler.iterator();
		String parentwindowid = it.next();
		System.out.println("Parent window id:" +parentwindowid);
		
		String childwindowid = it.next();
		System.out.println("child windowid id:" +childwindowid);
		driver.switchTo().window(childwindowid);
		String childwindowtitle = driver.getTitle();
		System.out.println("Child window title:"+ childwindowtitle);
		driver.close();
		driver.switchTo().window(parentwindowid);
		String parentwindowtitle = driver.getTitle();
		System.out.println("Parent window title:"+ childwindowtitle);
		driver.quit();
	}

}
