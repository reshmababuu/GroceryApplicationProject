package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementoryRepository.LoginpageRep;
import elementoryRepository.ManageOrderPageRep;

public class ManageOrderPagetestCases extends BaseClass {
	LoginpageRep lpr;
	ManageOrderPageRep mopr;

	@Test
	public void verifySelectedValueInTheDropDown() 
	{
		lpr = new LoginpageRep(driver);
		mopr = new ManageOrderPageRep(driver);
		lpr.inputUserName("admin");
		lpr.inputPasswrd("admin");
		lpr.clickONSigninButton();
	
		
			
		mopr.clickOnManagerOrderpage();
		
		mopr.clickONSearchBtnInManagerOrderPage();
		
		mopr.clickOnPaymentMode();
			
		mopr.getTheSeletedValueOnDropdownList();

		String actual = mopr.getTheSeletedValueOnDropdownList();
		System.out.println(actual);
		String expect = "COD";

		Assert.assertEquals(actual, expect, "not same");
		}

	}


