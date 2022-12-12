package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementoryRepository.LoginpageRep;
import elementoryRepository.ManagerofferCodepageRep;

public class ManagerOfferCodeTestcases extends BaseClass
{
	ManagerofferCodepageRep mocp;
	LoginpageRep lpr;
	
  @Test
  public void getPercentageOfOfferCode() throws InterruptedException 
  {
	  lpr = new LoginpageRep(driver);
	  mocp = new ManagerofferCodepageRep(driver);
	  lpr.inputUserName("admin");
	  lpr.inputPasswrd("admin");
	  lpr.clickONSigninButton();
	  mocp.clickOnManagerOfferCodepage();
	  mocp.clickOnSearchButton();
	  
	  String actual=  mocp.getOfferPercentage("500_14_11_2022_11_44_48");
	  System.out.println(actual);
	  String expected = "85%";
	  Assert.assertEquals(actual, expected,Constant.errorMessage );
  }
  
  //reset page
  @Test
  public void verifyTheResetFunction()
  {
	  lpr = new LoginpageRep(driver);
	  mocp = new ManagerofferCodepageRep(driver);
	  lpr.inputUserName("admin");
	  lpr.inputPasswrd("admin");
	  lpr.clickONSigninButton();
	  mocp.clickOnManagerOfferCodepage();
	  mocp.clickOnSearchButton();
	  
	  String actual = mocp.resetFunctionOfTheManageOfferCodePage();
	  String expected = "List Offercodes";
	  Assert.assertEquals(actual, expected, Constant.errorMessage);
	  
  }
	



}
