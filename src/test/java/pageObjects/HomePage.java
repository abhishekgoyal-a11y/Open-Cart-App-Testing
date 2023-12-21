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
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtSearchbox;
	
	@FindBy(xpath="//div[@id='search']//button[@type='button']")
	WebElement btnSearch;
	
	@FindBy(css="#content > div > div:nth-child(1) > div > div > a")
	WebElement btnNewCustomerContinue;
	
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[2]")
	WebElement btnRightColumnRegister;
	
	public void enterProductName(String pName)   //For Search Product Test
	{
		txtSearchbox.sendKeys(pName);
	}

	public void clickRegister() {
		btnClick(lnkRegister);
	}
	
	public void clickLogin() {
		btnClick(lnkLogin);
	}
	public void clickMyaccount() {
		btnClick(lnkMyaccount);
	}
	
	public void clickSearch()
	{
		btnClick(btnSearch);
	}
	
	public void clickNewCustomerContinue()
	{
		btnClick(btnNewCustomerContinue);
	}
	
	public void clickRightColumnRegister()
	{
		btnClick(btnRightColumnRegister);
	}
		
}
