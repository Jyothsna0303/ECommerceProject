package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage{
	WebDriver driver ;
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@placeholder='E-Mail Address']")
	WebElement txt_Email;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txt_Password;
	
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Btn_Login;
	
	public void SetEmailAddress(String Email)
	{
		txt_Email.sendKeys(Email);
		
	}
	
	public void SetPassword (String Pwd) 
	{
		txt_Password.sendKeys(Pwd);
	}
	
	public void ClickLoginButton() 
	{
		Btn_Login.click();
	}
	
}
