package testCases.DDT;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_004_SearchPage extends BaseClass{
	
	@Test(dataProvider="SearchData", dataProviderClass=DataProviders.class)
	void test_execute_search_test_cases(String action, String searched_text, String category_value) {
		logger.info("****** TC_004_SearchPage Started ******");
		if (action.equals("searched_product_text_validation"))
		{
			logger.info("****** searched_product_text_validation Started ******");
			searched_product_text_validation(searched_text);
			logger.info("****** searched_product_text_validation Finished ******");
		}
		else if (action.equals("no_product_found"))
		{
			logger.info("****** no_product_found Started ******");
			no_product_found(searched_text);
			logger.info("****** no_product_found Finished ******");
		}
		else if (action.equals("multiple_product_found"))
		{
			logger.info("****** multiple_product_found Started ******");
			multiple_product_found(searched_text);
			logger.info("****** multiple_product_found Finished ******");
		}
		else if (action.equals("searched_product_after_login"))
		{
			logger.info("****** searched_product_after_login Started ******");
			searched_product_after_login(searched_text);
			logger.info("****** searched_product_after_login Finished ******");
		}
		else if (action.equals("search_product_under_search_criteria"))
		{
			logger.info("****** search_product_under_search_criteria Started ******");
			search_product_under_search_criteria(searched_text);
			logger.info("****** search_product_under_search_criteria Finished ******");
		}
		else if (action.equals("search_product_by_category_product_found"))
		{
			logger.info("****** search_product_by_category_product_found Started ******");
			search_product_by_category_product_found(searched_text, category_value);
			logger.info("****** search_product_by_category_product_found Finished ******");
		}
		else if (action.equals("search_product_by_category_no_product_found"))
		{
			logger.info("****** search_product_by_category_no_product_found Started ******");
			search_product_by_category_no_product_found(searched_text, category_value);
			logger.info("****** search_product_by_category_no_product_found Finished ******");
		}
		else if (action.equals("search_product_check_sub_category"))
		{
			logger.info("****** search_product_check_sub_category Started ******");
			search_product_check_sub_category(searched_text, category_value);
			logger.info("****** search_product_check_sub_category Finished ******");
		}
		else if (action.equals("product_compare_navigation_check"))
		{
			logger.info("****** product_compare_navigation_check Started ******");
			product_compare_navigation_check(searched_text);
			logger.info("****** product_compare_navigation_check Finished ******");
		}
		else {
			System.out.println("test action not found '" + action +"'");
			Assert.fail("test action not found:- '" + action +"'");
		}
		logger.info("****** TC_004_SearchPage Finished ******");
	}
	
	void search_product(String searched_text) {
		SearchPage sp = new SearchPage(driver);
		sp.setsearchInputBox(searched_text);
		sp.clicksearchBtn();
	}
	
	void searched_product_text_validation(String searched_text) {
		try {
			SearchPage sp = new SearchPage(driver);
			search_product(searched_text);
			String searched_product_text = sp.getsearchPageHeading();
			Assert.assertEquals(searched_product_text, "Search - "+searched_text);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void no_product_found(String searched_text) {
		try {
			SearchPage sp = new SearchPage(driver);
			search_product(searched_text);
			int get_searched_product_counts = sp.get_searched_product_counts();
			Assert.assertEquals(get_searched_product_counts, 0);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void multiple_product_found(String searched_text) {
		try {
			SearchPage sp = new SearchPage(driver);
			search_product(searched_text);
			int get_searched_product_counts = sp.get_searched_product_counts();
			Assert.assertNotEquals(get_searched_product_counts, 0);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void searched_product_after_login(String searched_text) {
		try {
			LoginPage lp = new LoginPage(driver);
			LogoutPage lop = new LogoutPage(driver);
			HomePage hp = new HomePage(driver);
			lp.account_login(rb.getString("email"), rb.getString("password"));
			add_delay(1);
			SearchPage sp = new SearchPage(driver);
			search_product(searched_text);
			hp.clickMyaccount();
			lop.ClickLogoutRightColumnBtn();
			String searched_product_text = sp.getsearchPageHeading();
			Assert.assertEquals(searched_product_text, "Search - "+searched_text);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void search_product_under_search_criteria(String searched_text) {
		try {
			SearchPage sp = new SearchPage(driver);
			search_product("");
			sp.setsearchCriteriaInputBox(searched_text);
			sp.clicksearchCriteriaBtn();
			int get_searched_product_counts = sp.get_searched_product_counts();
			Assert.assertNotEquals(get_searched_product_counts, 0);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void search_product_by_category_product_found(String searched_text, String category_value) {
		try {
			SearchPage sp = new SearchPage(driver);
			search_product("");
			sp.setsearchCriteriaInputBox(searched_text);
			sp.selectcategoryDropdown(category_value);
			sp.clicksearchCriteriaBtn();
			int get_searched_product_counts = sp.get_searched_product_counts();
			Assert.assertNotEquals(get_searched_product_counts, 0);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void search_product_by_category_no_product_found(String searched_text, String category_value) {
		try {
			SearchPage sp = new SearchPage(driver);
			search_product("");
			sp.setsearchCriteriaInputBox(searched_text);
			sp.selectcategoryDropdown(category_value);
			sp.clicksearchCriteriaBtn();
			int get_searched_product_counts = sp.get_searched_product_counts();
			Assert.assertEquals(get_searched_product_counts, 0);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void search_product_check_sub_category(String searched_text, String category_value) {
		try {
			SearchPage sp = new SearchPage(driver);
			search_product("");
			sp.setsearchCriteriaInputBox(searched_text);
			sp.selectcategoryDropdown(category_value);
			sp.clicksearchCriteriaBtn();
			Assert.assertEquals(sp.get_searched_product_counts(), 0);
			sp.clicksubCategoryCheckBox();
			sp.clicksearchCriteriaBtn();
			Assert.assertNotEquals(sp.get_searched_product_counts(), 0);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void product_compare_navigation_check(String searched_text) {
		try {
			SearchPage sp = new SearchPage(driver);
			search_product(searched_text);
			sp.clicksearchCriteriaBtn();
			sp.clickproductCompareBtn();
			boolean is_product_comparision_page_exists = sp.is_product_comparision_page_exists();
			Assert.assertEquals(is_product_comparision_page_exists, true);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
}
