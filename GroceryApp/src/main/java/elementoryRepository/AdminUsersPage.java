package elementoryRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitieS.ExplictWait;
import utilitieS.GeneralUtilities;

public class AdminUsersPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExplictWait exw= new ExplictWait();

	public AdminUsersPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[text()='Admin Users']")
	WebElement adminPage;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement neWButtoN;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement adMinuserName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement adminPassword;
	
	@FindBy(xpath="//select[@id='user_type']")
	WebElement userType;
	
	@FindBy(xpath="//button[@name='Create']")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;
	
	@FindBy(xpath="//input[@id='un']")
	WebElement searchUsername;
	
	@FindBy(xpath="//select[@id='ut']")
	WebElement searcUserType;
	
	@FindBy(xpath="(//button[@class='btn btn-block-sm btn-danger'])[1]")
	WebElement finalSearchbtn;
	
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")
	WebElement deleteButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertOfDeletion;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	WebElement resetBtn;
	
	@FindBy(xpath="//h4[text()='Admin Users']")
	WebElement resetAdminPage;

	
	public void clickOnAdminPage()
	{
		adminPage.click();
	}
	public void clicKOnNewButtoN()
	{
		neWButtoN.click();
	}
	public void inPutUserNameforAdmin(String name)
	{
		adMinuserName.sendKeys(name);
	}
	public void inputPasswordfoRadmin(String adpassword)
	{
		adminPassword.sendKeys(adpassword);
	}
	public void clickOnUserType()
	{
		userType.click();
	}
	public String selectTheuserType()
	{
		return gu.selectedValueFromDropDown(userType, "admin");
	}
	public void clickOnSaveButton()
	{
		
		saveBtn.click();
	}
	public String getAlertMessage()
	{
		return gu.getElementText(alertMsg);
		
	}
	public void clickOnSerachButton()
	{
		searchBtn.click();
	}
	public void inputsearchedAdminUserName(String srusername )
	{
		exw.explicitwaitvisibility(driver, searchUsername, "admin@resh246");
		
		//searchUsername.sendKeys(srusername);
	}
	public void clickonSearchedUsertype()
	{
		searcUserType.click();
	}
	public String getUserTypeofSearchedAdmin()
	{
		return gu.selectedValueFromDropDown(searcUserType, "admin");
	}
	public void clickOnFinalSearchButton()
	{
		finalSearchbtn.click();
	}
	public void deleteSearchedadmin()
	{
		deleteButton.click();
		driver.switchTo().alert().accept();
		
	}
	
	public String verifyThedeletedAlert()
	{
		return gu.getElementText(alertOfDeletion);
	}
	public void clickOnResetButton()
	{
		exw.explicitWaitForButtonClick(driver, resetBtn);
	}
	public String verifyTheResetadminPage()
	{
		return gu.getElementText(resetAdminPage);
	}


}
