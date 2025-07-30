package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	WebDriver driver ;
	public RegistrationPage (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@placeholder='E-Mail']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@placeholder='Telephone']")
	WebElement txtTelephone;
	
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txtpassword;

	
	@FindBy(xpath="//input[@placeholder='Password Confirm']")
	WebElement txtPasswordconfirm;
	
	@FindBy(xpath="//input[@type=\"checkbox\"]")
	WebElement checkdPolicy;
	
	
	@FindBy(xpath="//input[@value=\"Continue\"]")
	WebElement btnContinue;
	
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement Msgconfirmation;
	
	
	
	public void setfirstname(String fname ) 
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setlasttname(String lname ) 
	{
		txtLastname.sendKeys(lname);
	}
	
	
	public void setemail(String email ) 
	{
		txtEmail.sendKeys(email);
	}
	
	public void settelephonenum(String telnum ) 
	{
		txtTelephone.sendKeys(telnum);
		
	}
	
	
	public void setpassword(String pwd ) 
	{
		txtpassword.sendKeys(pwd);
	}
// pwd and conpwd same so passing ped as parameter in both methods 
	
	public void setconpassword(String pwd ) 
	{
		txtPasswordconfirm.sendKeys(pwd);
	}

	
	public void setprivacypolicy() 
	{
		checkdPolicy.click();
		
	}
	
	
	
	public void clickcontinue() 
	{
		btnContinue.click();
		
		
	//1.	btncontinue.submit();
		
	//2.	Actions act = new Actions(driver);
	//		act.moveToElement(btncontinue).click().perform();
		
	//3.	JavascriptExecutor js =(JavascriptExecutor)driver;
	//		js.executeScript("arguments[0].click();", btncontinue);
		
	//4.	btncontinue.sendKeys(Keys.RETURN);
		
	//5.	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//		mywait.until(ExpectedConditions.elementToBeClickable(btncontinue));
	}
		
		public String getConfirmationMsg() {
			try {
				return(Msgconfirmation.getText());
			}catch(Exception e) {
				return(e.getMessage());
			}
		}
	
	
}
