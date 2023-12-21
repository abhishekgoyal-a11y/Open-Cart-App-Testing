package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
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
	
	public String getElementText(WebElement Elm) {
		try {
			return Elm.getText();
		}
		catch (Exception e){
			return e.getMessage();
		}
	}
	
	public void SetInputValue(WebElement Elm, String value) {
		if (!value.equals("null")) {
				Elm.sendKeys(value);
		}
	}
    
    public String get_attribute_value(WebElement Elm, String attribute) {
    	try {
    		return Elm.getAttribute(attribute);
    	} catch  (NoSuchElementException e) {
			return "";
		}
    }
}
