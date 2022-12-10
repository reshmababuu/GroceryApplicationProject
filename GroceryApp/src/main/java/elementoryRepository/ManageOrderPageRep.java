package elementoryRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitieS.GeneralUtilities;

public class ManageOrderPageRep 
{
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
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
	
	}
	
	
	
	


