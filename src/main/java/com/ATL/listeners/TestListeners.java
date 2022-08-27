package com.ATL.listeners;

import com.ATL.annotations.FrameworkAnnotations;
import com.ATL.extentReports.ExtentLogger;
import com.ATL.extentReports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ISuiteListener, ITestListener {


@Override
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.tearDown();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
        String[] authors = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).Author();
        ExtentReport.addAuthor(authors);

        String[] categories = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).Category();
        ExtentReport.addAuthor(categories);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(String.valueOf(result.getThrowable()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(String.valueOf(result.getThrowable()));
    }

//    public void onTestSkipped(ITestResult result) {
//
//    }
}
