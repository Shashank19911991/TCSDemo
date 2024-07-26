package Util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import BasePackage.Base;

public class util extends Base {

	WebDriver driver = getBrowserInstanse();
	
	
	
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public void switchToframe(String frameName) {
		driver.switchTo().frame(frameName);

	}

	public void waitforPageload() {
		driver.manage().timeouts().pageLoadTimeout(util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

	public void DismissAlert() {

		driver.switchTo().alert().dismiss();
	}

	public void AcceptAlert() {

		driver.switchTo().alert().accept();
	}

	public void takeScreenShot(String name) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File(System.getProperty("user.dir")+"/src/test/resources/ScreenShot/ "+name+".png");

		FileUtils.copyFile(SrcFile, DestFile);

	}
}
