package sentimentanalyse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SA {
	WebDriver pa;
	@BeforeClass
	public WebDriver launch()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\20112\\Downloads\\chromedriver.exe");
		pa = new ChromeDriver();
		pa.get("http://192.168.3.25:8080/prism");
		pa.manage().window().maximize();
		pa.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return pa;
	}

	@AfterClass
	public void close()
	{
		pa.quit();
	}
}
