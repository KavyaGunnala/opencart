package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;
import org.openqa.selenium.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	
@BeforeClass(groups= {"Master","Sanity","Regression"})
@Parameters("browser")
public void setup(String br)
{
	
	//ChromeOptions options=new ChromeOptions();
	//options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	rb=ResourceBundle.getBundle("config");
	
	logger=LogManager.getLogger(this.getClass());
//WebDriverManager.chromedriver().setup();
	if(br.equals("chrome"))
 driver=new ChromeDriver();
	
	else if(br.equals("edge"))
		driver=new EdgeDriver();
	
	else
	{
		driver=new FirefoxDriver();
	}
	driver.manage().deleteAllCookies();

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get(rb.getString("appURL1"));
driver.manage().window().maximize();




}


@AfterClass(groups= {"Master","Sanity","Regression"})
public void tearDown()
{
	driver.quit();
}



public String ralphabet()
{
	String a= RandomStringUtils.randomAlphabetic(5);
	return (a);
}
public String rNumber()
{
	String b=RandomStringUtils.randomNumeric(10);
	return b;
}

public String captureScreen(String tname)
{
	String timestamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot takescreenshot = (TakesScreenshot) driver;
	File Source=takescreenshot.getScreenshotAs(OutputType.FILE);
	String destination =System.getProperty("user.dir")+"\\screenshots"+tname+timestamp+".png";
	try {
		FileUtils.copyFile(Source, new File(destination));
	}
		catch(Exception e) {
			e.getMessage();
		}
		return destination;
	
	}
	
	
}
