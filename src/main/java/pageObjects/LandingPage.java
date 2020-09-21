package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	private By login=By.xpath("//span[contains(.,'Login')]"); //The variables are declared as private and are accessed by methods
	private By title=By.xpath("//h2[contains(.,'Featured Courses')]");
	private By NavBar=By.xpath("//nav[contains(@class,'navbar-collapse collapse')]");
	private By header=By.xpath("//p[contains(.,'Learn Hot tools like Selenium')]");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public LoginPage getLogin() {              //this method access accross 2 different pages
		driver.findElement(login).click();    //after click in login a LoginPage object is created
		LoginPage lp=new LoginPage(driver);
		return lp;
	}
	public WebElement getTitle() {           //The methods must be declared as public
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(NavBar);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}

}
