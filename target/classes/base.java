package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class base {

	public WebDriver driver; // global variable
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();

		// Make the path dynamic using System.getProperty("user.dir")
		// FileInputStream fis = new
		// FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\juan.usandivaras\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		// How to parametrize in Maven: mvn test -Dbrowser=chrome
		String browserName=System.getProperty("browser"); //Check in Maven if there any property browser
		//String browserName = prop.getProperty("browser"); // Line to get browser from data.properties file

		if (browserName.contains("chrome")) {
			// execute in chrome browser
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\juan.usandivaras\\eclipse-workspace\\E2EProject\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions(); // Lines to run Chrome in headless mode
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {
			// execute in firefox browser
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\juan.usandivaras\\eclipse-workspace\\E2EProject\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName == "IE") {
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // applies to all tests cases in framework
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException

	{

		String png = System.currentTimeMillis() + ".png";

		TakesScreenshot ts = (TakesScreenshot) driver; // driver takes an screenshot

		File source = ts.getScreenshotAs(OutputType.FILE); // line to save screenshot

		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + png;

		// user dir takes automatically the root of the project
		// the report captures the name of the test that fails

		FileUtils.copyFile(source, new File(destinationFile)); // save screenshot in local

		return destinationFile;

	}
}
