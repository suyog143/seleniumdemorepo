package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage1 {

	WebDriver driver;

	public LandingPage1(WebDriver driver)// Constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropDown;
	
	@FindBy(linkText = "Login")
	private WebElement loginoption;
	

	public WebElement myAccountDropDown()
		{
			return myAccountDropDown;
		}
	
	public WebElement loginoption()
	{
		return loginoption;
	}

}
