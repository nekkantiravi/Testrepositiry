import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.smava.test.automation.utility.ResourceHelper;

public class HandleCalendar1 {
	public static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//input[@id='hp-widget__return']")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//*[@id='dp1543552117038']/div/div[2]/div/a/span")).sendKeys(Keys.ENTER);
		
		//*[@id="dp1543552117038"]/div/div[1]/table/tbody/tr[2]/td[1]/a
		//*[@id="dp1543552117038"]/div/div[1]/table/tbody/tr[2]/td[2]/a
		
		String Before_xpath="//*[@id='dp1543552117038']/div/div[1]/table/tbody/tr[";
		String After_xpath="]/td[";
		final int totalweekdays=7;
		String dayvalue = null;
		for(int rownum=2;rownum<=6;rownum++) {
			for(int colnum=1;colnum<=totalweekdays;colnum++) {
				try{
					dayvalue=driver.findElement(By.xpath(Before_xpath+rownum+After_xpath+colnum+"]/a")).getText();
					System.out.println(dayvalue);
				}catch(NoSuchElementException e) {
					System.out.println("please enter a correct data value");
					
				}
				
			}
		}

		

	}

}
