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
	  mocp.getOfferPercentage();
	  
	 
	 String actual =mocp.verifyThepercentageSame();
	 String expect ="30%";
	 System.out.println(actual);
	 Assert.assertEquals(actual, expect,Constant.errorMessage );

}
}
