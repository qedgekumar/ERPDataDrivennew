package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
	public static Properties conpro;
	public static WebDriver driver;
	@BeforeTest
	public static void setup() throws Throwable
	{
		conpro=new Properties();
		//load property file
		conpro.load(new FileInputStream("./PropertyFiles/Environmemnt.properties"));
		if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (conpro.getProperty("Browser").equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			
		}
		else
		{
			Reporter.log("Browser value is Not matching",true);
		}
		
			
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
