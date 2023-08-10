package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

import testBase.BaseClass;

public class TC002LoginTest extends BaseClass {
	
@Test(groups= {"Sanity","Master"})
	public void testlogin()
	{
	try {
	logger.info("*****Startting login test*****");
	
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	logger.info("*****clicked on login link*****");
	LoginPage lp= new LoginPage(driver);
	logger.info("*****Providing login details*****");
	lp.setEmail(rb.getString("email"));
	lp.setPassword(rb.getString("password"));
	lp.clickLogin();
	logger.info("*****clicked on login*****");
	
	MyAccountPage macc= new MyAccountPage(driver);
	boolean targetPage=macc.isMyAccountPageExists();
	Assert.assertEquals(targetPage, true,"Invalid login data s");
	
	
		
	}
catch(Exception e) {
	Assert.fail();
}
}
}
