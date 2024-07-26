package UITestPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BasePackage.Base;
import POM.HomePage;
import Util.util;

public class TestHomePage extends Base{

	util util= new util();
	HomePage hp = new HomePage();
	SoftAssert asrt = new SoftAssert();
	
	@BeforeClass
	public void Login() {
		//WebDriverManager.chromedriver().setup();
		driver = getBrowserInstanse(); 
		driver.get("https://www.jaguarlandrover.com/");
		driver.manage().window().maximize();
		util.waitforPageload();
	}
	
	@Test
	public void verifyPageTitleTest() throws InterruptedException, IOException {
		System.out.println("--------Test-------");
		
		boolean flag =hp.getPageTitle();
		asrt.assertTrue(flag);
	}
	
	@Test
	public void VerifyHeaderTest() throws InterruptedException, IOException {
		System.out.println("--------Test-------");
		int headerSize =hp.HeaderLists().size();
		asrt.assertEquals(headerSize, 6, "Some New Header Introduced in Home Page....");
		
		List<String> expectedHeaderList = new ArrayList<>();
		expectedHeaderList.add("Company");
		expectedHeaderList.add("Brands");
		expectedHeaderList.add("Investors");
		expectedHeaderList.add("Results Centre");
		expectedHeaderList.add("People");
		expectedHeaderList.add("News");
		
		for(int i=0; i<headerSize; i++) {
			asrt.assertEquals(hp.HeaderLists().get(i).getText(), expectedHeaderList.get(i), 
					"Expected And Actual Header Text not Matched...");
		}
		asrt.assertAll();
	
	}
	
	@AfterClass(alwaysRun= true)
	public void Flush() {
		driver.quit();
	}
}