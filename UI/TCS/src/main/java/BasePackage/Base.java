package BasePackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	protected Properties props;
	protected WebDriver driver;
	public Base(){
		try {
			FileReader reader;

			reader = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\test.properties");
			props= new Properties();
			props.load(reader); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public WebDriver getBrowserInstanse(){
		if(props.getProperty("browser").equalsIgnoreCase("chrome")) {
			//	WebDriverManager.chromedriver().setup();
			driver = WebDriverIntance.getDriver();
		}else if(props.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			throw new IllegalArgumentException("No Browser");
		}
		return driver;
	}
}
