package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataprovider.ConfigDataProvider;

public class BrowserFactory 
{

	static WebDriver driver;
	public static WebDriver getbrowser(String Browsername)
	{
		if(Browsername.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Browsername.equalsIgnoreCase("chrome"))
		{
			ConfigDataProvider config=new ConfigDataProvider();
			System.setProperty("webdriver.chrome.driver", config.getchromepath());		
			driver=new ChromeDriver();	
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
public static void closebrowser(WebDriver ldriver)
{
	driver.quit();
}
}

