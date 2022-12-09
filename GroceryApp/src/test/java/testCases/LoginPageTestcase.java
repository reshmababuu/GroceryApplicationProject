package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementoryRepository.LoginpageRep;
//import utilitieS.ExcelReadUtility;


public class LoginPageTestcase extends BaseClass 
{
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod()
	{
	return new Object[][] {{"abc","s789"},{"","h10987"}, {"qrs", ""}, {"", ""}};
	}
	
	 LoginpageRep lpr;
	
	
	 
	 
	@Test(groups= {"Medium"}, priority=3)
	public void validuserLogIn() throws IOException
	{
	  LoginpageRep lpr = new LoginpageRep(driver);
	
	    //lpr.browserLaunch();
	  
		//lpr.inputUserName(ExcelReadUtility.readStringData(0,0));
		//lpr.inputPasswrd(ExcelReadUtility.readStringData(0, 1));
	    lpr.inputUserName("admin");
	    lpr.inputPasswrd(null);
		lpr.clickOnRememeberMe();
		
		lpr.clickONSigninButton();
		
		String actual=lpr.getTextofAppHomePage();
		String expect = "Home";
		System.out.println(actual);
		Assert.assertEquals(actual, expect, Constant.invalidLoginErrorMsg);
	}
	
	@Test(dataProvider="data-provider", priority=4) 
	public void inValiduserLogin(String inValiduserName, String inValidPassword)
	{
		LoginpageRep lpr = new LoginpageRep(driver);
		lpr.inputInValidUserName(inValiduserName);
		lpr.inputInvalidPasswrd(inValidPassword);
		lpr.clickONSigninButton();

		String actual = lpr.getTextofAlert();
		String expect = "Sign in to start your session";
		Assert.assertEquals(actual, expect, Constant.invalidLoginErrorMsg);
	}
	

	
	
 @Test(groups= {"High"}, priority=1)
  public void verifyTextOnSignInPage() 
  {
	  LoginpageRep lpr = new LoginpageRep(driver);
	  String actual = lpr.getTextOfSignInButton();
	  String expected = "Sign In";
	  System.out.println(actual);
	  
	  
	  Assert.assertEquals(actual, expected, Constant.errormsgInvalidLogin);
  }
  }
