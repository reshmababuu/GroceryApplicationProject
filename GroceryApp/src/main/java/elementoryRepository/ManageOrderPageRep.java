package elementoryRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitieS.ExplictWait;
import utilitieS.GeneralUtilities;

public class ManageOrderPageRep 
{
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplictWait exw = new ExplictWait();
	public ManageOrderPageRep(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//p[text()='Manage Orders']")
	WebElement managersOrder;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	
	
	@FindBy(xpath="//input[@id='od']")
	WebElement orderID;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchBtn2;
	
	@FindBy(xpath="//a[text()='View']")
	WebElement viewBtn;
	
	@FindBy(xpath="//h1[text()='Order Details']")
	WebElement orderDetails;
	
	//delete an order
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteBtn;
	
	//search orders of a particular date period
	 
	@FindBy(xpath="//input[@id='sd']")
	WebElement startDate;
	
	@FindBy(xpath="//input[@id='ed']")
	WebElement endDate;
	
	//reset
	@FindBy(xpath="//button[@class='btn btn-default btn-fix']")
	WebElement resetBtn;
	
	@FindBy(xpath="//h4[text()='List Orders(20)']")
	WebElement listOrdersPage;

	

	public void clickOnManagerOrderpage()
	{
		managersOrder.click();
	}
	public void clickONSearchBtnInManagerOrderPage()
	{
		searchButton.click();
	}
	
	
	public void inputOrderIdOnSearchListOrdersPage(String id)
	{
		orderID.sendKeys(id);
		
	}
	public void clickOnSearchButtonISearchListOrdersPage()
	{
		searchBtn2.click();
	}
	public void clickOnViewButton()
	{
		gu.javaScriptClick(viewBtn, driver);
	}
	public String getTextOfOrderDetailspage()
	{
		return gu.getElementText(orderDetails);
	}
	public void clickOnDeleteButton()
	{
		gu.pageScroll(driver);
		exw.explicitWaitForButtonClick(driver, deleteBtn);
		driver.switchTo().alert().accept();
		
	}
	public void inputStartDate(String frstDate)
	{
		startDate.sendKeys(frstDate);
	}
	public void inputEndDate(String lastDate)
	{
		endDate.sendKeys(lastDate);
	}
	
	public void printTheOrderIdOFAParticularDatePeriod()
	{
		List<WebElement> list1 = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
		for(int i = 0; i<list1.size();i++)
		{
			String locator = "//table//tbody//tr[" + (i+1) +"]//td[1]"; 
			WebElement orderId = driver.findElement(By.xpath(locator));
			String s =orderId.getText();
			System.out.println("The Order id is "+s);
			}
	}
	
	public void clickOnResetBtnThesearchPage()
	{
		resetBtn.click();
	}
	public String getTheTextOnListOrderPage()
	{
		return gu.getElementText(listOrdersPage);
	}
			 
			

				
				
				
			
		
	}
	
	
	
	
	


