package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	public WebDriver driver;
	
	private By email=By.xpath("//input[contains(@type,'email')]");
	private By sendMeInstructions=By.xpath("//input[@type='submit']");
	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement sendMeInstructions() {
		return driver.findElement(sendMeInstructions);
	}
}
