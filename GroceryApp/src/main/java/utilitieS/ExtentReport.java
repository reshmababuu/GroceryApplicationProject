package utilitieS;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//seperate library

public  class ExtentReport implements ITestListener{
	ExtentSparkReporter sparkReporter; //3 classes
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
	Date date = new Date(); //system date and tym
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_hhmmss");
	String strDate = formatter.format(date); // get current date and tym

	File reportPath=new File(System.getProperty("user.dir")+"//ExtentReport");

	if(!reportPath.exists()) {    //create report folder
	reportPath.mkdir();
	}

	//create file - obj for sparkReporter
	sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//ExtentReport//"+"ExtentReport_" + strDate + ".html");
	reports = new ExtentReports();
	reports.attachReporter(sparkReporter);

	//System details
	reports.setSystemInfo("PC Name", "Reshma");
	reports.setSystemInfo("OS", "Windows 10");
	sparkReporter.config().setDocumentTitle("Extent Report Sample"); // title of report
	sparkReporter.config().setReportName("Report Summary"); //summary
	sparkReporter.config().setTheme(Theme.DARK); //theme of the report
	}
	
	public void onTestStart(ITestResult result) { //implmnt the listener using monitor the events
		

	}

	//if test is pass
	public void onTestSuccess(ITestResult result) {
	test = reports.createTest(result.getName());
	test.log(Status.PASS,
	MarkupHelper.createLabel("Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN));

	}

    //fail
	public void onTestFailure(ITestResult result) {
	test = reports.createTest(result.getName());
	test.log(Status.FAIL,
	MarkupHelper.createLabel("Name of the Failed Test Case is : " + result.getName(), ExtentColor.RED));

	}

	//skip
	public void onTestSkipped(ITestResult result) {
	test = reports.createTest(result.getName());
	test.log(Status.SKIP,
	MarkupHelper.createLabel("Name of the skipped test case is : " + result.getName(), ExtentColor.YELLOW));

	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	
	public void onStart(ITestContext context) { //startts the method 
	configureReport();
	}

	
	public void onFinish(ITestContext context) { //after complete execution, push all the content to the html
	reports.flush();
	}



}
