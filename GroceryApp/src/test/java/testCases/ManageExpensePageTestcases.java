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
	//GeneralUtilities gu= new GeneralUtilities();
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
	//gu.minimumWaitthread();
	mepr.clickOnManageExpense();
	mepr.clickOnExpensECategory();
	mepr.clickOnNewButton();
	mepr.inPutCategoryTitle("Spices");
	mepr.clickOnSaveButton();
	
	String actual = mepr.verifyTheAlertMessage();
	String expect =  "x Alert! Expense Category Created Successfully ";
	Assert.assertEquals(actual, expect, Constant.errorMessage);
  }
	//search an item 
	
	@Test
	public void searchAnItemInExpenseCategory() throws InterruptedException
	{
		mepr = new ManageExpensePageRep(driver);
		lpr= new LoginpageRep(driver);
		lpr.inputUserName("admin");
		lpr.inputPasswrd("admin");
		lpr.clickONSigninButton();
		mepr.clickOnmenuBar();
		mepr.clickOnManageExpense();
		mepr.clickOnExpensECategory();
		mepr.clickOnSearchButton();
		mepr.inputTitle("Spices");
		
		String actual =mepr.clickOnSearchButtoninSearchExpenseCategory();
		String expected ="Spices";
		Assert.assertEquals(actual, expected, Constant.errorMessage);
	}
	// delete an category
	@Test
	public void deleteAnExpenseCategory() throws InterruptedException 
	{
		mepr = new ManageExpensePageRep(driver);
		lpr= new LoginpageRep(driver);
		lpr.inputUserName("admin");
		lpr.inputPasswrd("admin");
		lpr.clickONSigninButton();
		mepr.clickOnmenuBar();
		mepr.clickOnManageExpense();
		mepr.clickOnExpensECategory();
		mepr.clickOnSearchButton();
		mepr.inputTitle("Cashew70");
		mepr.deleteAnExpenseCategory();
		
		String actual = mepr.verifyTheAlertMessageofDeletion();
		String expected ="×\n" + 
				"Alert!\n" + 
				"Expense Category Deleted Successfully";
		
		Assert.assertEquals(actual, expected, Constant.errorMessage);
		
	}
	
	//edit an Expense category
	@Test
	public void editAnExpenseCategory() throws InterruptedException
	{
		mepr = new ManageExpensePageRep(driver);
		lpr= new LoginpageRep(driver);
		lpr.inputUserName("admin");
		lpr.inputPasswrd("admin");
		lpr.clickONSigninButton();
		mepr.clickOnmenuBar();
		mepr.clickOnManageExpense();
		mepr.clickOnExpensECategory();
		mepr.clickOnSearchButton();
		mepr.inputTitle("Orginal Kera Powder");
		mepr.clickOnSearchButtoninSearchExpenseCategory();
		mepr.editAnExpenseCategory("Coconut Powder");
		
		String actual = mepr.getTextOfAlertMsgOdUpdation();
		String expected = "×\n" + 
				"Alert!\n" + 
				"Category Updated Successfully";
		Assert.assertEquals(actual, expected, Constant.errorMessage);
	}
}
