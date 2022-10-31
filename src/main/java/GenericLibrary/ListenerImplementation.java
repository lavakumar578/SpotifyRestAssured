package GenericLibrary;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
@Listeners
public class ListenerImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	public void onStart(ITestContext context) {
		System.out.println("onStart"+Thread.currentThread().getId());
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentReport.html");
		spark.config().setDocumentTitle("DocumentTitle");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("ReportName");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("Reporter Name", "Lava Kumar");
		report.setSystemInfo("platform", "Windows 10");
		report.setSystemInfo("Unit Testing Tool", "TestNG");
		report.setSystemInfo("Build Management Tool", "Maven");
		report.setSystemInfo("Automation Tool", "Selenium");
		
	}

	public void onTestStart(ITestResult result) {
	System.out.println("onTestStart");	
	test = report.createTest(result.getMethod().getMethodName());
		
	}


	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		test.log(Status.PASS,result.getMethod().getMethodName()+"is pass");
	}


	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		test.log(Status.FAIL,result.getMethod().getMethodName()+"is failed");
		test.log(Status.FAIL,result.getThrowable());
			

				
	}


	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");	
		test.log(Status.SKIP,result.getMethod().getMethodName()+"is skipped");
		test.log(Status.SKIP,result.getThrowable());
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	

	
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
		report.flush();
		
	}

	
}
