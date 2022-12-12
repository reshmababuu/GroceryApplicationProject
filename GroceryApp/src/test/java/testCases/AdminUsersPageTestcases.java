package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementoryRepository.AdminUsersPage;
import elementoryRepository.LoginpageRep;

public class AdminUsersPageTestcases extends BaseClass {
 
  AdminUsersPage aup;
	LoginpageRep lpr;
	// add new admin
	@Test(groups= {"High"}, priority=1)
	  public void addnewAdminInAdminPage() 
	  {
		  lpr = new LoginpageRep(driver);
		  aup = new AdminUsersPage(driver);
		  lpr.inputUserName("admin");
		  lpr.inputPasswrd("admin");
		  lpr.clickONSigninButton();
		  aup.clickOnAdminPage();
		  aup.clicKOnNewButtoN();
		  aup.inPutUserNameforAdmin("admin@resh246");
		  aup.inputPasswordfoRadmin("password@admin12");
		  aup.clickOnUserType();
		  aup.selectTheuserType();
		  aup.clickOnSaveButton();
		  
		  String actual = aup.getAlertMessage();
		  System.out.println(actual);
		  
		  
	  }
	  //delete an admin
	  @Test(groups= {"Medium"}, priority=2)
	  public void selectedAdmindeletion()
	  {
		  lpr = new LoginpageRep(driver);
		  aup =new AdminUsersPage(driver);
		  lpr.inputUserName("admin");
		  lpr.inputPasswrd("admin");
		  lpr.clickONSigninButton();
		  aup.clickOnAdminPage();
		  aup.clickOnSerachButton();
		  aup.inputsearchedAdminUserName(null);
		  aup.getUserTypeofSearchedAdmin();
		  aup.clickOnFinalSearchButton();
		  aup.deleteSearchedadmin();
		  
		  String actual = aup.verifyThedeletedAlert();
		  System.out.println(actual);
	  }
		//reset page  
		  @Test(groups= {"High"}, priority=1)
		  public void reSetThePage()
		  {
			  lpr = new LoginpageRep(driver);
			  aup = new AdminUsersPage(driver);
			  lpr.inputUserName("admin");
			  lpr.inputPasswrd("admin");
			  lpr.clickONSigninButton();
			  aup.clickOnAdminPage();
			  aup.clicKOnNewButtoN();
			  aup.inPutUserNameforAdmin("tempAdmin");
			  aup.clickOnResetButton();
			  
			  String actual =aup.verifyTheResetadminPage();
			  String expect ="Admin Users";
			  Assert.assertEquals(actual, expect, Constant.errorMessage);
					  
			  
		  }
		  
  
  

}
