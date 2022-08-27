package com.ATL.extentReports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager(){}

    private static ThreadLocal<ExtentTest> extest = new ThreadLocal<>();

    static ExtentTest getTest(){
        return extest.get();
    }

    static void setExtest(ExtentTest test){
        extest.set(test);
    }
}
