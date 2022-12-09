package elementoryRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitieS.GeneralUtilities;

public class ManagePagesRep {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WebElement text;
	
	public ManagePagesRep(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[1]")
	WebElement managePages;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBTN;
	
	@FindBy(xpath="//input[@class='form-control']")
	WebElement tiTle;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchButton;
	
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
	    String elementLocator=gu.getTheSearchedValueInDynamicTable(list1, "Pasta", "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\" + (i+1) +\"]//td[2]");
			text=driver.findElement(By.xpath(elementLocator));
			//String str = text.getText();
			return gu.getElementText(text);
	}


}
