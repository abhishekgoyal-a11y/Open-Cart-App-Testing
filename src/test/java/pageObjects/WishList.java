package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishList extends BasePage{
	
	public WishList(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css=".table-hover > tbody:nth-child(2) > tr > td:nth-child(2) > a")
	List<WebElement> products_list;
	
	public boolean product_found(String given_product_text) {
		boolean p_f = false;
		for (WebElement product:products_list) {
			String product_text = getElementText(product);
			if (product_text.trim().equals(given_product_text)) {
				p_f = true;
			}
		}
		return p_f;
	}

}
