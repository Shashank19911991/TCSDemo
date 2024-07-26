package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.Base;

public class HomePage extends Base {

	WebDriver driver = getBrowserInstanse();
	private String title= "JLR Corporate Website";
	

	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="sf")
	private WebElement home;
	
	public boolean getPageTitle() {
		return driver.getTitle().equals(title);
	}
	
	@FindBy(xpath = "//div[@class='nav-2024__item']")
	public List<WebElement> li;
	
	
	
	public List<WebElement> HeaderLists() {
		return li;
	}
	
	
}
