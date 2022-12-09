package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementoryRepository.LoginpageRep;
import elementoryRepository.ManagePagesRep;

public class ManagePageTestCases extends BaseClass{
	LoginpageRep lpr;
	ManagePagesRep mpr;
	
	@Test
	  public void getTableForInputTitle()
	  {
		 lpr = new LoginpageRep(driver);

		  lpr.inputUserName("admin");
		  lpr.inputPasswrd("admin");
		  lpr.clickONSigninButton();
		   mpr = new ManagePagesRep(driver);
		   mpr.clickOnManagePages();
			  mpr.clickONSearchButtonInManagePages();
			  mpr.inputTitle("Pasta");
			  mpr.clickOnSerchFinalButton();
			  mpr.getTheSearchedValue();
			  
			  String actual = mpr.getTheSearchedValue();
			  String expect ="Pasjcdjchd...";
			  System.out.println(actual);
			  Assert.assertEquals(actual, expect, Constant.errorMessage);
  
}
}
