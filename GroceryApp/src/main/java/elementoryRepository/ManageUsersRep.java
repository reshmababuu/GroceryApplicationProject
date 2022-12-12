package elementoryRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilitieS.GeneralUtilities;

public class ManageUsersRep 
{
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WebElement text;
	public ManageUsersRep(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Manage Users']")
	WebElement manageUsers;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement serchBtn;
	
	@FindBy(xpath="//input[@id='un']")
	WebElement name;
	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']")
	WebElement serchbtn2;

	
	public void clickOnManageUsers()
	{
		manageUsers.click();
	}
	public void clickOnSearchBtn()
	{
		serchBtn.click();
	}
	public void inputSelectedUsersName(String uname)
	{
		name.sendKeys(uname);
	}
	public void clickOnlastSearchBtn()
	{
		serchbtn2.click();
	}
	
	public String displayInputeduserStatus()
	{
		List<WebElement>list1 =driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
		
			String elementLocator=gu.getTheSearchedValueInDynamicTable(list1, "sree sree", "//table//tbody//tr[\"+(i+1)+\"]//td[5]");
			text = driver.findElement(By.xpath(elementLocator));
			return gu.getElementText(text);
	}
	
}
//}
//	public String verifyinputtetedUserStatus()
//	{
//		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
//		//for(int i = 0; i<list.size();i++)
//		//{
//			//if(list.get(i).getText().equals("sree sree"))
//			//{
//				
//	//String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[]//td[5]";
//		String locator ="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[3]//td";
//				  office = driver.findElement(By.xpath(locator));
//				
//				 
//				 
//				// String actual = office.getText();
//				
//				// System.out.println(actual);
//				 
//				return gu.getTheSearchedValue(list, "sree sree", office);
//				 
//			
//				 
//			}
//			
//		
	
	
	
	


