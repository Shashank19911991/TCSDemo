package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverIntance {

	private static WebDriver driver;
	private WebDriverIntance() {

	}

	public static WebDriver getDriver() {

		if(driver ==null) {
			if(driver==null) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
				driver= new ChromeDriver();
			}
		}
		return driver;
	}
}
