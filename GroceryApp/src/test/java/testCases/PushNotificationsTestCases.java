package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementoryRepository.LoginpageRep;
import elementoryRepository.PushNotificationsRep;

public class PushNotificationsTestCases extends BaseClass 
{
	LoginpageRep lpr;
	PushNotificationsRep pnr;
  @Test
  public void pushNotificationsInformations()
  {
	  lpr = new LoginpageRep(driver);
	  pnr = new PushNotificationsRep(driver);
	  
	  lpr.inputUserName("admin");
	  lpr.inputInvalidPasswrd("admin");
	  lpr.clickONSigninButton();
	  
	  pnr.clickOnPushNotificationPage();
	  pnr.inputTitle("B2G1 OFFER");
	  pnr.inputDiscription("Buy 2 ITC Product Get 1 FREE......");
	  pnr.clickOnSendButton();
	  
	  String actual = pnr.getAlertMessageText();
	  String expect = "×\n" + 
	  		"Alert!\n" + 
	  		"Message send successfully";
	  Assert.assertEquals(actual, expect, Constant.errorMessage);
  }
	  
	  @Test
	  public void verifyTheResetFunction()
	  {
		  lpr = new LoginpageRep(driver);
		  pnr = new PushNotificationsRep(driver);
		  
		  lpr.inputUserName("admin");
		  lpr.inputInvalidPasswrd("admin");
		  lpr.clickONSigninButton();
		  
		  pnr.clickOnPushNotificationPage();
		  
		 boolean actual= pnr.verifyTheResetFunctionOnPushNotificationPage();
		 boolean expect = false;
		 Assert.assertEquals(actual,expect, Constant.nullMessage);
		  
		 
		
		  
	  }
	  
	  
  
}
