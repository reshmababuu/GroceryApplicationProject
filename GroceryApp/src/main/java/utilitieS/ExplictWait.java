package utilitieS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplictWait {
  WebDriver driver;
	
public void explicitWaitForButtonClick(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}

public void explicitWaitForpresenceofelementlocated(WebDriver driver,By locator)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60) );
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	
}
public void explicitwaitvisibility(WebDriver driver,WebElement element, String value )

{

WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
wait.until(ExpectedConditions.visibilityOf(element));
element.sendKeys(value);
	
}
}

	

	

	


