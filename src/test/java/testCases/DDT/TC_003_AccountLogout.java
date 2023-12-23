package testCases.DDT;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_AccountLogout extends BaseClass{
	
	@Test(dataProvider="LogoutData", dataProviderClass=DataProviders.class)
	void test_execute_logout_test_cases(String action) {
		logger.info("****** TC_003_AccountLogout Started ******");
		if (action.equals("account_logout"))
		{
			logger.info("****** account_logout Started ******");
			account_logout();
			logger.info("****** account_logout Finished ******");
		}
		else if (action.equals("account_logout_from_right_column"))
		{
			logger.info("****** account_logout_from_right_column Started ******");
			account_logout_from_right_column();
			logger.info("****** account_logout_from_right_column Finished ******");
		}
		else if (action.equals("account_logout_browser_back"))
		{
			logger.info("****** account_logout_browser_back Started ******");
			account_logout_browser_back();
			logger.info("****** account_logout_browser_back Finished ******");
		}
		else if (action.equals("account_check_logout_btn_exists"))
		{
			logger.info("****** account_check_logout_btn_exists Started ******");
			account_check_logout_btn_exists();
			logger.info("****** account_check_logout_btn_exists Finished ******");
		}
		else if (action.equals("account_check_logout_right_column_btn_exists"))
		{
			logger.info("****** account_check_logout_right_column_btn_exists Started ******");
			account_check_logout_right_column_btn_exists();
			logger.info("****** account_check_logout_right_column_btn_exists Finished ******");
		}
		else if (action.equals("account_login_two_times"))
		{
			logger.info("****** account_login_two_times Started ******");
			account_login_two_times();
			logger.info("****** account_login_two_times Finished ******");
		}
		else {
			System.out.println("test action not found '" + action +"'");
			Assert.fail("test action not found:- '" + action +"'");
		}
		logger.info("****** TC_003_AccountLogout Finished ******");
	}
	
	void account_logout() {
		try {
			LoginPage lp = new LoginPage(driver);
			HomePage hp = new HomePage(driver);
			LogoutPage lop = new LogoutPage(driver);
			lp.account_login(rb.getString("email"), rb.getString("password"));
			add_delay(1);
			hp.clickMyaccount();
			lop.ClickLogoutBtn();
			boolean isLogoutAccountPageExists = lop.isLogoutAccountPageExists();
			Assert.assertEquals(isLogoutAccountPageExists, true);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
		
	}
	
	void account_logout_from_right_column() {
		try {
			LoginPage lp = new LoginPage(driver);
			LogoutPage lop = new LogoutPage(driver);
			lp.account_login(rb.getString("email"), rb.getString("password"));
			add_delay(1);
			lop.ClickLogoutRightColumnBtn();
			boolean isLogoutAccountPageExists = lop.isLogoutAccountPageExists();
			Assert.assertEquals(isLogoutAccountPageExists, true);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void account_logout_browser_back() {
		try {
			LoginPage lp = new LoginPage(driver);
			LogoutPage lop = new LogoutPage(driver);
			lp.account_login(rb.getString("email"), rb.getString("password"));
			add_delay(1);
			lop.ClickLogoutRightColumnBtn();
			driver.navigate().back();
			boolean isLoginPageExists = lp.isLoginPageExists();
			Assert.assertEquals(isLoginPageExists, true);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void account_check_logout_btn_exists() {
		try {
			LogoutPage lop = new LogoutPage(driver);
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			boolean isLogoutBtnExists = lop.isLogoutBtnExists();
			hp.clickMyaccount();
			Assert.assertEquals(isLogoutBtnExists, false);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void account_check_logout_right_column_btn_exists() {
		try {
			LogoutPage lop = new LogoutPage(driver);
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.clickRegister();
			boolean isLogoutRightColumnBtnExists = lop.isLogoutRightColumnBtnExists();
			Assert.assertEquals(isLogoutRightColumnBtnExists, false);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void account_login_two_times() {
		try {
			LoginPage lp = new LoginPage(driver);
			HomePage hp = new HomePage(driver);
			LogoutPage lop = new LogoutPage(driver);
			MyAccountPage map = new MyAccountPage(driver);
			lp.account_login(rb.getString("email"), rb.getString("password"));
			add_delay(1);
			hp.clickMyaccount();
			lop.ClickLogoutBtn();
			lp.account_login(rb.getString("email"), rb.getString("password"));
			add_delay(1);
			boolean isMyAccountPageExists = map.isMyAccountPageExists();
			Assert.assertEquals(isMyAccountPageExists, true);
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}

}
