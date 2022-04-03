package tests;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base {
	public WebDriver driver; //making WebDriver driver global
	@Test
	public void testFour() throws IOException, InterruptedException
	{
		System.out.println("FourTest");
		driver = intializeDriver();

		driver.get("http://www.tutorialsninja.com/demo/");

		Thread.sleep(2000);
		//Assert.assertTrue(false);
		//driver.close();
	}
	@AfterMethod
	public void closure()
	{
		driver.close();
	}
	}

