package testCases;



import org.testng.annotations.Test;

import elementoryRepository.LoginpageRep;
import elementoryRepository.ManageProductRep;

public class ManageProductTestcases extends BaseClass {
	LoginpageRep lrp;
	ManageProductRep mpr;
	
	@Test(groups="Low")
	public void addNewProduct() throws Throwable
	{
		lrp = new LoginpageRep(driver);
		mpr = new ManageProductRep(driver);
		lrp.inputUserName("admin");
		lrp.inputPasswrd("admin");
		lrp.clickONSigninButton();
		mpr.clickOnManageProductPage();
		mpr.clickOnNewBtn();
		mpr.inputTitleForNewProduct("AAshirvad Aatta");
		mpr.clickOnCategoryDropDwn();
		mpr.selectCategoryFromDropDwn();
		mpr.clickOnSubCategoryDropDwn();
		mpr.selectSubCategoryFromDrpDwn();
		mpr.clickOnPriceType();
		mpr.clickOnMinimumPieceDrpDwn();
		mpr.selectMinimumPieceFromDrpDwn();
		mpr.inputMaximumQtyToBeOrdered("50");
		mpr.inputPriceoftheProduct("63");
		mpr.inputMrpofTheproduct("63");
		mpr.inputAvailableStock("5");
		mpr.inputPurchasePrice("52");
		mpr.productImageUpload();
		mpr.clickOnSavebutton();
	}
		
		@Test(groups="High")
		public void searchProduct()
		{
			lrp = new LoginpageRep(driver);
			mpr = new ManageProductRep(driver);
			lrp.inputUserName("admin");
			lrp.inputPasswrd("admin");
			lrp.clickONSigninButton();
			mpr.clickOnManageProductPage();
			mpr.clickOnSerachButton();
			mpr.inputSerachedProductName("Yippee");
			mpr.clickOnproductSearchButton();
		}
		
		
	
	
 
}
