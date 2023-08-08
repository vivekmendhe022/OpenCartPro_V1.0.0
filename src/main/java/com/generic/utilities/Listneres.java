package com.generic.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listneres implements ITestListener {

	ExtentReports r;
	ExtentTest t;

	@Override
	public void onTestStart(ITestResult result) {
		String m = result.getMethod().getMethodName();
		System.out.println(m + " Test Execution Start");
		t = r.createTest(m);
		t.log(Status.INFO, m + " : Execution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String m = result.getMethod().getMethodName();
		System.out.println(m + " Test Execution Success");
		t.log(Status.PASS, m + " : Test Script Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String m = result.getMethod().getMethodName();
		System.out.println(m + " Test Execution Fail");
		System.out.println(result.getThrowable());
		t.log(Status.FAIL, m + " : Test Script Fail");
		t.log(Status.SKIP, result.getThrowable());

		// Take Screen Shot
		String src = m + "-" + new JavaUtility().getSystemDateInFormate();
		WebDriverUtility wutil = new WebDriverUtility();
		try {
			String path = wutil.takeScreenShot(BaseClass.SDriver, src);
			t.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String m = result.getMethod().getMethodName();
		System.out.println(m + " Test Execution Skipped");
		System.out.println(result.getThrowable());
		t.log(Status.SKIP, m + " : Test Script Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Execution Start");
		// Configure ExtentSparkReporter
		String path = ".\\ExtentReport\\Report-" + new JavaUtility().getSystemDateInFormate();
		ExtentSparkReporter html = new ExtentSparkReporter(path);
		html.config().setDocumentTitle("Open Cart Pro Execution Reprot");
		html.config().setReportName("Execution Report");
		html.config().setTheme(Theme.DARK);

		// Configure
		r = new ExtentReports();
		r.attachReporter(html);
		r.setSystemInfo("Base Browser", "chrome");
		r.setSystemInfo("Base URL", "http://localhost:8888");
		r.setSystemInfo("Base Paltform", "Windows 11");
		r.setSystemInfo("Reporter Name", "Vivek");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Execution Finshed");
		r.flush();
	}

}
