package elementoryRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitieS.ExplictWait;
import utilitieS.GeneralUtilities;

public class MobileSliderRep 
{
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplictWait exw = new ExplictWait();
	public MobileSliderRep(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;
	
	@FindBy(xpath="//p[text()='Mobile Slider']")
	WebElement mobileSlider;
	
	@FindBy(xpath="//select[@id='cat_id']")
	WebElement categoryDropdwn;
	
	@FindBy(xpath="//input[@id='main_img']")
	WebElement chooseFileBtn;
	
	@FindBy(xpath="//button[@name='create']")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement AlertMsg;
	
	@FindBy(xpath="//a[text()='Cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath="//h4[text()='List Mobile Sliders']")
	WebElement mobSliderList;
	
	public void ClickOnMobileSlider()
	{
		mobileSlider.click();
	}
	public void clickOnNewButton()
	{
		newBtn.click();
	}
	public void clickOnCategoryDrpDwn()
	{
		categoryDropdwn.click();
	}
	public String selectCategoryFromDropdown()
	{
		return gu.selectedValueFromDropDown(categoryDropdwn, "125");
	}
	
	public void upLoadFile() throws AWTException, InterruptedException
	{
		
		
		gu.upLoadFiles(driver, chooseFileBtn, System.getProperty("user.dir")+"\\src\\test\\resources\\UploadFile\\falooda.jfif");
		
		
	}
	public void clickOnSaveButton() throws InterruptedException
	{
		
		gu.minimumWaitthread();
		saveBtn.click();
	}
	
	
	public void clickOnCancelButtonOAddMobileSlider()
	{
		cancelBtn.click();
		
	}
	public String verifyTheResetFunction()
	{
		return gu.getElementText(mobSliderList);
	}
	
	

}
