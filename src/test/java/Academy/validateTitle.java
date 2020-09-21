package Academy;

import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base {
	public WebDriver driver; /*this is declarated in order to have a local object driver to be used insted of use web driver
	from base class. This is needed to run test in parallel mode*/
	public static Logger log = LogManager.getLogger(base.class.getName());
	LandingPage l;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("ValidateTitle-Driver is initialized");
		driver.get(prop.getProperty("url")); // prop must be public in parent class to be used
		log.info("ValidateTitle-Navigate to home page");
	}

	@Test
	public void getTitle() throws IOException {
		// two ways to access to metods in object: 1.with inherits, 2.creating objects
		// of a class an invoking methods on it
		l = new LandingPage(driver); //Here we are giving the life to the object
		// compare the text from the browser with actual texto - Error..
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("ValidateTitle-Successfully validated text message");
	}
	
	@Test
	public void validateHeader() throws IOException {
		// two ways to access to metods in object: 1.with inherits, 2.creating objects
		// of a class an invoking methods on it
		//LandingPage l = new LandingPage(driver);
		// compare the text from the browser with actual texto - Error..
		Assert.assertEquals(l.getHeader().getText(), "Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		log.info("Juan Manuel");
	}

	
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
