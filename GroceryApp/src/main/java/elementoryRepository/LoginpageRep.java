package elementoryRepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitieS.ExplictWait;
import utilitieS.GeneralUtilities;

public class LoginpageRep 
{
WebDriver driver;
GeneralUtilities gu = new GeneralUtilities();
ExplictWait exw = new ExplictWait();

public LoginpageRep(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//button[text()='Sign In']")
WebElement signIn;

@FindBy(xpath = "//input[@name='username']")
WebElement uName;

@FindBy(xpath= "//input[@name='password']")
WebElement password;

@FindBy(xpath="//label[@for='remember']")
WebElement rememberMe;

@FindBy(xpath="//a[text()='Home']")
WebElement home;

@FindBy(xpath="//p[text()='Sign in to start your session']")
WebElement alert;

@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
WebElement alertMsg;


public void inputUserName(String usrname)
{
	uName.sendKeys(usrname);
}
public void inputPasswrd(String pswrd)
{
	//password.sendKeys(pswrd);
	exw.explicitwaitvisibility(driver, password,"admin");
}
public void clickOnRememeberMe()
{
	rememberMe.click();
}
public void clickONSigninButton()
{
	//exw.explicitWaitForButtonClick(driver, signIn);
	signIn.click();
}

public void inputInValidUserName(String usrname)
{
	uName.sendKeys(usrname);
}
public void inputInvalidPasswrd(String pswrd)
{
	password.sendKeys(pswrd);
}
public void invalidLogin()
{
	signIn.click();
}

public String getTextofAppHomePage()
{
	return gu.getElementText(home);
}

public String getTextofAlert()
{
	return gu.getElementText(alert);
}

public String getTextOfSignInButton()
{

	return gu.getElementText(signIn);
}


}
