package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(css = "#input-newsletter-no")
	WebElement subscribe_no;
	
	@FindBy(css = "#form-register > div > button")
	WebElement continueBtn;
	
	@FindBy(css = "#content > h1")
	WebElement successMessage;
	
	@FindBy(xpath = "//*[@id=\"content\"]/p/a")
	WebElement loginPageBtn;
	
	@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[1]")
	WebElement HeaderloginBtn;
	
	public void btnClick(WebElement buttonElm) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(buttonElm));

            try {
                continueButton.click();
            } catch (Exception clickException) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", continueButton);
            }
        } catch (Exception e) {
            System.out.println("Exception while clicking on button: " + e.getMessage());
        }
	}
	
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

}
