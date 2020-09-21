package Academy;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
public class HomePage extends base{
	public WebDriver driver; /*this is declarated in order to have a local object driver to be used insted of use web driver
	from base class. This is needed to run test in parallel mode*/
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}
	
	@Test(dataProvider="getData")
	public void loginHomePage(String Username,String Password) throws IOException {
		//two ways to access to metods in object: 1.with inherits, 2.creating objects of a class an invoking methods on it
		driver.get(prop.getProperty("url")); // prop must be public in parent class to be used
		LandingPage l=new LandingPage(driver);
		LoginPage lp=l.getLogin(); 
		//LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();
		log.info("HomePage-Successfully user has logged");
		ForgotPassword fp=lp.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructions().click();
	}
	
	@DataProvider
	public Object[][] getData(){
		//Row stands for how many data types tests you will run
	    //Column stands for how many values per each test
		//For example if the object has a size 5 the rows will be 0,1,2,3,4 (first row in a array is 0)
		Object data [][]=new Object[2][2];
		//0th row
		data [0][0]="nonrestricteduser@qw.com";
		data [0][1]="123456";
		//data [0][2]="Non Restricted user";
		//1st row
	    data [1][0]="restricteduser@qw.com";
		data [1][1]="123456";
		//data [1][2]="Restricted user";  
		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
