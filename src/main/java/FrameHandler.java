import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

public class FrameHandler {
	
public static WebDriver driver;



	public static void main(String[] args) {
		Actions action=new Actions(driver);	
		driver.findElement(new ByAll(By.id(""),(By.name(""))));
		driver.findElement(new ByChained(By.linkText(""),(By.name(""))));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
	}

}
