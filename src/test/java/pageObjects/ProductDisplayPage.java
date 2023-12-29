package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplayPage extends BasePage{
	WebDriver driver;
	
	public ProductDisplayPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(css="#product-list > div > div > div.content > div > h4 > a")
	List<WebElement> products_list;
	
	@FindBy(xpath="/html/body/main/div[2]/div/div[1]/div[1]/div[2]/h1")
	WebElement product_name;
	
	@FindBy(xpath="/html/body/main/div[2]/div/div[1]/div[1]/div[2]/ul[1]/li[1]/a")
	WebElement product_brand;
	
	@FindBy(xpath="/html/body/main/div[2]/div/div[1]/div[1]/div[2]/ul[1]/li[2]")
	WebElement product_code;
	
	@FindBy(xpath="/html/body/main/div[2]/div/div[1]/div[1]/div[2]/ul[1]/li[3]")
	WebElement product_availability;
	
	@FindBy(css="span.price-new")
	WebElement product_price;
	
	@FindBy(xpath="/html/body/main/div[2]/div/div/div[1]/div[2]/ul[2]/li[2]")
	WebElement product_ex_tax;
	
	@FindBy(css="input#input-quantity")
	WebElement product_quantity;
	
	@FindBy(css="button#button-cart")
	WebElement add_to_cart;
	
	@FindBy(css="div#alert>div")
	WebElement product_display_page_success;

	@FindBy(css="div.alert.alert-info")
	WebElement product_minimum_quantity;

	@FindBy(css="a[href=\"#tab-description\"]")
	WebElement description_tab;

	@FindBy(css="a[href=\"#tab-review\"]")
	WebElement review_tab;

	@FindBy(css="p.text-center")
	WebElement no_review_text;

	@FindBy(xpath="/html/body/main/div[2]/div/div/div[5]/div/div/div[2]/form/div/button[2]")
	WebElement add_to_wish_list;

	@FindBy(xpath="/html/body/div/div/a[2]")
	WebElement wish_list_link_in_success_message;

	public boolean select_product_by_text(String product_text) {
		boolean productSelected = false;
		for (WebElement product:products_list) {
			String get_product_text = product.getText().trim();
			if (get_product_text.equals(product_text.trim())){
				btnClick(product);
				productSelected = true;
				break;
			}
			
		}
		return productSelected;
	}
	
	public String get_product_name() {
		return getElementText(product_name);
	}
	
	public String get_product_brand() {
		return getElementText(product_brand);
	}
	
	public String get_product_code() {
		return getElementText(product_code);
	}
	
	public String get_product_availability() {
		return getElementText(product_availability);
	}
	
	public String get_product_price() {
		return getElementText(product_price);
	}
	
	public String get_product_ex_tax() {
		return getElementText(product_ex_tax);
	}
	
	public String get_product_quantity_value() {
		return get_attribute_value(product_quantity, "value");
	}
	
	public void set_product_quantity_value(String product_quantity_value) {
		SetInputValue(product_quantity, product_quantity_value);
	}
	
	public void addToCartBtn() {
		btnClick(add_to_cart);
	}
	
	public void DescriptionTabBtn() {
		btnClick(description_tab);
	}
	
	public void ReviewTabBtn() {
		btnClick(review_tab);
	}
	
	public void AddToWishListBtn() {
		btnClick(add_to_wish_list);
	}
	
	public void AddToWishListLinkBtn() {
		btnClick(wish_list_link_in_success_message);
	}

	public String get_product_display_page_success() {
		return getElementText(product_display_page_success);
	}

	public String get_product_minimum_quantity() {
		return getElementText(product_minimum_quantity);
	}

	public String get_no_review_text() {
		return getElementText(no_review_text);
	}

	public String get_review_tab_aria_selected_text() {
		return get_attribute_value(review_tab, "aria-selected");
	}
}
