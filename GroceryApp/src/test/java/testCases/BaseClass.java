package testCases;

import utilitieS.ScreenshotCapture;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
	ScreenshotCapture sc;
	
	//read the property file
	public static Properties prop;
	public static void testBasic() throws IOException
	{
		prop = new Properties();
		FileInputStream fp=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\properties\\config.properties");
			prop.load(fp);
	}

  @BeforeMethod
//  @Parameters("Browser")
//  public void beforeMethod(String s )throws IOException
//	{
//	 // testBasic();
//	 
//		if(s.equals("chrome"))
//		{
//			testBasic();
//			//System.setProperty("chromeDriver",("user.dir")+"\\src\\test\\resources\\DriverFiles\\chromedriver.exe");	
//		System.setProperty(prop.getProperty("chromeDriver"),System.getProperty("user.dir")+"\\src\\test\\resources\\DriverFiles\\chromedriver.exe");
//			driver = new ChromeDriver();
//
//	}
//		else if (s.equals("edge"))
//		{
//			testBasic();
//			//System.setProperty("edgeDriver",("user.dir")+"\\src\\test\\resources\\DriverFiles\\msedgedriver.exe");
//			System.setProperty(prop.getProperty("edgeDriver"),System.getProperty("user.dir")+"\\src\\test\\resources\\DriverFiles\\msedgedriver.exe");
//			 driver = new EdgeDriver();
//		}
//		//driver.get("BaseURL");
//			driver.get(prop.getProperty("BaseURL"));
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(java.time.Duration.ofMillis(5000));
//	
//	}
	
 public void beforeMethod() throws IOException 
  {
	  testBasic();
	  //chromedriver is in config.properties page. to use that using System.setproperty("name")
	  System.setProperty("chromeDriver",("user.dir")+"\\src\\test\\resources\\DriverFiles\\chromedriver.exe");
 
	     driver = new ChromeDriver();
		 driver.get(prop.getProperty("BaseURL"));
		
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofMillis(5000)); 
	  
 }

 @AfterMethod
  
	 // public void afterMethod()
	//  {
  // check the test pass or file using listener interface and reference of interface
 public void afterMethod(ITestResult iTestResult) throws IOException
//
 {
//	 // listener- listen the code. monitor the events. 25 type listener availabile in selenium
	  if (iTestResult.getStatus()==iTestResult.FAILURE)
	  {
		  sc = new ScreenshotCapture();
	 sc.captureFailureScreenShot(driver, iTestResult.getName()); //using the listener 
	  }
	// driver.close();
  }
  }



