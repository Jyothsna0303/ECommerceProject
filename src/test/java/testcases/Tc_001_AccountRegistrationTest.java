package testcases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testbase.Baseclass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tc_001_AccountRegistrationTest extends Baseclass {


	
	@Test(groups={"Regression","Master"})
	public void VerifyAccRegPage() 
	{
	
		logger.info("**********Starting of testcase- Tc_001_AccountRegistrationTest");
		
		try {
		
		HomePage hp= new HomePage(driver);
		hp.ClickMyaccountlink();
		logger.info("clicked on my account link");
		hp.ClickRegisterLink();
		logger.info("clicked on Register link");
		RegistrationPage regPg= new RegistrationPage(driver);
		
		
		logger.info("Providing customer details");
		regPg.setfirstname(randomeString().toUpperCase());
		regPg.setlasttname(randomeString().toUpperCase());
		
		regPg.setemail(randomeString()+"@gmail.com");
		
		regPg.settelephonenum(randomnumber());
		
		//In order to get the saame value for con pwd and same pwd we need to store the value in string 
		String PwdVALUE = RandomAlphanumeric();
		regPg.setpassword(PwdVALUE);
		regPg.setconpassword(PwdVALUE);
		logger.info("clicking on checkpoints ");
		regPg.setprivacypolicy();
		regPg.clickcontinue();
		
//		regPg.setfirstname("jyothsna");
//		regPg.setlasttname("RAma");
//		regPg.setemail("dsfjh@gmail.com");
//		regPg.settelephonenum("5555588524");
//		regPg.setpassword("hello0987");
//		regPg.setconpassword("hello0987");
//		regPg.setprivacypolicy();
//		regPg.clickcontinue();
		
		
		
		logger.info("validating exp msg");
		String confirmmsg=regPg.getConfirmationMsg();
		if(confirmmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}else
		{
			logger.error("test failed");
			logger.debug("Debug logs......");
			Assert.assertTrue(false);
		}
			
			
		Assert.assertEquals(confirmmsg, "Your Account Has Been Created!");
		
		}catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("**********Ending of testcase- Tc_001_AccountRegistrationTest");
		
		// we need to pass data randomly new diff email to check this kind of case 
		//static data type , // random test data 
		// own user-defined method to generate string 
		
	}

}
