package utilitieS;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;

public class GeneralUtilities {
	 WebDriver driver;
	 public static Properties prop;
		public static void testBasic() throws IOException
		{
			prop = new Properties();
			FileInputStream fp=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\properties\\config.properties");
				prop.load(fp);
		}
	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String selectedValueFromDropDown(WebElement element, String value) // dropdownlist, its value
	{
		Select obj = new Select(element); //object
		obj.selectByValue(value);
		WebElement selectedElement = obj.getFirstSelectedOption(); //to get selected option
		String text = selectedElement.getText(); 
		return text;
	}
	public void minimumWaitthread() throws InterruptedException
	{
		Thread.sleep(6000);
	}
	
	public String getTheSearchedValueInDynamicTable(List<WebElement> list, String value, String locator) {
		String elemntLocator = null;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(value)) {

				elemntLocator = locator;
				break;
			}
		}
		return elemntLocator;

	}
	public void pageScroll(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,2000)");
	}
	
	public void upLoadFiles(WebDriver driver,WebElement element, String path) throws AWTException
	{
		
		
		Actions obj = new Actions(driver);
		obj.moveToElement(element).click().perform();
		
		//StringSelection ss = new StringSelection(System.getProperty("user.dir")+"\\src\\test\\resources\\UploadFile\\falooda.jfif");
		StringSelection fileLocation = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileLocation, null);
	     
		Robot robot = new Robot(); // object for robot class
	     robot.delay(250); // put delay
	     
	     robot.keyPress(KeyEvent.VK_CONTROL); // each keypress have 2 keyevents - keypress and keyrelease.
	     robot.keyPress(KeyEvent.VK_V);
	     
	     robot.keyRelease(KeyEvent.VK_CONTROL  );
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.delay(250);
	     
	     robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
	    
         robot.keyPress(KeyEvent.VK_CANCEL);
	     robot.keyRelease(KeyEvent.VK_CANCEL);
	}
	public void javaScriptClick(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	public void refreshPage(WebDriver driver,WebElement element)
	{
		driver.navigate().refresh();
		element.click();
	
	}
//	@BeforeMethod
//	@Parameters("browser")
//	public void launchBrowser(WebDriver driver, String s )
//	{
//		if (s.equalsIgnoreCase("chrome"))
//		{
//			System.setProperty("chromeDriver",("user.dir")+"\\src\\test\\resources\\DriverFiles\\chromedriver.exe");
//			driver = new ChromeDriver();
//			driver.get("https://groceryapp.uniqassosiates.com/admin/login");
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
//		}
//		else if (s.equalsIgnoreCase("firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\eclipse-workspace\\GroceryApp\\src\\test\\resources\\DriverFiles\\geckodriver.exe");
//			//System.setProperty("webdriver.gecko.driver", ("user.dir")+"\\src\\test\\resources\\DriverFiles\\geckodriver.exe");
//			 driver = new FirefoxDriver();
//			//driver.get("BaseURL");
//			 driver.get("https://groceryapp.uniqassosiates.com/admin/login");
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
//		}
//	}
	
	public boolean resetFunction(WebDriver driver,WebElement element,WebElement element2, String str)
	{
		 element.sendKeys(str);
		 element2.click();
		 String string1 = str;
		 boolean res;
		 res = (string1 == null);
		 System.out.println(Constant.nullMessage +res);
		 return res;
	}
//	
	
}

		
	
	
				
	
	
		



