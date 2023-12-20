package testCases.DDT;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_AccountRegistration extends BaseClass{
	
	@Test(dataProvider="RegistrationData", dataProviderClass=DataProviders.class)
	void test_execute_registration_test_cases(String action, String firstName, String lastName, String email, String password, String subscribe, String privacyPolicy, String result) {
		logger.info("****** TC_002_AccountRegistration Started ******");
		if (action.equals("account_registration_success"))
		{
			logger.info("****** account_registration_success Started ******");
			account_registration_success(firstName, lastName, email, password, subscribe, privacyPolicy, result);
			logger.info("****** account_registration_success Finished ******");
		}
		else if (action.equals("account_registration_email_exists"))
		{
			logger.info("****** account_registration_email_exists Started ******");
			account_registration_email_exists(firstName, lastName, email, password, subscribe, privacyPolicy, result);
			logger.info("****** account_registration_email_exists Finished ******");
		}
		else if (action.equals("account_registration_all_fields_warning_validation"))
		{
			logger.info("****** account_registration_all_fields_warning_validation Started ******");
			account_registration_all_fields_warning_validation(firstName, lastName, email, password, subscribe, privacyPolicy);
			logger.info("****** account_registration_all_fields_warning_validation Finished ******");
		}
		else {
			System.out.println("test action not found '" + action +"'");
			Assert.fail("test action not found:- '" + action +"'");
		}
		logger.info("****** TC_002_AccountRegistration Finished ******");
	}
	
	void account_registration(String firstName, String lastName, String email, String password, String subscribe, String privacyPolicy) {
		HomePage hp = new HomePage(driver);
		RegistrationPage rp = new RegistrationPage(driver);
		hp.clickMyaccount();
		hp.clickRegister();
		if (firstName.isEmpty()) {
			firstName = generateRandomString();
		}
		rp.setFirstName(firstName);
		if (lastName.isEmpty()) {
			lastName = generateRandomString();
		}
		rp.setLastName(lastName);
		if (email.isEmpty()) {
			email = generateRandomString()+"@gmail.com";
		}
		rp.setEmail(email);
		if (password.isEmpty()) {
			password = generateRandomAlphanumeric();
		}
		rp.setPassword(password);
		if (subscribe.equals("true")) {
			rp.btnSubscribe();
		}
		if (privacyPolicy.equals("true")) {
			rp.btnPrivacyPolicy();
		}
		rp.btnContinue();
	}
	
	void account_registration_success(String firstName, String lastName, String email, String password, String subscribe, String privacyPolicy, String result) {
		MyAccountPage map = new MyAccountPage(driver);
		RegistrationPage rp = new RegistrationPage(driver);
		account_registration(firstName, lastName, email, password, subscribe, privacyPolicy);
		add_delay(1);
		String getConfirmationmsg = rp.getConfirmationmsg();
		if (getConfirmationmsg.equals("Your Account Has Been Created!")) {
			map.ClicklogoutBtn();
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	void account_registration_email_exists(String firstName, String lastName, String email, String password, String subscribe, String privacyPolicy, String result) {
		RegistrationPage rp = new RegistrationPage(driver);
		account_registration(firstName, lastName, email, password, subscribe, privacyPolicy);
		add_delay(2);
		String getRegistrationPageAlert = rp.getRegistrationPageAlert();
		Assert.assertEquals(getRegistrationPageAlert, "Warning: E-Mail Address is already registered!");
	}
	
	void account_registration_all_fields_warning_validation(String firstName, String lastName, String email, String password, String subscribe, String privacyPolicy) {
		RegistrationPage rp = new RegistrationPage(driver);
		account_registration(firstName, lastName, email, password, subscribe, privacyPolicy);
		add_delay(1);
		String getFirstNameError = rp.getFirstNameError();
		String getLastNameError = rp.getLastNameError();
		String getEmailError = rp.getEmailError();
		String getPasswordError = rp.getPasswordError();
		String getRegistrationPageAlert = rp.getRegistrationPageAlert();
    
		if (getFirstNameError.equals("First Name must be between 1 and 32 characters!")) {
			if (getLastNameError.equals("Last Name must be between 1 and 32 characters!")) {
				if (getEmailError.equals("E-Mail Address does not appear to be valid!")) {
					if (getPasswordError.equals("Password must be between 4 and 20 characters!")) {
						if (getRegistrationPageAlert.equals(" Warning: You must agree to the Privacy Policy!")) {
							Assert.assertTrue(true);
						}
					}
				}
			}
		}
		else {
			Assert.fail();
		}
	}

}
