package commonFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Reporter;

import config.AppUtil;

public class FunctionLIibrary extends AppUtil{
	public static boolean adminLogin(String username,String password) throws Throwable
	{
		driver.get(conpro.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(conpro.getProperty("objReset"))).click();
		driver.findElement(By.xpath(conpro.getProperty("objuser"))).sendKeys(username);
		driver.findElement(By.xpath(conpro.getProperty("objpass"))).sendKeys(password);
		driver.findElement(By.xpath(conpro.getProperty("objlogin"))).click();
		String Expected="dashboard";
		String Actual=driver.getCurrentUrl();
		if(Actual.contains(Expected))
		{
			Reporter.log("username and password are valid::"+Expected+"------"+Actual,true);
			Thread.sleep(1000);
			//click logout link
			driver.findElement(By.xpath(conpro.getProperty("objLogoutLink"))).click();
			return true;
			
		}
		else
		{
			String Errormessage=driver.findElement(By.xpath(conpro.getProperty("objError_message"))).getText();
			driver.findElement(By.xpath(conpro.getProperty("objokbutton"))).click();
			Reporter.log(Errormessage+"-------"+Expected+"-------"+Actual,true);
			return false;
		}
		
		
	}

}
