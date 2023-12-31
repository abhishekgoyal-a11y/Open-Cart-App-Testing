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
	
	@FindBy(xpath="//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a")
	WebElement MyAccountDropdown;
	
	@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[12]")
	WebElement NewsLetterBtn;
	
	@FindBy(name = "firstname")
	WebElement firstName;
	
	@FindBy(name = "lastname")
	WebElement lastName;
	
	@FindBy(name = "email")
	WebElement Email;
	
	public boolean isMyAccountPageExists() {
		try {
			return MyAccount.isDisplayed();
		}
		catch (Exception e){
			return false;
		}
	}
	
	public boolean isMyAccountDropdownExists() {
		try {
			String MyAccountDropdownText = MyAccountDropdown.getText();
			return MyAccountDropdownText.equals("My Account");
		}
		catch (Exception e){
			return false;
		}
	}
	
	public String getFirstNameValue() {
		return get_attribute_value(firstName, "value");
	}
	
	public String getlastNameValue() {
		return get_attribute_value(lastName, "value");
	}
	
	public String getEmailValue() {
		return get_attribute_value(Email, "value");
	}
	
	public void ClicklogoutBtn() {
		logoutBtn.click();
	}
	
	public void ClickNewsLetterBtn() {
		NewsLetterBtn.click();
	}
	
}