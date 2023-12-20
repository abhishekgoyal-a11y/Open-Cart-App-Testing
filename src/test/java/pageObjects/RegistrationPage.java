package pageObjects;import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "firstname")
	WebElement firstname;
	
	@FindBy(name = "lastname")
	WebElement lastname;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//*[@id='form-register']/div/div/input")
	WebElement privacy_policy;
	
	@FindBy(css = "#form-register > div > button")
	WebElement continueBtn;
	
	@FindBy(xpath="//*[@id=\"input-newsletter\"]")
	WebElement subscribeBtn;
	
	@FindBy(css = "#content > h1")
	WebElement successMessage;
	
	@FindBy(xpath = "//*[@id=\"content\"]/p/a")
	WebElement loginPageBtn;
	
	@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[1]")
	WebElement HeaderloginBtn;
	
	@FindBy(css = "div#alert>dirv")
	WebElement RegistrationPageAlert;
	
	public void setFirstName(String fn) {
		firstname.sendKeys(fn);
	}
	
	public void setLastName(String ln) {
		lastname.sendKeys(ln);
	}
	
	public void setEmail(String em) {
		email.sendKeys(em);
	}
	
	public void setPassword(String psd) {
		password.sendKeys(psd);
	}
	
	public void btnPrivacyPolicy() {
		btnClick(privacy_policy);
	}

	public void btnContinue() {
		btnClick(continueBtn);
    }

	public void btnSubscribe() {
		btnClick(subscribeBtn);
    }

	public void btnLoginPage() {
		btnClick(loginPageBtn);
    }

	public void btnHeaderLogin() {
		btnClick(HeaderloginBtn);
    }
	
	public String getConfirmationmsg() {
		try {
			return successMessage.getText();
		}
		catch (Exception e){
			return e.getMessage();
		}
	}
	
	public String getRegistrationPageAlert() {

		try {
			return RegistrationPageAlert.getText();
		}
		catch (Exception e){
			return e.getMessage();
		}
	}

}
