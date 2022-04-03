package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {
	public WebDriver driver; //making WebDriver driver global

	@Test
	public void testTwo() throws InterruptedException, IOException {
		System.out.println("TwoTest");

		driver = intializeDriver();

		driver.get("http://www.tutorialsninja.com/demo/");

		Thread.sleep(2000);
		driver.close();

	}

}
