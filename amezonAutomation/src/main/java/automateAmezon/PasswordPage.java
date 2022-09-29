package automateAmezon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
	
	//declaration
	
		@FindBy (xpath="//input[@type='password']")
		private WebElement password;
		
		@FindBy (xpath="//input[@id='signInSubmit']")
		private WebElement signIn;
		
		//initialization
		
			public PasswordPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
	       //use
			
			public void sendPassword() {
				password.sendKeys("7757094005");
			}	
			
			public void clickSignInButon() {
				signIn.click();
			}	

}
