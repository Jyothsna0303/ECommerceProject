package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccPage extends BasePage{

	public MyAccPage(WebDriver driver) 
	{
		super(driver);
		
	}

	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msg_heading;
	
	@FindBy(xpath ="//div[@class='list-group']/a[text()='Logout']")
	WebElement LogoutLink;
	
	 public boolean isMyAccountPageExists() 
	 {
		 try 
		 {
			 
			 return( msg_heading.isDisplayed());
		 }
		 catch(Exception e) 
		 {
			 return false;
			 
		 }
		 
	 }
	 
	 public void clickLogout() {
		 LogoutLink.click();
	 }
}
