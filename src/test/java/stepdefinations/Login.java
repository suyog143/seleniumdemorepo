package stepdefinations;

import java.io.IOException;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.AccountPage;
import pageobject.LandingPage1;
import pageobject.LoginPage;
import resources.Base;


public class Login extends Base {

	WebDriver driver; // Making WebDriver driver Globally
	LandingPage1 landingpage1; // Making LandingPage1 landingpage1 globally
	LoginPage loginpage; // Making LoginPage loginpage Globally
	AccountPage accountpage; // Making AccountPage accountpage Globally

	@Given("^Open any Browser$")
	public void open_any_browser() throws IOException {
		driver = intializeDriver();

	}

	@And("^Navigate to login page$")
		public void navigate_to_login_page() throws InterruptedException {
			driver.get(prop.getProperty("url"));
		landingpage1 = new LandingPage1(driver);

	landingpage1.myAccountDropDown().click();
		Thread.sleep(2000);

	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void user_enters_username_as_something_and_password_as_something_into_the_fields(String email,
	String password) throws InterruptedException {
	loginpage = new LoginPage(driver);
	loginpage.emailAddressField().sendKeys(email);

		loginpage.passwordField().sendKeys(password);

		}

	@And("^User clicks on the Login button$")
		public void user_clicks_on_the_login_button() {
		loginpage = new LoginPage(driver);
		loginpage.loginButton().click();

		}

	@Then("^Verify user is able to successfully login$")
		public void verify_user_is_able_to_successfully_login() {
			accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.editAccountPageOption().isDisplayed());

	}

		@After
		public void closeBrowser() {
			driver.close();
		}
	
	 

}
