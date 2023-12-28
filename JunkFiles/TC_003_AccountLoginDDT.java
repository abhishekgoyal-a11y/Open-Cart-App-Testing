package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_AccountLoginDDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	void test_account_login_ddt(String username, String password, String res) {
		logger.info("****** TC_003_AccountLoginDDT Started ******");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			logger.info("Clicked on My Account");
			hp.clickLogin();
			logger.info("Clicked on Login");
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAdress(username);
			lp.setPassword(password);
			logger.info("Customer Data Filled");
			logger.info("Clicking on Login Button");
			lp.ClickLoginBtn();
			Thread.sleep(1000);
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExists();
			if (res.equals("Valid")) {
				if (targetPage == true) {
					logger.info("Clicking on Logout Button");
					map.ClicklogoutBtn();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
			else if (res.equals("Invalid")) {
				if (targetPage == true) {
					logger.info("Clicking on Logout Button");
					map.ClicklogoutBtn();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
		}
		catch (Exception e) {
			Assert.fail();
			logger.error("****** Starting TC_003_AccountLoginDDT Failed ******");
		}
		logger.info("****** Starting TC_003_AccountLoginDDT Passed ******");
	}
}
