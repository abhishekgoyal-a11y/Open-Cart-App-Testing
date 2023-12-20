package pageObjects;import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "firstname")
	WebElement firstname;
	
	@FindBy(id = "error-firstname")
	WebElement error_firstname;
	
	@FindBy(name = "lastname")
	WebElement lastname;
	
	@FindBy(id = "error-lastname")
	WebElement error_lastname;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(id = "error-email")
	WebElement error_email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(id = "error-password")
	WebElement error_password;
	
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

	@FindBy(css = "div#alert>dirv>button")
	WebElement RegistrationPageAlertCloseBtn;

	public void setFirstName(String fn) {
		SetInputValue(firstname, fn);
	}
	
	public String getFirstNameError() {
		return getElementText(error_firstname);
	}
	
	public void setLastName(String ln) {
		SetInputValue(lastname, ln);
	}
	
	public String getLastNameError() {
		return getElementText(error_lastname);
	}
	
	public void setEmail(String em) {
		SetInputValue(email, em);
	}
	
	public String getEmailError() {
		return getElementText(error_email);
	}
	
	public void setPassword(String psd) {
		SetInputValue(password, psd);
	}
	
	public String getPasswordError() {
		return getElementText(error_password);
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
		return getElementText(successMessage);
	}
	
	public String getRegistrationPageAlert() {
		return getElementText(RegistrationPageAlert);
	}
	
	public void closeRegistrationPageAlert() {
		System.out.println(RegistrationPageAlertCloseBtn);
		btnClick(RegistrationPageAlertCloseBtn);
	}

}
