package testCases.DDT;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_001_AccountLogin extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	void test_execute_login_test_cases(String action, String email, String password, String result) {
		logger.info("****** TC_001_AccountLogin Started ******");
		if (action.equals("account_login_validation"))
		{
			logger.info("****** account_login_validation Started ******");
			account_login_validation(email, password, result);
			logger.info("****** account_login_validation Finished ******");
		}
		else if (action.equals("account_login_browser_back"))
		{
			logger.info("****** account_login_browser_back Started ******");
			account_login_browser_back(email, password, result);
			logger.info("****** account_login_browser_back Finished ******");
		}
		else if (action.equals("account_login_logout_browser_back"))
		{
			logger.info("****** account_login_logout_browser_back Started ******");
			account_login_logout_browser_back(email, password, result);
			logger.info("****** account_login_logout_browser_back Finished ******");
		}
		else if (action.equals("account_login_password_copy"))
		{
			logger.info("****** account_login_password_copy Started ******");
			account_login_password_copy(password);
			logger.info("****** account_login_password_copy Finished ******");
		}
		else if (action.equals("account_login_close_browser"))
		{
			logger.info("****** account_login_close_browser Started ******");
			account_login_close_browser(email, password, result);
			logger.info("****** account_login_close_browser Finished ******");
		}
		else if (action.equals("account_login_navigating"))
		{
			logger.info("****** account_login_navigating Started ******");
			account_login_navigating();
			logger.info("****** account_login_navigating Finished ******");
		}
		else {
			System.out.println("test action not found '" + action +"'");
			Assert.fail("test action not found:- '" + action +"'");
		}
		logger.info("****** TC_001_AccountLogin Finished ******");
	}
	
	void account_login_validation(String email, String password, String result) {
		try {
			LoginPage lp = new LoginPage(driver);
			lp.account_login(email, password);
			Thread.sleep(1000);
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExists();
			if (result.equals("Valid")) {
				if (targetPage == true) {
					map.ClicklogoutBtn();
					Assert.assertTrue(true);
				}
				else {Assert.assertTrue(false);}
			}
			else if (result.equals("Invalid")) {
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
	
	void account_login_browser_back(String email, String password, String result) {
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAdress(email);
			lp.setPassword(password);
			lp.ClickLoginBtn();
			Thread.sleep(1000);
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExists();
			if (result.equals("Valid")) {
				if (targetPage == true) {
					driver.navigate().back();
					boolean loginPageExists = lp.isLoginPageExists();
					Assert.assertEquals(loginPageExists, true);
					Assert.assertTrue(true);
				}
				else {Assert.assertTrue(false);}
			}
			else if (result.equals("Invalid")) {
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
	
	void account_login_logout_browser_back(String email, String password, String result) {
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAdress(email);
			lp.setPassword(password);
			lp.ClickLoginBtn();
			Thread.sleep(1000);
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExists();
			if (result.equals("Valid")) {
				if (targetPage == true) {
					map.ClicklogoutBtn();
					driver.navigate().back();
					boolean loginPageExists = lp.isLoginPageExists();
					Assert.assertEquals(loginPageExists, true);
					Assert.assertTrue(true);
				}
				else {Assert.assertTrue(false);}
			}
			else if (result.equals("Invalid")) {
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
	
	void account_login_password_copy(String password) {
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setPassword(password);
			lp.copyPassword();
	        String clipboardContent = getFromClipboard();
	        System.out.println("Clipboard content: " + clipboardContent);
	        Assert.assertNotEquals(clipboardContent, "copypassword");
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	void account_login_close_browser(String email, String password, String result) {
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAdress(email);
			lp.setPassword(password);
			lp.ClickLoginBtn();
			Thread.sleep(1000);
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExists();
			if (result.equals("Valid")) {
				if (targetPage == true) {
					closeBrowser();
					setup("chrome", "false");
					Assert.assertEquals(map.isMyAccountDropdownExists(), true);;
				}
				else {Assert.assertTrue(false);}
			}
			else if (result.equals("Invalid")) {
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
	
	void account_login_navigating() {
		try {
			HomePage hp = new HomePage(driver);
			RegistrationPage rp = new RegistrationPage(driver);
			LoginPage lp = new LoginPage(driver);
			hp.clickMyaccount();
			hp.clickLogin();
			
			if (lp.isLoginPageExists() != true) {
				Assert.fail();
			}
			hp.clickMyaccount();
			hp.clickRegister();
			rp.btnLoginPage();
			
			if (lp.isLoginPageExists() != true) {
				Assert.fail();
			}
			driver.navigate().back();
			rp.btnHeaderLogin();
			
			if (lp.isLoginPageExists() != true) {
				Assert.fail();
			}
		}
		catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
}
