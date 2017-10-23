package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage 
{
 WebDriver driver;
 
 public Loginpage(WebDriver ldriver)
 {
	 this.driver=ldriver;
 }
 
 @FindBy(xpath="//a[@class='login']") WebElement loginlink;
 
 @FindBy(xpath=".//*[@id='email']") WebElement username;
 
 @FindBy(xpath=".//*[@id='passwd']")WebElement password;
 
 @FindBy(xpath=".//*[@id='SubmitLogin']")WebElement Signinbtn;
 
 
 public void logintoapp(String User,String pass)
  {
	 loginlink.click();
	 username.sendKeys(User);
	 password.sendKeys(pass);
	 Signinbtn.click();
	 
 }
}
