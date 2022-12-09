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
	WebElement text;

	public ManagerofferCodepageRep(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signIn;

	@FindBy(xpath = "//input[@name='username']")
	WebElement uName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//p[text()='Manage Offer Code']")
	WebElement managerOffrCode;



	public void clickOnManagerOfferCodepage() 
	{
		managerOffrCode.click();
	}
	

	public void getOfferPercentage() throws InterruptedException {
		List<WebElement>list1 =driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
		
		String elementLocator=gu.getTheSearchedValueInDynamicTable(list1, "12304_12_2022_07_58_54", "//table//tbody//tr[\"+(i+1)+\"]//td[2]");
		text = driver.findElement(By.xpath(elementLocator));
		String str=text.getText();
		
		System.out.println(str);
		
//		List<WebElement> list1 = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
//		gu.thread();
//		String elementLocator=gu.getTheSearchedValueInDynamicTable(list1, "500", "//table//tbody//tr[\" + (i + 1) + \"]//td[2]");
//         text = driver.findElement(By.xpath(elementLocator));
//				String percentage = text.getText();
//				System.out.println(percentage);
//			

			}
		

	
public String verifyThepercentageSame()
{
	
	return gu.getElementText(text);
	
}
}