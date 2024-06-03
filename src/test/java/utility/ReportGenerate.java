package utility;

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

import testcases.BaseClass;

public class ReportGenerate implements ITestListener {
	
	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/ShareCar.html");
		
		reporter.config().setDocumentTitle("Share car Project Report");
		reporter.config().setReportName("Automation Script");
		reporter.config().setTheme(Theme.STANDARD);
		
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("User", "Subash");
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
		String imgpath = new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgpath, result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		String imgpath = new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgpath, result.getName());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}
	
	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
	
}
