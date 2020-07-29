package testng_Pac1_SL;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class testng_Quantas_SL {
 // This is a testcase to launch the Quantas website and then click on book > Flight> inorder to search a flight.
	
	WebDriver driver;
  
	@BeforeMethod
	/*setup method is used to do do basic setup for the testcase i.e setting system properties,
	launching the quantas website and maximizing the window along with setting pageload timeout*/
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qantas.com/us/en.html");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
}
	
	@Test
	
	/*bookFlightTest is the method to execute actual testcase after launching quantas site, by clicking on book>flight options
	and also validates whether correct url is opened for booking the flight */
	
  public void bookFlightTest() {
		
				WebElement book = driver.findElement(By.linkText("Book"));  
				book.click();
			
				WebElement flight = driver.findElement(By.linkText("Flights"));  
				flight.click();
				
			
				JavascriptExecutor js = (JavascriptExecutor)driver;  
		        js.executeScript("scrollBy(0, 600)");
		        
		        String actualUrl = driver.getCurrentUrl();
		        String epectedUrl = "https://www.qantas.com/us/en/book-a-trip/flights.html";
		        System.out.println("actual page opened for flight booking");
		        Assert.assertEquals(actualUrl,epectedUrl);
}
  
	@AfterMethod
	// To quit the browser.
	public void quitbrowser() {
	driver.quit();
	}

}

