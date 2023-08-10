package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistractionPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	public void testAccountRegistration()
	{
		logger.info("Starting TC001AccountRegistrationTest");
		try {
			
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyaccountLink");
		hp.clickRegister();
		logger.info("Clicked on RegisterLink");
		AccountRegistractionPage reg= new AccountRegistractionPage(driver);
		reg.setFirstName(ralphabet().toUpperCase());
		reg.setLastName(ralphabet());
		reg.setEmail(ralphabet()+"@gmail.com");
		reg.setPassword(ralphabet());
		reg.setCheckedPolicy();
		logger.info("Prvided customer detais");
		reg.clickContinue();
		String Msg=reg.msgconfirmation();
		Assert.assertEquals(Msg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();
		}
	logger.info("finished testcase");	
	}

	
	
}
