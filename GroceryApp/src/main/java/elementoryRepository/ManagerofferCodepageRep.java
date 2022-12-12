package elementoryRepository;

import java.util.List;
//List<WebElement> list1 = driver.findElements(By.xpath("//table[@class='table
		// table-bordered table-hover table-sm']//tbody//tr//td[1]"));

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitieS.GeneralUtilities;

public class ManagerofferCodepageRep {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WebElement elmnt;

	public ManagerofferCodepageRep(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "//button[text()='Sign In']")
//	WebElement signIn;
//
//	@FindBy(xpath = "//input[@name='username']")
//	WebElement uName;
//
//	@FindBy(xpath = "//input[@name='password']")
//	WebElement password;

	@FindBy(xpath = "//p[text()='Manage Offer Code']")
	WebElement managerOffrCode;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;
	
	@FindBy(xpath="//input[@class='form-control']")
	WebElement offerCode;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchBtn2;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	WebElement resetBtn;
	
	@FindBy(xpath="//h4[text()='List Offercodes']")
	WebElement listOrders;



	public void clickOnManagerOfferCodepage() 
	{
		managerOffrCode.click();
	}
	public void clickOnSearchButton()
	{
		searchBtn.click();
	}
	

	public String getOfferPercentage(String offrCode) throws InterruptedException {
		
		offerCode.sendKeys(offrCode);
		searchBtn2.click();
		List<WebElement> list1= driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
		for(int i =0;i<list1.size();i++)
		{
		String locator = "//table//tbody//tr[" + (i+1) +"]//td[2]"; 
		elmnt = driver.findElement(By.xpath(locator));

		return gu.getElementText(elmnt);
		
		}
		return null;
		
	}
	
	public String resetFunctionOfTheManageOfferCodePage()
	{
		resetBtn.click();
		return gu.getElementText(listOrders);
	}
	
}
		
		
		

//		
//		List<WebElement> list1 = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
//		gu.thread();
//		String elementLocator=gu.getTheSearchedValueInDynamicTable(list1, "500", "//table//tbody//tr[\" + (i + 1) + \"]//td[2]");
//         text = driver.findElement(By.xpath(elementLocator));
//				String percentage = text.getText();
//				System.out.println(percentage);
//			

			
		

	

