package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateNavigationBar extends base {
	public WebDriver driver; /*this is declarated in order to have a local object driver to be used insted of use web driver
	from base class. This is needed to run test in parallel mode*/
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("ValidateNavigationBar-Driver is initialized");
		driver.get(prop.getProperty("url")); // prop must be public in parent class to be used
		log.info("ValidateNavigationBar-Navigate to home page");
	}

	@Test
	public void basePageNavigation() throws IOException {
		// two ways to access to metods in object: 1.with inherits, 2.creating objects
		// of a class an invoking methods on it
		LandingPage l = new LandingPage(driver);
		// check if the nav bar is displayed in the web
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("ValidateNavigationBar-Successfully validated navegation bar");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
