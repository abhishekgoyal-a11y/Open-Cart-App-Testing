package pageObjects;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage
{   
	WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(name="search")
	WebElement searchInputBox;
	
	@FindBy(id="input-search")
	WebElement searchCriteriaInputBox;
	
	@FindBy(xpath="//*[@id=\"search\"]/button")
	WebElement searchBtn;
	
	@FindBy(css="div#content>h1")
	WebElement productComparisonElm;
	
	@FindBy(id="button-search")
	WebElement searchCriteriaBtn;
	
	@FindBy(id="input-sub-category")
	WebElement subCategoryCheckBox;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement searchPageHeading;
	
	@FindBy(id="input-category")
	WebElement categoryDropdown;
	
	@FindBy(id="compare-total")
	WebElement productCompareBtn;
	
	@FindBy(css="div#product-list>div")
	List<WebElement> searched_product_counts;
	
	public void clickproductCompareBtn() {
		btnClick(productCompareBtn);
	}
	
	public void clicksearchBtn() {
		btnClick(searchBtn);
	}
	
	public void clicksubCategoryCheckBox() {
		btnClick(subCategoryCheckBox);
	}
	
	public void clicksearchCriteriaBtn() {
		btnClick(searchCriteriaBtn);
	}
	
	public void setsearchInputBox(String searchInputText) {
		SetInputValue(searchInputBox, searchInputText);
	}
	
	public void setsearchCriteriaInputBox(String searchInputText) {
		SetInputValue(searchCriteriaInputBox, searchInputText);
	}
	
	public String getsearchPageHeading() {
		return getElementText(searchPageHeading);
	}
	
	public int get_searched_product_counts() {
		try {
			return searched_product_counts.size();
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	public boolean is_product_comparision_page_exists() {
		try {
			String productComparisonElmText = getElementText(productComparisonElm);
			return productComparisonElmText.equals("Product Comparison");
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public void selectcategoryDropdown(String categoryDropdownValue) {
		select_dropdown_by_value(categoryDropdown, categoryDropdownValue);
	}
}