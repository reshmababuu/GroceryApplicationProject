package elementoryRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilitieS.GeneralUtilities;

public class PushNotificationsRep 
{
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	
	public PushNotificationsRep(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Push Notifications']")
	WebElement pushNotofication;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath="//input[@id='description']")
	WebElement discriptioN;
	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
	WebElement sendButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msgSendAlert;
	
	@FindBy(xpath="//a[text()='Reset']")
	WebElement reSet;
	
	public void clickOnPushNotificationPage()
	{
		pushNotofication.click();
	}
	public void inputTitle(String inTitle)
	{
		title.sendKeys(inTitle);
	}
	public void inputDiscription(String inDiscription)
	{
		discriptioN.sendKeys(inDiscription);
	}
	public void clickOnSendButton()
	{
		sendButton.click();
	}
	public String getAlertMessageText()
	{
		return gu.getElementText(msgSendAlert);
	}
	

	public boolean verifyTheResetFunctionOnPushNotificationPage()
	{
		return gu.resetFunction(driver, title, reSet, "Today offer");
	}

}
