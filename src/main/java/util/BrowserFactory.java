package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BrowserFactory {

	static WebDriver driver;
	static String browser = null;
	static String url = null;

	public static void readConfig() {

		System.out.println("Before Class");
		Properties prop = new Properties();
		// InputStream //BufferedReader// FileReader //Scanner---all these read any type files

		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println("Used environment: " + browser);
			url = prop.getProperty("url");
			System.out.println("Used environment: " + url);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Test
	public static WebDriver init() {

//		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("https://techfios.com/billing/");

		readConfig();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	@AfterClass
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
