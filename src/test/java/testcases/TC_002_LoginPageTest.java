package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccPage;
import testbase.Baseclass;

public class TC_002_LoginPageTest extends Baseclass {

	@Test(groups={"Sanity", "Master"})
	public void verify_Login() {
		
		logger.info("*******Starting TC_002_LoginPageTes*****");
	
		try {
		//homepage
		HomePage hp= new HomePage(driver);
		hp.ClickMyaccountlink();
		hp.ClickLoginLink();
		
		//Loginpage
		LoginPage lp = new LoginPage(driver);
		lp.SetEmailAddress(p.getProperty("Email"));
		lp.SetPassword(p.getProperty("Pwd"));
		lp.ClickLoginButton();
		
		//my acc page 
		MyAccPage map= new MyAccPage(driver);
		boolean target_page=map.isMyAccountPageExists();
		
		Assert.assertTrue(target_page);
		//Assert.assertEquals(target_page, true,"login failed");
	
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*******Finished TC_002_LoginPageTes*****");
		
	}
}
