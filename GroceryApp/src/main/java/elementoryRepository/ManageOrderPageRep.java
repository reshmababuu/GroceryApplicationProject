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
	
	@FindBy(xpath = "//select[@id='pt']")
	WebElement paymntMode;
	
//	public void logIn()
//{
//		LoginPageTestcase lptc = new LoginPageTestcase();
//        lptc.ClickOnSignIn();
//	}
	

	public void clickOnManagerOrderpage()
	{
		managersOrder.click();
	}
	public void clickONSearchBtnInManagerOrderPage()
	{
		searchButton.click();
	}
	public void clickOnPaymentMode()
	{
		paymntMode.click();
	}
	
	public String getTheSeletedValueOnDropdownList()
	{
		return gu.selectedValueFromDropDown(paymntMode,"Cash on Delivery");
		
	}
	}
	
	
	
	


