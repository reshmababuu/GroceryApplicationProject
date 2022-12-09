package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementoryRepository.ManageUsersRep;

public class ManageUsersTestcases extends BaseClass {
	ManageUsersRep mup;

	@Test
	public void verifyInputedUserStatus()
	{
	    mup = new ManageUsersRep(driver);
		mup.inputUserName("admin");
		mup.inputPasswrd("admin");
		mup.clickONSigninButton();
		mup.clickOnManageUsers();
		mup.clickOnSearchBtn();
		mup.inputSelectedUsersName("sree sree");
		mup.clickOnlastSearchBtn();
		mup.displayInputeduserStatus();
		
		String actual = mup.verifyThetextOfStatus();
		String expect = "Active";
		Assert.assertEquals(actual, expect, Constant.errorMessage);

	}
}
