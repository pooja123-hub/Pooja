package automateAmezon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmezonHomePage {

	//declaration
	
	@FindBy (xpath="//span[@id='nav-link-accountList-nav-line-1']")
	private WebElement signUp;
	
	@FindBy (xpath="//span[@class='nav-line-2'][1]")
	private WebElement language;
	
	@FindBy (xpath="//span [@id='nav-cart-count']")
	private WebElement cart;
	
	
	//initialization
	
		public AmezonHomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
	//use
		public void clickSignUp() {
			signUp.click();
		}
		
		public void selectLanguage() {
			language.click();
		}
		
	    public void Selectcart() {
	    	cart.click();
	    }
	    
	    
	    
	    
	    
	    }

