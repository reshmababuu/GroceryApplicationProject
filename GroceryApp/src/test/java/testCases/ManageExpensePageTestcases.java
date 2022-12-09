package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementoryRepository.LoginpageRep;
import elementoryRepository.ManageExpensePageRep;
import utilitieS.GeneralUtilities;

public class ManageExpensePageTestcases extends BaseClass
{
	ManageExpensePageRep mepr;
	GeneralUtilities gu= new GeneralUtilities();
	LoginpageRep lpr;
  
	@Test
  public void addNewExpenseCategoryInManageExpense() throws InterruptedException 
  {
	mepr = new ManageExpensePageRep(driver);
	lpr= new LoginpageRep(driver);
	lpr.inputUserName("admin");
	lpr.inputPasswrd("admin");
	lpr.clickONSigninButton();
	mepr.clickOnmenuBar();
	gu.minimumWaitthread();
	mepr.clickOnManageExpense();
	mepr.clickOnExpensECategory();
	mepr.clickOnNewButton();
	mepr.inPutCategoryTitle("Spices");
	mepr.clickOnSaveButton();
	
	String actual = mepr.verifyTheAlertMessage();
	String expect =  "x Alert! Expense Category Created Successfully ";
	Assert.assertEquals(actual, expect, Constant.errorMessage);
  }
}
