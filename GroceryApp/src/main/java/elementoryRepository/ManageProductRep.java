package elementoryRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitieS.ExplictWait;
import utilitieS.GeneralUtilities;

public class ManageProductRep 
{
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplictWait exw = new ExplictWait();
	public ManageProductRep(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[text()='Manage Product']")
	WebElement manageProduct;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement titleBox;
	
	@FindBy(xpath="//select[@id='cat_id']")
	WebElement category;
	
	@FindBy(xpath="//select[@id='sub_id']")
	WebElement subCategory;
	
	@FindBy(xpath="//input[@id='purpose1']")
	WebElement priceType;
	
	@FindBy(xpath="//select[@id='p_minimum']")
	WebElement minQty;
	
	@FindBy(xpath="//input[@id='p_max']")
	WebElement qtyMaximum;
	
	@FindBy(xpath="//input[@id='p_price']")
	WebElement price;
	
	@FindBy(xpath="//input[@id='p_mrp']")
	WebElement mrP;
	
	@FindBy(xpath="//input[@id='p_stock']")
	WebElement stockQty;
	
	@FindBy(xpath="//input[@id='p_pp']")
	WebElement purchasePrice;
	
	@FindBy(xpath="//input[@id='main_img']")
	WebElement imageUpLoad;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement ProCreateAlertMsg;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;
	
	@FindBy(xpath="(//input[@class='form-control'])[1]")
	WebElement searchedProTitle;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement proSearchBtn;
	
	public void clickOnManageProductPage()
	{
		manageProduct.click();
	}
	public void clickOnNewBtn()
	{
		newBtn.click();
	}
	public void inputTitleForNewProduct(String proName)
	{
		titleBox.sendKeys(proName);
	}
	public void clickOnCategoryDropDwn()
	{
		category.click();
	}
	public String selectCategoryFromDropDwn()
	{
		return gu.selectedValueFromDropDown(category, "3");
	}
	public void clickOnSubCategoryDropDwn()
	{
		subCategory.click();
	}
	public String selectSubCategoryFromDrpDwn()
	{
		return gu.selectedValueFromDropDown(subCategory, "14");
	}
	public void clickOnPriceType()
	{
		priceType.click();
	}
	public void clickOnMinimumPieceDrpDwn()
	{
		minQty.click();
		
	}
	public String selectMinimumPieceFromDrpDwn()
	{
		return gu.selectedValueFromDropDown(minQty, "20,pc");
		
	}
	public void inputMaximumQtyToBeOrdered(String no)
	{
		qtyMaximum.sendKeys(no);
		
	}
	public void inputPriceoftheProduct(String rupees)
	{
		price.sendKeys(rupees);
		
	}
	public void inputMrpofTheproduct(String mrp)
	{
		mrP.sendKeys(mrp);
		
	}
	public void inputAvailableStock(String stockqty)
	{
		stockQty.sendKeys(stockqty);
	}
	public void inputPurchasePrice(String pPrice)
	{
		purchasePrice.sendKeys(pPrice);
		
		
		
	}
	
	public void productImageUpload() throws AWTException, InterruptedException
	{
		gu.pageScroll(driver);
		
		gu.minimumWaitthread();
		
		gu.upLoadFiles(driver,imageUpLoad,System.getProperty("user.dir")+"\\src\\test\\resources\\UploadFile\\aata.jfif");
		
		
		
	
	}
	public void clickOnSavebutton() throws InterruptedException 
	{
		
		
		gu.minimumWaitthread();
		gu.javaScriptClick(saveBtn, driver);
		
	}
	
	public void clickOnSerachButton()
	{
		searchBtn.click();
	}
	public void inputSerachedProductName(String searchedProName)
	{
		searchedProTitle.sendKeys(searchedProName);
	}
	public void clickOnproductSearchButton()
	{
		proSearchBtn.click();
		gu.pageScroll(driver);
	}

}
