package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automateAmezon.AmezonHomePage;

public class VerifySingnUpPage {
	
	private WebDriver driver;
	private AmezonHomePage amezonHomePage;
	
	

	@BeforeClass
	public void openBrowser() {
		
		System.out.println("before class");
		System.setProperty("webdriver.chrome.driver", "C:\\VELOCITY AUTOMATION FILES\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		
	}

	@BeforeMethod
	public void openHomePage() {
		System.out.println("before method");
		System.out.println("home page");
		driver.get("https://www.amazon.in/");
		
		amezonHomePage=new AmezonHomePage(driver);
		amezonHomePage.clickSignUp();
	}
	
	@Test
	public void verifySignPage() {
		
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		String title=driver.getTitle();
		System.out.println(title);
		
		if(url.equals("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&")&& title.equals("Amazon Sign In"))
		{
			System.out.println("test case pass");
		}
		else
		{
			System.out.println("test case fail");
		}
	}
	
		@AfterMethod
		public void closeApplication()
		{
			System.out.println("after metod");
		}
		
		@AfterClass
		public void closebrowser()
		{
			System.out.println("after class");
			driver.close();
		}
}
