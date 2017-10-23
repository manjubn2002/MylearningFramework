package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.Dataproviderfactory;
import pages.Homepage;
import pages.Loginpage;

public class VerifyLoginpage
{
    WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver=BrowserFactory.getbrowser("chrome");
		driver.get(Dataproviderfactory.getconfig().geturl());
	}
	
	@Test
	public void testloginpage()
	{
		
		Homepage home=PageFactory.initElements(driver, Homepage.class);
		String title=home.Applicationtitle();
		System.out.println("Application title is "+ title);		
		home.clickonsigninlink();		
	    Loginpage login=PageFactory.initElements(driver, Loginpage.class);
	    login.logintoapp("manjunel@gmail.com","pushti@1");
	    
       }
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closebrowser(driver);
	}
		
	}		
	

	