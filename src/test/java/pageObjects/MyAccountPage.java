package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="div#content > h2:nth-child(1)")
	WebElement MyAccount;
	
	@FindBy(xpath = "/html/body/main/div[2]/div/aside/div/a[13]")
	WebElement logoutBtn;
	
	public boolean isMyAccountPageExists() {
		try {
			return MyAccount.isDisplayed();
		}
		catch (Exception e){
			return false;
		}
	}
	
	public void ClicklogoutBtn() {
		logoutBtn.click();
	}
	
}