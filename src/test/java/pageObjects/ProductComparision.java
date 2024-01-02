package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparision extends BasePage{

	public ProductComparision(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "#content > h1")
	WebElement successMessage;

	public String getConfirmationmsg() {
		return getElementText(successMessage);
	}
	
}