package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver ;
	
	public BasePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
// contains only constructor , webdriver  variable 
//Is extended into all the pages 
//it is parent of all page object classes 
//instead of creating every constructor for each page 
//pagefactory.initall elements
// inheritance and reusability 

// we can invoke parent class constructor by using super keyword 
// validations happen in test cases 
