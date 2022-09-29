package test;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automateAmezon.AmezonHomePage;
import automateAmezon.PasswordPage;
import automateAmezon.SignupPage;

public class VerifyPasswordPage {
	
	private WebDriver driver;
	private AmezonHomePage amezonHomePage;
	private SignupPage signupPage;
	private PasswordPage passwordPage;

	@BeforeClass
	public void openBrowser() {
		System.out.println("open browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Documents\\automation\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );	  
	}
	@BeforeMethod
	public void openApplication() {
		System.out.println("open application");
		driver.get("https://www.amazon.in/");
		
		amezonHomePage=new AmezonHomePage(driver);
		amezonHomePage.clickSignUp();
		
		signupPage= new SignupPage(driver);
		signupPage.sendUserName();
		signupPage.clikcContinueButon();
		
		passwordPage= new PasswordPage(driver);
		passwordPage.sendPassword();
		passwordPage.clickSignInButon();
	}
	
	@Test
	public void passwordPage() {
		System.out.println("open home page");
		amezonHomePage.selectLanguage();
		
		String url=driver.getCurrentUrl();
		System.out.println(url);
		String title=driver.getTitle();
		System.out.println(title);
		
		if(url.equals("https://www.amazon.in/customer-preferences/edit?ie=UTF8&preferencesReturnUrl=%2F%3Fref_%3Dnav_ya_signin&ref_=topnav_lang") && title.equals("Change Language Settings"))
		{
			System.out.println("test case pass");
		}
		else
		{
			System.out.println("test case fail");
		}
		
	}
	
	@AfterMethod
	public void closeApplication() {
		System.out.println("close app");
	}
	
	@AfterClass
	public void closeBrowser(){
		System.out.println("close browser");
		
		driver.close();
	}
}
