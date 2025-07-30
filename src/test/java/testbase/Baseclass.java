package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass 
{

	//base class is parent class of all test cases classes 
	//re-usability
	//avoid duplication through base class 
	//lofg4j2.xml req for all testcases so we need to write a piece of code in base class setup method 
	// we need to pass the parameters we mentioned in testng file in set up method cause 
	//need to make webdriver as static after extent reportmanager because the base class created driver is referring everywhere 
	//additionally  in ERM baseclass object have created another driver which will make 2 drivers , so execution id difficult 
	//by adding static keyword we can use common varibale  across multiple objects 
	
	
	public static  WebDriver driver ;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"sanity", "Regression", "Master"})
	@Parameters({"os", "browser"})
	public void setUp(String os , String br) throws IOException
	{
		//loading config file into base class setup method -URL
		FileReader file = new FileReader(".//src/test/resources/Config.properties");
		p =new Properties();
		p.load(file);
		
		
		
		logger = LogManager.getLogger(this.getClass());
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abdul\\OneDrive\\Desktop\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\abdul\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		
		//based on cdtn we need to modify the pass parameters 
		
		switch(br.toLowerCase()) {
		case "chrome": 
			driver =new ChromeDriver();
		break;
		case "edge" : 
			driver= new EdgeDriver();
		break;
		default : 
			System.out.println("Invalid browser");
		return;
		
		}
		
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(p.getProperty("appurl"));// reading URL from config file
		//driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		
	}
	
	
	@AfterClass(groups= {"sanity", "Regression", "Master"})
	public void tearDown()
	{
		driver.quit();
	}
	

	public String randomeString()
	{
	String 	generatedString =RandomStringUtils.randomAlphabetic(7);
		return generatedString;
	}
	
	public String randomnumber() {
		String generatednumber =	RandomStringUtils.randomNumeric(9);
		return generatednumber;
	}
	//for Pwds 
	public String RandomAlphanumeric() 
	{
		String 	generatedString =RandomStringUtils.randomAlphabetic(4);
		String generatednumber =	RandomStringUtils.randomNumeric(5);
		return (generatedString+"@"+generatednumber);
	}
	
	public String captureScreen(String tname) {
	
		String timestamp = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		
		TakesScreenshot takesScreenshot  =(TakesScreenshot)driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath= System.getProperty("user.dir")+"\\screenShots\\"+ tname+"_" +timestamp + ".png";
		File targetFile = new File( targetFilePath);
		
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
		
		
		
		
		
	}

}
