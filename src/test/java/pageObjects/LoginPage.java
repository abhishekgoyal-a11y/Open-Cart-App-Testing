package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="email")
	WebElement emailInput;
	
	@FindBy(name="password")
	WebElement passwordInput;
	
	@FindBy(xpath="//*[@id=\"form-login\"]/div[3]/button")
	WebElement LoginBtn;
	
	public void setEmailAdress(String email_address) {
		emailInput.sendKeys(email_address);
	}
	
	public void setPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void ClickLoginBtn() {
		LoginBtn.click();
	}
	
	public boolean isLoginPageExists() {
		try {
			return LoginBtn.isDisplayed();
		}
		catch (Exception e){
			return false;
		}
	}
	
}