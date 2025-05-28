package carb.calc.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import carb.calc.pageobjects.CalcPage;

public class BaseTest {
	
	public WebDriver driver;
	public CalcPage calcPage;
	
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//carb//calc//resources\\GlobalData.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void launchApplication() throws IOException {
		driver = initializeDriver();
		calcPage = new CalcPage(driver);
		calcPage.goToWebpage();
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
	
	


}
