package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base{
	public WebDriver driver; //making WebDriver global

	@Test
	public void testThree() throws InterruptedException, IOException {
		System.out.println("ThreeTest");
		driver = intializeDriver();

		driver.get("http://www.tutorialsninja.com/demo/");

		Thread.sleep(2000);
		driver.close();
	}

}
