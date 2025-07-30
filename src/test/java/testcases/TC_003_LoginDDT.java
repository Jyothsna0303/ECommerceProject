package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccPage;

import testbase.Baseclass;

import utilities.Dataproviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC_003_LoginDDT extends Baseclass
{

	@Test(dataProvider="LoginData",dataProviderClass=Dataproviders.class, groups ="Datadriven")
	public void verify_loginDDT(String email, String password, String exp)
	{
		logger.info("**** Starting TC_003_LoginDDT *****");
		
		try {
	
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
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(target_page==true)
				{
					map.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(target_page==true)
				{
					map.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC_003_LoginDDT *****");
	}
	
}








