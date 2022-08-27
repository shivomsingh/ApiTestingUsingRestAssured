package com.ATL.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.lang.reflect.Method;

public final class ExtentReport {

    private ExtentReport(){}
    private static ExtentReports extent;
    private static  ExtentTest test;

    public static void initReport(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/index.html");
        extent.attachReporter(spark);
    }

    public static void createTest(String nameOfMethod){
        test = extent.createTest(nameOfMethod);
        ExtentManager.setExtest(test);
    }

    public static void tearDown(){
        extent.flush();
    }



}
