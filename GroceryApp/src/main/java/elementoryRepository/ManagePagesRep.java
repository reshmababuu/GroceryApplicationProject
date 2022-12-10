package elementoryRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitieS.ExplictWait;
import utilitieS.GeneralUtilities;

public class ManagePagesRep {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplictWait exw = new ExplictWait();
	WebElement text;
	
	public ManagePagesRep(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	//search
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[1]")
	WebElement managePages;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBTN;
	
	@FindBy(xpath="//input[@class='form-control']")
	WebElement tiTle;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchButton;
	
	//add new
	@FindBy(xpath="(//i[@class='fas fa-edit'])[1]")
	WebElement newButton;
	
    @FindBy(xpath="//input[@id='title']")
	WebElement inTitle;
    
    @FindBy(xpath="//div[@class='note-editable card-block']")
    WebElement description;
    
    @FindBy(xpath="//input[@id='page']")
    WebElement pageNumber;
    
    @FindBy(xpath="//input[@id='main_img']")
    WebElement uploadBtn;
    
    @FindBy(xpath="//button[text()='Save']")
    WebElement saveBtn;
    
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    WebElement alertOfSuccess;
    
    //Reset btn on Search
    
    @FindBy(xpath="//a[text()='Reset']")
    WebElement resetBtn;
    
    @FindBy(xpath="//h4[text()='List Pages']")
    WebElement listPage;
	
	public void clickOnManagePages()
	{
		managePages.click();
	}
	public void clickONSearchButtonInManagePages()
	{
		searchBTN.click();
	}
	public void inputTitle(String title)
	{
		tiTle.sendKeys(title);
	}
	public void clickOnSerchFinalButton()
	{
		searchButton.click();
	}
	public String getTheSearchedValue()
	{
		List<WebElement> list1=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
	    String elementLocator=gu.getTheSearchedValueInDynamicTable(list1, "Pasta", "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\" + (i+1) +\"]//td[4]");
			text=driver.findElement(By.xpath(elementLocator));
			return gu.getElementText(text);
	}
	
	// Add new Page
	public void clickOnNewButton()
	{
		newButton.click();
	}
	public void inputTitleandDescriptionOnAddpages(String title,String des)
	{
		inTitle.sendKeys(title);
		description.sendKeys(des);
	}
	public void inputPageNumber(String no)
	{
		pageNumber.sendKeys(no);
	}
	public void clickOnUploadButton() throws AWTException, InterruptedException
	{
		
		
		
		gu.upLoadFiles(driver, uploadBtn, System.getProperty("user.dir")+"\\src\\test\\resources\\UploadFile\\noodles.jfif");
	
	}
	public void clickOnSaveButton() throws InterruptedException
	{
		
		gu.minimumWaitthread();
	    gu.javaScriptClick(saveBtn, driver);
		
		
	}
	public String getTextOfAlertSuccess()
	{
		return gu.getElementText(alertOfSuccess);
	}
	
	
	public String getTextofResetpage()
	{
		resetBtn.click();
		return gu.getElementText(listPage);
	}
	


}
