package elementoryRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitieS.ExplictWait;
import utilitieS.GeneralUtilities;

public class ManageExpensePageRep
{
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplictWait exw= new ExplictWait();
	public ManageExpensePageRep(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(xpath="//i[@class='fas fa-bars']")
	WebElement menuBar;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
	WebElement manageExpense;
	
	@FindBy(xpath="(//i[@class='far fa-circle nav-icon'])[1]")
	WebElement expenseCategory;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement titLe;
	
	@FindBy(xpath="//button[@name='Create']")
	WebElement savE;
	
	
	@FindBy(xpath="//*[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;
	
	@FindBy(xpath="//input[@id='un']")
	WebElement title;
	
	@FindBy(xpath="(//button[@class='btn btn-block-sm btn-danger'])[1]")
	WebElement searchBtn2;
	
	@FindBy(xpath=("//table//tbody//tr//td[1]"))
	WebElement category;
	
	//delete
	
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[1]")
	WebElement delete;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertOnDeletion;
	
	//edit
	@FindBy(xpath="(//i[@class='fas fa-edit'])[2]")
	WebElement editBtn;
	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
	WebElement updateBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertOnUpdate;
	
	
	public void clickOnmenuBar() throws InterruptedException
	{
		gu.minimumWaitthread();
		menuBar.click();
	}
	public void clickOnManageExpense()
	{
		manageExpense.click();
	}
	public void clickOnExpensECategory()
	{
		expenseCategory.click();
	}
	public void clickOnNewButton()
	{
		newButton.click();
	}
	public void inPutCategoryTitle(String title)
	{
		titLe.sendKeys(title);
	}
	public void clickOnSaveButton()
	{
		exw.explicitWaitForButtonClick(driver, savE);
		//savE.click();
	}
	public String verifyTheAlertMessage()
	{
		return gu.getElementText(alertMsg);
	}
	public void clickOnSearchButton()
	{
		searchBtn.click();
	}
	public void inputTitle(String inTitle)
	{
		title.sendKeys(inTitle);
	}
	public String clickOnSearchButtoninSearchExpenseCategory()
	{
		searchBtn2.click();
		return gu.getElementText(category);
		
	}
	public void deleteAnExpenseCategory()
	{
		searchBtn2.click();
		List<WebElement> list1 = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
		for(int i = 0; i<list1.size();i++)
		{
			String locator = "//table//tbody//tr[" + (i+1) +"]//td[1]"; 
			WebElement orderID = driver.findElement(By.xpath(locator));
			delete.click();
			driver.switchTo().alert().accept();
			System.out.println("One item deleted");
		}
	}
	public String verifyTheAlertMessageofDeletion()
	{
		return gu.getElementText(alertOnDeletion);
	}
	
	public void editAnExpenseCategory(String newTitle)
	{
		editBtn.click();
		titLe.clear();
		titLe.sendKeys(newTitle);
		updateBtn.click();
		
		
	}
	public String getTextOfAlertMsgOdUpdation()
	{
		return gu.getElementText(alertOnUpdate);
	}
	


}
