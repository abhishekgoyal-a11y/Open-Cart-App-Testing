package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {
	
	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[5]/a")
	WebElement LogoutBtn;
	
	@FindBy(css = "#content > h1")
	WebElement LogoutAccount;
	
	@FindBy(xpath = "//a[@href=\"http://localhost/opencart/index.php?route=account/logout&language=en-gb\" and @class=\"list-group-item\"]")
	WebElement LogoutRightColumnBtn;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/a")
	WebElement ContinueBtn;
	
	public void ClickLogoutBtn() {
		btnClick(LogoutBtn);
	}
	
	public void ClickLogoutRightColumnBtn() {
		btnClick(LogoutRightColumnBtn);
	}
	
	public void ClickContinueBtn() {
		btnClick(ContinueBtn);
	}
	
	public boolean isLogoutAccountPageExists() {
		try {
			return LogoutAccount.isDisplayed();
		}
		catch (Exception e){
			return false;
		}
	}
	
	public boolean isLogoutBtnExists() {
		try {
			return LogoutBtn.isDisplayed();
		}
		catch (Exception e){
			return false;
		}
	}
	
	public boolean isLogoutRightColumnBtnExists() {
		try {
			return LogoutRightColumnBtn.isDisplayed();
		}
		catch (Exception e){
			return false;
		}
	}

}
