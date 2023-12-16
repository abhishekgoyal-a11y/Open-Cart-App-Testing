package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{

	@Test(groups= {"Regression", "Master"})
	void test_account_registration() throws InterruptedException {
		logger.info("****** TC_001_AccountRegistrationTest Started ******");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			logger.info("Clicked on My Account");
			hp.clickRegister();
			logger.info("Clicked on Register");
			
			AccountRegistrationPage acp = new AccountRegistrationPage(driver);
			acp.setFirstName(generateRandomString());
			acp.setLastName(generateRandomString());
			acp.setEmail(generateRandomString()+"@gmail.com");
			Thread.sleep(10);
			acp.setPassword(generateRandomAlphanumeric());
			logger.info("Customer Data Filled");
			
			acp.btnPrivacyPolicy();
			acp.btnContinue();
			logger.info("Clicking on Continue Button");
			Thread.sleep(2000);
			logger.info("Validating Expected Message");
			Assert.assertEquals(acp.getConfirmationmsg().trim(), "Your Account Has Been Created!", "not getting expected message");
		}
		catch (Exception e) {
			Assert.fail();
			logger.error("****** Starting TC_001_AccountRegistrationTest Failed ******");
		}
		logger.info("****** Starting TC_001_AccountRegistrationTest Passed ******");
	}
}
