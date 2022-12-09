package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementoryRepository.LoginpageRep;
import elementoryRepository.MobileSliderRep;

public class MobileSliderTestcases extends BaseClass
{
	LoginpageRep lpr;
	MobileSliderRep msr;

	
  @Test
  public void addMobileSlider() throws InterruptedException, AWTException
  {
	  lpr = new LoginpageRep(driver);
	  msr = new MobileSliderRep(driver);
	  lpr.inputUserName("admin");
	  lpr.inputPasswrd("admin");
	  lpr.clickONSigninButton();
	  msr.ClickOnMobileSlider();
	  msr.clickOnNewButton();
	  msr.clickOnCategoryDrpDwn();
	  msr.selectCategoryFromDropdown();
	  msr.upLoadFile();
	  msr.clickOnSaveButton();
  }
	  
	  
	  @Test
	  public void verifyTheCancelButtonInAddMobileSliderPage()
	  {
		  lpr = new LoginpageRep(driver);
		  msr = new MobileSliderRep(driver);
		  lpr.inputUserName("admin");
		  lpr.inputPasswrd("admin");
		  lpr.clickONSigninButton();
		  msr.ClickOnMobileSlider();
		  msr.clickOnNewButton();
		  msr.clickOnCancelButtonOAddMobileSlider();
		  
		  String actual = msr.verifyTheResetFunction();
		  String expect ="List Mobile Sliders";
		  Assert.assertEquals(actual, expect, Constant.errorMessage);
		  
	  }

  
}
