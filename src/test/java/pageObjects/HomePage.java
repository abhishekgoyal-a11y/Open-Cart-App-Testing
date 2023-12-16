package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a")
	WebElement lnkRegister;
	
	@FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[2]/a")
	WebElement lnkLogin;
	
	@FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/a")
	WebElement lnkMyaccount;

	public void clickRegister() {
		lnkRegister.click();
	}
	public void clickLogin() {
		lnkLogin.click();
	}
	public void clickMyaccount() {
		lnkMyaccount.click();
	}
		
}
