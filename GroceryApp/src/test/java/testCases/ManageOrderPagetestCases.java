package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementoryRepository.LoginpageRep;
import elementoryRepository.ManageOrderPageRep;

public class ManageOrderPagetestCases extends BaseClass {
	LoginpageRep lpr;
	ManageOrderPageRep mopr;

	@Test
	public void verifyTheBankPaymentModeUsers() 
	{
		lpr = new LoginpageRep(driver);
		mopr = new ManageOrderPageRep(driver);
		lpr.inputUserName("admin");
		lpr.inputPasswrd("admin");
		lpr.clickONSigninButton();
	
		
			
		mopr.clickOnManagerOrderpage();
		mopr.clickONSearchBtnInManagerOrderPage();
		mopr.inputOrderIdOnSearchListOrdersPage("369");
		mopr.clickOnSearchButtonISearchListOrdersPage();
		mopr.clickOnViewButton();
		String actual = mopr.getTextOfOrderDetailspage();
		String expected = "Order Details";
		
		Assert.assertEquals(actual, expected, Constant.errorMessage);
		
		

		
		
	
	
		


	}
}


