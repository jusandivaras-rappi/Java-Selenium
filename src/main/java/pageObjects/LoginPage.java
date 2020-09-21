package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	
	private By email=By.xpath("//input[contains(@type,'email')]");
	private By password=By.xpath("//input[@type='password']");
	private By login=By.xpath("//input[@value='Log In']");
	private By forgotPassword=By.xpath("//a[@class='link-below-button'][contains(.,'Forgot Password?')]");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	}

}
