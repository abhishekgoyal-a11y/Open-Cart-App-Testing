package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_AccountLoginTest extends BaseClass{

	@Test(groups= {"Sanity", "Master"})
	void test_account_login() {
		logger.info("****** TC_002_AccountLoginTest Started ******");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			logger.info("Clicked on My Account");
			hp.clickLogin();
			logger.info("Clicked on Login");
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAdress(rb.getString("email"));
			lp.setPassword(rb.getString("password"));
			logger.info("Customer Data Filled");
			logger.info("Clicking on Login Button");
			lp.ClickLoginBtn();
			Thread.sleep(1000);
			logger.info("Validating Expected Message");
			Thread.sleep(2000);
			
			MyAccountPage map = new MyAccountPage(driver);
			Assert.assertEquals(map.isMyAccountPageExists(), true, "login failed");
			logger.info("Clicking on Logout Button");
			map.ClicklogoutBtn();
		}
		catch (Exception e) {
			Assert.fail();
			logger.error("****** Starting TC_002_AccountLoginTest Failed ******");
		}
		logger.info("****** Starting TC_002_AccountLoginTest Passed ******");
	}
}
