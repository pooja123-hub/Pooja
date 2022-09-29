package automateAmezon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	//decleration
	
	@FindBy (xpath="//input[@type='email']")
	private WebElement username;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement continu;
	
	//initialization
	
	public SignupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//use
	public void sendUserName() {
		username.sendKeys("7796414634");
	}
	
	public void clikcContinueButon() {
		continu.click();
	}

}
