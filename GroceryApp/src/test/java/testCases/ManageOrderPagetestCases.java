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
	public void viewTheOrderDetailsWithOrderId() 
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
	//delete an order 
	
	@Test
	public void deleteAnOrderWithOrderID()
	{
		lpr = new LoginpageRep(driver);
		mopr = new ManageOrderPageRep(driver);
		lpr.inputUserName("admin");
		lpr.inputPasswrd("admin");
		lpr.clickONSigninButton();
	
		
			
		mopr.clickOnManagerOrderpage();
		mopr.clickONSearchBtnInManagerOrderPage();
		mopr.inputOrderIdOnSearchListOrdersPage("377");
		mopr.clickOnSearchButtonISearchListOrdersPage();
		mopr.clickOnDeleteButton();
	}
	
	//search orders in a particular date period
	@Test
	public void selectOrdersWithAParticularPeriod()
	{
		lpr = new LoginpageRep(driver);
		mopr = new ManageOrderPageRep(driver);
		lpr.inputUserName("admin");
		lpr.inputPasswrd("admin");
		lpr.clickONSigninButton();
	
		
			
		mopr.clickOnManagerOrderpage();
		mopr.clickONSearchBtnInManagerOrderPage();
		mopr.inputStartDate("12/01/2022");
		mopr.inputEndDate("12/11/2022");
		mopr.clickOnSearchButtonISearchListOrdersPage();
		mopr.printTheOrderIdOFAParticularDatePeriod();
	}
		
	//Reset the search page
	@Test
	public void verifyTheResetFunctionInTheSearchOrderPage()
	{
		lpr = new LoginpageRep(driver);
		mopr = new ManageOrderPageRep(driver);
		lpr.inputUserName("admin");
		lpr.inputPasswrd("admin");
		lpr.clickONSigninButton();
	
		mopr.clickOnManagerOrderpage();
		mopr.clickONSearchBtnInManagerOrderPage();
		mopr.clickOnResetBtnThesearchPage();
		
		String actual = mopr.getTheTextOnListOrderPage();
		String expected = "List Orders(20)";
		Assert.assertEquals(actual, expected, Constant.errorMessage);
	}
		

		
		
	
	
		


	
}


