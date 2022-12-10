package utilitieS;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotCapture {
	public void captureFailureScreenShot(WebDriver driver, String name) throws IOException {
		   //Interface & method for Capture Screenshot 
		// interface      refname= objectn creation for interface
		   TakesScreenshot scrShot =(TakesScreenshot)driver;
		   File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//screenshot will store in temporary path
		   

		  
		   File f1=new File(System.getProperty("user.dir")+"\\OutputScreenshots");//Generating folder using Java
		   // checks if the file exist
		   if (!f1.exists()){
		      f1.mkdirs();// mkdir - java command --> will create folder using java
		  }
		   //    string   variable            date class
		   
		   String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//date time capture using java
		   
		   //                             to get    project folder                                 format of the screenshot
		   File finalDestination=new File(System.getProperty("user.dir")+ "\\OutputScreenshots\\" + name + "_" + timeStamp + ".png");
		   FileHandler.copy(screenShot, finalDestination);//copy screenshot from temp path to project folder
		   //selenium class , static method
		  }


}
