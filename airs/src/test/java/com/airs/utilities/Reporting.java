package com.airs.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
		public ExtentHtmlReporter htmlReport;
		public ExtentReports extent;
		public ExtentTest logger;
		
		public void onStart(ITestContext testContest) {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String repName= "Test-Report" + timeStamp +".html";
		
			htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/" +repName);	
			htmlReport.loadXMLConfig(System.getProperty("user.dir")+"extent-config.xml");
		    System.out.println("htmlReport:" +htmlReport); 
			extent  = new ExtentReports();	
			extent.attachReporter(htmlReport);
			extent.setSystemInfo("Host Name","Localhost");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User", "K N RAI");
			
			htmlReport.config().setDocumentTitle("AIRS IBE");
			htmlReport.config().setReportName("Functional Test");
			htmlReport.config().setTheme(Theme.STANDARD);
			
		}

		public void onTestSuccess(ITestResult tr) {
			
			logger = extent.createTest(tr.getName());
			logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		}
		
		public void onTestFailure(ITestResult tr) {
			
			logger = extent.createTest(tr.getName());
			logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
			
			String screenShortPath =System.getProperty("user.dir")+"\\Screenshots\\" + tr.getName()+ ".png";
			
			File errFile =new File(screenShortPath);
			if (errFile.exists()) {
				try {
					logger.fail("Screenshort is below :" + logger.addScreenCaptureFromPath(screenShortPath));
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		

}
