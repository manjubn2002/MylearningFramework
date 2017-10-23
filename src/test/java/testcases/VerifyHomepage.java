package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.Dataproviderfactory;
import pages.Homepage;

public class VerifyHomepage
{
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver=BrowserFactory.getbrowser("chrome");
		driver.get(Dataproviderfactory.getconfig().geturl());
	}
		
	@Test
	public void testhomepage()
	{
		Homepage home=PageFactory.initElements(driver, Homepage.class);
		String Actualtitle=home.Applicationtitle();
		String Expectedtitle="My Store";
		Assert.assertEquals(Actualtitle, Expectedtitle,"not matching");				
	}
}
