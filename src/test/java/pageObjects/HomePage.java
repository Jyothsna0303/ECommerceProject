package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	 WebDriver driver;
	 public HomePage(WebDriver driver) 
	 {
		 super(driver);
	 }
	 
	 
	 
	 @FindBy(xpath ="//span[text()='My Account']")
	 WebElement MyaccountLink;
	 
	 @FindBy(xpath ="//a[text()='Register']")
	 WebElement RegisterLink;
	 
	 @FindBy(linkText="Login")
	 WebElement LoginLink;
	 
	 
	
	 public void ClickMyaccountlink() {
		 MyaccountLink.click();
	 }
	 
	 public void ClickRegisterLink() {
		 RegisterLink.click();
	 }
	 
	 public void ClickLoginLink() {
		 LoginLink.click();
	 }
	 
}
