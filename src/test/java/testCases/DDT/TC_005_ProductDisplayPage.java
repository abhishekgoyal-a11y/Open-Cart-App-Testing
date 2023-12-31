package testCases.DDT;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductComparision;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import pageObjects.WishList;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_005_ProductDisplayPage extends BaseClass{
	
	@Test(dataProvider="ProductDisplayPageData", dataProviderClass=DataProviders.class)
	void test_execute_product_display_page_test_cases(String action, String searched_text, String product_name,
			String product_brand, String product_code, String product_availability, String product_price,
			String product_price_ex_tax, String quantity_text, String result) {
		logger.info("****** TC_005_ProductDisplayPage Started ******");
		if (action.equals("product_details_verification"))
		{
			logger.info("****** product_details_verification Started ******");
			product_details_verification(searched_text, product_name, product_brand, product_code);
			logger.info("****** product_details_verification Finished ******");
		}
		else if (action.equals("product_availability_verification"))
		{
			logger.info("****** product_availability_verification Started ******");
			product_availability_verification(searched_text, product_availability);
			logger.info("****** product_availability_verification Finished ******");
		}
		else if (action.equals("product_price_verification"))
		{
			logger.info("****** product_price_verification Started ******");
			product_price_verification(searched_text, product_price, product_price_ex_tax);
			logger.info("****** product_price_verification Finished ******");
		}
		else if (action.equals("product_quantity_text_verification"))
		{
			logger.info("****** product_quantity_text_verification Started ******");
			product_quantity_text_verification(searched_text, quantity_text);
			logger.info("****** product_quantity_text_verification Finished ******");
		}
		else if (action.equals("product_add_to_cart"))
		{
			logger.info("****** product_add_to_cart Started ******");
			product_add_to_cart(searched_text, quantity_text, result);
			logger.info("****** product_add_to_cart Finished ******");
		}
		else if (action.equals("product_minimum_quantity_text_verification"))
		{
			logger.info("****** product_minimum_quantity_text_verification Started ******");
			product_minimum_quantity_text_verification(searched_text, result);
			logger.info("****** product_minimum_quantity_text_verification Finished ******");
		}
		else if (action.equals("no_review_text_verification"))
		{
			logger.info("****** no_review_text_verification Started ******");
			no_review_text_verification(searched_text, result);
			logger.info("****** no_review_text_verification Finished ******");
		}
		else if (action.equals("review_tab_focus_verification"))
		{
			logger.info("****** review_tab_focus_verification Started ******");
			review_tab_focus_verification(searched_text);
			logger.info("****** review_tab_focus_verification Finished ******");
		}
		else if (action.equals("product_add_to_wishlist"))
		{
			logger.info("****** product_add_to_wishlist Started ******");
			product_add_to_wishlist(searched_text, result);
			logger.info("****** product_add_to_wishlist Finished ******");
		}
		else if (action.equals("verfiy_product_added_to_wishlist"))
		{
			logger.info("****** verfiy_product_added_to_wishlist Started ******");
			verfiy_product_added_to_wishlist(searched_text);
			logger.info("****** verfiy_product_added_to_wishlist Finished ******");
		}
		else if (action.equals("compare_product_success_verification"))
		{
			logger.info("****** compare_product_success_verification Started ******");
			compare_product_success_verification(searched_text, result);
			logger.info("****** compare_product_success_verification Finished ******");
		}
		else {
			System.out.println("test action not found '" + action +"'");
			Assert.fail("test action not found:- '" + action +"'");
		}
		logger.info("****** TC_005_ProductDisplayPage Finished ******");
	}
	
	void search_product(String searched_text) {
		SearchPage sp = new SearchPage(driver);
		sp.setsearchInputBox(searched_text);
		sp.clicksearchBtn();
	}
	
	void product_details_verification(String searched_text, String product_name, String product_brand, String product_code) {
		try {
			ProductDisplayPage pdp = new ProductDisplayPage(driver);
			search_product(searched_text);
			boolean productSelected = pdp.select_product_by_text(searched_text);
			Assert.assertEquals(productSelected, true);
			String get_product_name = pdp.get_product_name();
			String get_product_brand = pdp.get_product_brand();
			String get_product_code = pdp.get_product_code();
			if (!get_product_name.trim().equals(product_name.trim())){
				Assert.fail("Product Name Not Matching "+get_product_name+product_name);
			}
			if (!get_product_brand.trim().equals(product_brand.trim())){
				Assert.fail("Product Brand Not Matching "+get_product_brand+product_brand);
			}
			if (!get_product_code.trim().equals(product_code.trim())){
				Assert.fail("Product Code Not Matching "+get_product_code+product_code);
			}
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void product_availability_verification(String searched_text, String product_availability) {
		try {
			ProductDisplayPage pdp = new ProductDisplayPage(driver);
			search_product(searched_text);
			boolean productSelected = pdp.select_product_by_text(searched_text);
			Assert.assertEquals(productSelected, true);
			String get_product_availability = pdp.get_product_availability();
			if (!get_product_availability.trim().equals(product_availability.trim())){
				Assert.fail("Product Availability Not Matching "+get_product_availability+product_availability);
			}
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void product_price_verification(String searched_text, String product_price, String product_price_ex_tax) {
		try {
			ProductDisplayPage pdp = new ProductDisplayPage(driver);
			search_product(searched_text);
			boolean productSelected = pdp.select_product_by_text(searched_text);
			Assert.assertEquals(productSelected, true);
			String get_product_price = pdp.get_product_price();
			String get_product_ex_tax = pdp.get_product_ex_tax();
			if (!get_product_price.trim().equals(product_price.trim())){
				Assert.fail("Product Price Not Matching "+get_product_price+product_price);
			}
			if (!get_product_ex_tax.trim().equals(product_price_ex_tax.trim())){
				Assert.fail("Product Ex Tax Not Matching "+get_product_ex_tax+product_price_ex_tax);
			}
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void product_quantity_text_verification(String searched_text, String quantity_text) {
		try {
			ProductDisplayPage pdp = new ProductDisplayPage(driver);
			search_product(searched_text);
			boolean productSelected = pdp.select_product_by_text(searched_text);
			Assert.assertEquals(productSelected, true);
			String get_product_quantity_value = pdp.get_product_quantity_value();
			if (!get_product_quantity_value.trim().equals(quantity_text.trim())){
				Assert.fail("Product Quantity Value Not Matching "+get_product_quantity_value+quantity_text);
			}
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void product_add_to_cart(String searched_text, String quantity_text, String result) {
		try {
			ProductDisplayPage pdp = new ProductDisplayPage(driver);
			search_product(searched_text);
			boolean productSelected = pdp.select_product_by_text(searched_text);
			Assert.assertEquals(productSelected, true);
			pdp.set_product_quantity_value(quantity_text);
			pdp.addToCartBtn();
			add_delay(1);
			String getProductDisplayPageSuccess = pdp.get_product_display_page_success();
			Assert.assertEquals(getProductDisplayPageSuccess, result);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void product_minimum_quantity_text_verification(String searched_text, String result) {
		try {
			ProductDisplayPage pdp = new ProductDisplayPage(driver);
			search_product(searched_text);
			boolean productSelected = pdp.select_product_by_text(searched_text);
			Assert.assertEquals(productSelected, true);
			String get_product_minimum_quantity = pdp.get_product_minimum_quantity();
			if (!get_product_minimum_quantity.trim().equals(result.trim())){
				Assert.fail("Product Minimum Quantity Text Not Matching "+get_product_minimum_quantity+result);
			}
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void no_review_text_verification(String searched_text, String result) {
		try {
			ProductDisplayPage pdp = new ProductDisplayPage(driver);
			search_product(searched_text);
			boolean productSelected = pdp.select_product_by_text(searched_text);
			Assert.assertEquals(productSelected, true);
			pdp.ReviewTabBtn();
			String get_no_review_text = pdp.get_no_review_text();
			System.out.println(get_no_review_text);
			System.out.println(result);
			if (!get_no_review_text.trim().equals(result.trim())){
				Assert.fail("No Review Text Not Matching "+get_no_review_text+result);
			}
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void review_tab_focus_verification(String searched_text) {
		try {
			ProductDisplayPage pdp = new ProductDisplayPage(driver);
			search_product(searched_text);
			boolean productSelected = pdp.select_product_by_text(searched_text);
			Assert.assertEquals(productSelected, true);
			pdp.ReviewTabBtn();
			String review_tab_aria_selected = pdp.get_review_tab_aria_selected_text();
			Assert.assertEquals(review_tab_aria_selected, "true");
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void product_add_to_wishlist(String searched_text, String result) {
		try {
			LoginPage lp = new LoginPage(driver);
			ProductDisplayPage pdp = new ProductDisplayPage(driver);
			lp.account_login(rb.getString("email"), rb.getString("password"));
			add_delay(1);
			search_product(searched_text);
			pdp.AddToWishListBtn();
			add_delay(1);
			String getProductDisplayPageSuccess = pdp.get_product_display_page_success();
			Assert.assertEquals(getProductDisplayPageSuccess, result);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void verfiy_product_added_to_wishlist(String searched_text) {
		try {
			ProductDisplayPage pdp = new ProductDisplayPage(driver);
			WishList wl = new WishList(driver);
			search_product(searched_text);
			pdp.AddToWishListBtn();
			pdp.AddToWishListLinkBtn();
			boolean product_found_in_wishlist_page = wl.product_found(searched_text);
			Assert.assertEquals(product_found_in_wishlist_page, true);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void compare_product_success_verification(String searched_text, String result) {
		try {
			ProductDisplayPage pdp = new ProductDisplayPage(driver);
			ProductComparision pc = new ProductComparision(driver);
			add_delay(1);
			search_product(searched_text);
			pdp.CompareProductBtn();
			add_delay(1);
			String getProductDisplayPageSuccess = pdp.get_product_display_page_success();
			Assert.assertEquals(getProductDisplayPageSuccess, result);
			pdp.ProductCompareLinkBtn();
			String getConfirmationmsg = pc.getConfirmationmsg();
			Assert.assertEquals(getConfirmationmsg, "Product Comparison");
			
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}

	
}
