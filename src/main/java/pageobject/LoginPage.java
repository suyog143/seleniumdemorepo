package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) { //Constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-email")
	private WebElement emailAddressField;  //We Can Not Access Private Outside But With the help of Encapsulation, We can Call the 
										  //the object through public class
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(xpath= "//input[@type='submit']")
	private WebElement loginButton;

	public WebElement emailAddressField() {
		return emailAddressField;
	}
	
	
	public WebElement passwordField()
	{
		return passwordField;
	}
	
	public WebElement loginButton()
	{
		return loginButton;
	}
	
}
