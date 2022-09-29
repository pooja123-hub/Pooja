package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import automateAmezon.AmezonHomePage;

public class VerifyAmazonHomePage {
	
	private WebDriver driver;
	private AmezonHomePage amezonHomePage;
	
	@Parameters ("browser")
	
	@BeforeTest
	public void openBrowser(String browserName) {
		if(browserName.equals("Chrome")) {
			System.out.println("openBrowser");
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Documents\\automation\\chromedriver_win32\\chromedriver.exe");
			 driver=new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		if(browserName.equals("Firefox")) {
			System.out.println("openBrowser");
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\ADMIN\\Documents\\automation\\geckodriver.exe");
			 driver=new FirefoxDriver();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
			
		}
	
	@BeforeClass
 public void openBroswer() {
		System.out.println("openBrowser");
	}	 
	
	@BeforeMethod
	 public void openApplication() {
		System.out.println("openApplication");
		 driver.get("https://www.amazon.in/");
		 amezonHomePage=new AmezonHomePage(driver);
		 
	}
	@Test 
	public void SignUpPage(){
		
	String url=	driver.getCurrentUrl();
		System.out.println(url);
	String Title=driver.getTitle();
	System.out.println(Title);
	Assert.assertEquals(url,"https://www.amazon.in/");
	Assert.assertEquals(Title,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	@Test
	public void verifyLanguage() {
		System.out.println("verifyLanguage");
		amezonHomePage.selectLanguage();
		
	}
	@Test 
	public void addToCart() {
		System.out.println("addToCart");
		amezonHomePage.Selectcart();
	}
	
	
	
	@AfterMethod
	public void closeApplication() {
		System.out.println("closeApplication");
	}
		
	@AfterClass
	public void clearBrowser() {
		 amezonHomePage=null;
		
		
		
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();
	}
}	 
		 
		 
		 
	


