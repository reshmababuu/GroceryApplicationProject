package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementoryRepository.LoginpageRep;
import elementoryRepository.ManageUsersRep;

public class ManageUsersTestcases extends BaseClass {
	ManageUsersRep mup;
	LoginpageRep lpr;

	@Test
	public void verifyInputedUserStatus()
	{
	    mup = new ManageUsersRep(driver);
		lpr = new LoginpageRep(driver);
		lpr.inputUserName("admin");
		lpr.inputPasswrd("admin");
		lpr.clickONSigninButton();
		mup.clickOnManageUsers();
		mup.clickOnSearchBtn();
		mup.inputSelectedUsersName("sree sree");
		mup.clickOnlastSearchBtn();
		
		String actual =mup.displayInputeduserStatus();
		System.out.println(actual);
		String expect = "Active";
		Assert.assertEquals(actual, expect, Constant.errorMessage);

	}
}
