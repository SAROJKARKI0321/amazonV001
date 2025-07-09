package Utilities;

import Tests.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager implements ITestListener {
    public ExtentReports extentReports;
    public ExtentSparkReporter sparkReporter;
    public ExtentTest test;
    String reportName;
    String pathofExtentReport;

    @Override
    public void onStart(ITestContext context) {
        String timestamp=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        reportName= "Test-Report"+ timestamp +".html";
        pathofExtentReport=System.getProperty("user.dir")+".\\reports\\"+ reportName;
        sparkReporter=new ExtentSparkReporter(pathofExtentReport);

        sparkReporter.config().setDocumentTitle("Amazon Automaton project");
        sparkReporter.config().setReportName("Aamazon E2E Test");
        sparkReporter.config().setTheme(Theme.DARK);

        extentReports=new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Application","Amazon webapplication");
        extentReports.setSystemInfo("user","Acer");
        extentReports.setSystemInfo("Environment","QA");

    }


    @Override
    public void onTestStart(ITestResult result) {





    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test=extentReports.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS,result.getName()+"got sucessfully executed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test=extentReports.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL,result.getName()+"failed!!!");
        test.log(Status.FAIL,result.getThrowable().getMessage());
        WebDriver driver=(WebDriver) result.getTestContext().getAttribute("driver");
        try{
           BaseTest baseTest=new BaseTest(driver);
           String imgpath= baseTest.captureScreenshot(result.getName());
            test.addScreenCaptureFromPath(imgpath);
        }catch (Exception e){
            System.out.println(e.getMessage());


        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
       test=extentReports.createTest(result.getTestClass().getName());
       test.assignCategory(result.getMethod().getGroups());
       test.log(Status.SKIP, result.getName()+"Skipeped");
       test.log(Status.INFO,result.getThrowable().getMessage());

    }


    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        File extentReport=new File(pathofExtentReport);
        try {
            Desktop.getDesktop().browse(extentReport.toURI());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
