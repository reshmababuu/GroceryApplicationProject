package elementoryRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	//@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']/text()[3]")
	@FindBy(xpath="//*[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;
	
	
	public void clickOnmenuBar()
	{
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


}
