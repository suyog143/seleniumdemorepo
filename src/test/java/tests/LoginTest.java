package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.AccountPage;
import pageobject.LandingPage1;
import pageobject.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	public WebDriver driver;									//make WebDriver Global
	Logger log;											//make Logger Global

	@Test(dataProvider="getLoginData") //connected data Provider LoginData Method through dataProvider Annotation
	public void login(String email, String password, String expectedStatus) throws IOException, InterruptedException {
		
		
		
		
		LandingPage1 landingpage1= new LandingPage1(driver);
		
		landingpage1.myAccountDropDown().click();
		//log.debug("Clicked on My Account DropDown"); //log.debug("Clicked on login option");
		landingpage1.loginoption().click();		
		//log.debug("Clicked on login option");
		Thread.sleep(2000);
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.emailAddressField().sendKeys(email);
		//log.debug("Email Address got entered");
		loginpage.passwordField().sendKeys(password);
		//log.debug("Password got entered");
		loginpage.loginButton().click();
		//log.debug("Clicked on Login Button");
		
		AccountPage accountpage=new AccountPage(driver);
		
		String actualresult = null;
		try
		{
		if(accountpage.editAccountPageOption().isDisplayed()) //For Checking Condition True Or False
		{
		actualresult="Successful";
		log.debug("User got logged in");
		}
		}
		
		catch(Exception e)
		{
			actualresult="Failure";
			log.debug("User didn't log in");
		}
		
		Assert.assertEquals(expectedStatus, actualresult);
		log.debug("Login Test got passed");
		
		
		

	}
	
	private WebDriver intializeBrowser() {
		
		return null;
	}

	@BeforeMethod
	public void openApplication() throws IOException
	{
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = intializeDriver();
		log.debug("Browser got Launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application url");
		
		
		
	}
	
	@AfterMethod
	public void closure()
	{
		driver.close();
		log.debug("Browser got closed");
		
	}
	
	@DataProvider
	public Object[][] getLoginData()
	{
		Object[][] data= {{"mycity143@gmail.com", "Mycity@143", "Successful"}}; //{"dummy@gmail.com", "dummy", "Failure"}(for checking invalid credential)
		
		return data;
		
		
	}

}
