import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.smava.test.automation.utility.ResourceHelper;

public class BarcodeReader {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, NotFoundException {

		System.setProperty("webdriver.chrome.driver",
				ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://barcode.tec-it.com/en");
		String barcodeurl = driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println(barcodeurl);
		URL url = new URL(barcodeurl);
		BufferedImage bufferedimage = ImageIO.read(url);

		LuminanceSource LuminanceSource = new BufferedImageLuminanceSource(bufferedimage);
		BinaryBitmap BinaryBitmap = new BinaryBitmap(new HybridBinarizer(LuminanceSource));
		Result result = new MultiFormatReader().decode(BinaryBitmap);
		System.out.println(result.getText());
		System.out.println(result.getBarcodeFormat());

		driver.quit();

	}

}	
