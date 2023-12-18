package testCases.DDT;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_001_AccountLogin extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	void test_execute_login_test_cases(String action, String username, String password, String expected_result) {
		logger.info("****** TC_001_AccountLogin Started ******");
		if (action.equals("account_login_validation"))
		{
			logger.info("****** account_login_validation Started ******");
			account_login_validation(username, password, expected_result);
			logger.info("****** account_login_validation Finished ******");
		}
		else if (action.equals("account_login_browser_back"))
		{
			logger.info("****** account_login_browser_back Started ******");
			account_login_browser_back(username, password, expected_result);
			logger.info("****** account_login_browser_back Finished ******");
		}
		else if (action.equals("account_login_logout_browser_back"))
		{
			logger.info("****** account_login_logout_browser_back Started ******");
			account_login_logout_browser_back(username, password, expected_result);
			logger.info("****** account_login_logout_browser_back Finished ******");
		}
		else {
			System.out.println("test action not found '" + action +"'");
			Assert.fail("test action not found:- '" + action +"'");
		}
		logger.info("****** TC_001_AccountLogin Finished ******");
	}
	
	void account_login_validation(String username, String password, String expected_result) {
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAdress(username);
			lp.setPassword(password);
			lp.ClickLoginBtn();
			Thread.sleep(1000);
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExists();
			if (expected_result.equals("Valid")) {
				if (targetPage == true) {
					map.ClicklogoutBtn();
					Assert.assertTrue(true);
				}
				else {Assert.assertTrue(false);}
			}
			else if (expected_result.equals("Invalid")) {
				if (targetPage == true) {
					map.ClicklogoutBtn();
					Assert.assertTrue(false);
				}
				else {Assert.assertTrue(true);}
			}
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void account_login_browser_back(String username, String password, String expected_result) {
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAdress(username);
			lp.setPassword(password);
			lp.ClickLoginBtn();
			Thread.sleep(1000);
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExists();
			if (expected_result.equals("Valid")) {
				if (targetPage == true) {
					driver.navigate().back();
					boolean loginPageExists = lp.isLoginPageExists();
					Assert.assertEquals(loginPageExists, true);
					Assert.assertTrue(true);
				}
				else {Assert.assertTrue(false);}
			}
			else if (expected_result.equals("Invalid")) {
				if (targetPage == true) {
					map.ClicklogoutBtn();
					Assert.assertTrue(false);
				}
				else {Assert.assertTrue(true);}
			}
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void account_login_logout_browser_back(String username, String password, String expected_result) {
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAdress(username);
			lp.setPassword(password);
			lp.ClickLoginBtn();
			Thread.sleep(1000);
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExists();
			if (expected_result.equals("Valid")) {
				if (targetPage == true) {
					map.ClicklogoutBtn();
					driver.navigate().back();
					boolean loginPageExists = lp.isLoginPageExists();
					Assert.assertEquals(loginPageExists, true);
					Assert.assertTrue(true);
				}
				else {Assert.assertTrue(false);}
			}
			else if (expected_result.equals("Invalid")) {
				if (targetPage == true) {
					map.ClicklogoutBtn();
					Assert.assertTrue(false);
				}
				else {Assert.assertTrue(true);}
			}
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
}
