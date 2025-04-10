package com.ttc.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

	 private static ExtentReports extent;
	    private static ExtentTest test ;

	    public static void startReport() {
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("ExtentReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	    }

	    public static void createTest(String testName) {
	        test = extent.createTest(testName);
	    }

	    public static void success(String message) { 	
	            test.log(Status.PASS, message);
	    }
	    
	    public static void failure(String message) {	
	    		test.log(Status.FAIL, message);   
	    	
	    }
	    
	    public static void information(String message) {
	    	test.log(Status.FAIL, message); 
	    }
	    
	    public static void log(String message) {
	        System.out.println("[INFO] " + message);
	        // or extend to log into ExtentReports or another framework
	    }
	       

	    public static void endReport() {
	        extent.flush();
	    }

}
