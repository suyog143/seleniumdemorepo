package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	public AccountPage(WebDriver driver)//Constructor
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(linkText= "Edit your account information")
	private WebElement editAccountInformationOption;  //We Can Not Access Private outside,
													// But With the help of Encapsulation, we can call this objects through public class
	public WebElement editAccountPageOption()       //means calling object through public class
	{
		return editAccountInformationOption;
	}
	
	

}
