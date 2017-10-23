package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage 
{
 WebDriver driver;
 
 public Homepage(WebDriver ldriver)
 {
	 this.driver=ldriver;
	 
 }
 
 @FindBy(xpath=".//*[@id='contact-link']/a") WebElement contactuslink;
 
 @FindBy(xpath="//a[@class='login']") WebElement signinlink;
 
 public void clickonsigninlink()
 {
	 signinlink.click();
 }
 public void contactuslink()
 {
	 contactuslink.click();
 }
 public String Applicationtitle()
 {
	 return driver.getTitle();
 }
}
