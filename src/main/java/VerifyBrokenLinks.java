import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.smava.test.automation.utility.ResourceHelper;

public class VerifyBrokenLinks {
	public static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (int i = 0; i < links.size(); i++) {
			WebElement ele = links.get(i);
			String url = ele.getAttribute("href");
			System.out.println(url);
		}

	}

	public static void verifyLinkActive(String linkurl) {
		try {
			URL url = new URL(linkurl);

			HttpURLConnection httpurlconnect = (HttpURLConnection) url.openConnection();

			httpurlconnect.connect();
			if (httpurlconnect.getResponseCode() == 200) {
				System.out.println(linkurl + " " + httpurlconnect.getResponseMessage());
				if (httpurlconnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
