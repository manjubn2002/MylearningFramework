package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.Dataproviderfactory;
import pages.Homepage;
import pages.Loginpage;
import utility.helper;

public class VerifyLoginpagewithReportsscreenshot
{
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;
    
	@BeforeMethod
	public void setup()
	{
		
		 reports=new ExtentReports(".\\Reports\\loginpagereport.html",true);
		 
		 logger=reports.startTest("verify login page","This will verify login page");
		 
		driver=BrowserFactory.getbrowser("chrome");
		
		driver.get(Dataproviderfactory.getconfig().geturl());
		
		logger.log(LogStatus.INFO, "application is running");
	}
	
	@Test
	public void testhomepage()
	{
		
		Homepage home=PageFactory.initElements(driver, Homepage.class);
		String title=home.Applicationtitle();
		System.out.println("Application title is "+ title);
		
		logger.log(LogStatus.PASS, "Home page loaded and title verified");
		home.clickonsigninlink();
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(helper.capturescreenshot(driver, "manju")));
		
	    Loginpage login=PageFactory.initElements(driver, Loginpage.class);
	    login.logintoapp("manjunel@gmail.com", "pushti@");
	    logger.log(LogStatus.INFO, logger.addScreenCapture(helper.capturescreenshot(driver, "manju1")));
	    
	    logger.log(LogStatus.FAIL, "User not logged in successfully");
	    
	    }
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			String path=helper.capturescreenshot(driver, result.getName());
			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
					}
		
		
		BrowserFactory.closebrowser(driver);
		logger.log(LogStatus.INFO, "Browser closed");
		reports.endTest(logger);
		reports.flush();
	}
		
	}		
	

	