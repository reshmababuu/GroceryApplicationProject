package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementoryRepository.LoginpageRep;
import elementoryRepository.ManagePagesRep;

public class ManagePageTestCases extends BaseClass{
	LoginpageRep lpr;
	ManagePagesRep mpr;
	
	//Search
	//@Test
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
			  String expect ="Page 23";
			  System.out.println(actual);
			  Assert.assertEquals(actual, expect, Constant.errorMessage);
  
}
	//Add New page
	//@Test
	public void addNewPageOnManagePages() throws AWTException, InterruptedException
	{
		  lpr = new LoginpageRep(driver);
		  mpr = new ManagePagesRep(driver);

		  lpr.inputUserName("admin");
		  lpr.inputPasswrd("admin");
		  lpr.clickONSigninButton();
		 
		  mpr.clickOnManagePages();
		  mpr.clickOnNewButton();
		  mpr.inputTitleandDescriptionOnAddpages("Vegetable Noodles", "AAtta Vegetable noodles is good for Health.....");
		  mpr.inputPageNumber("21");
		  mpr.clickOnUploadButton();
		  mpr.clickOnSaveButton();
		  
//		  String actual= mpr.getTextOfAlertSuccess();
//		  String expect ="\n" + 
//		  		"            Page Created Successfully        ";
//		  Assert.assertEquals(actual, expect, Constant.errorMessage);
	}
	
	//Reset function in the search list page
	@Test
	public void verifyTheResetFunctionInsearchListpages()
	{
		lpr = new LoginpageRep(driver);
		  mpr = new ManagePagesRep(driver);

		  lpr.inputUserName("admin");
		  lpr.inputPasswrd("admin");
		  lpr.clickONSigninButton();
		 
		  mpr.clickOnManagePages();
		  mpr.clickONSearchButtonInManagePages();
		
		  
		  String actual = mpr.getTextofResetpage();
		  String expected = "List Pages";
		  Assert.assertEquals(actual, expected, Constant.errorMessage);
	}
}
