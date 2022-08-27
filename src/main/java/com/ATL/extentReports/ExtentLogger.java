package com.ATL.extentReports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public final class ExtentLogger {

    private ExtentLogger(){}

    public static void pass(String message){
        ExtentManager.getTest().pass(message);
    }

    public static void fail(String message){
        ExtentManager.getTest().fail(message);
    }

    public static void info(String message){
        ExtentManager.getTest().info(message);
    }

    public static void logResponse(String message){
        ExtentManager.getTest().pass(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
    }
}
