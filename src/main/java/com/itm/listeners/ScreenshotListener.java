package com.itm.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.itm.base.BaseTest;
import com.itm.utils.ScreenshotUtil;


public class ScreenshotListener
        implements ITestListener {

    @Override
    public void onTestSuccess(
            ITestResult result) {

        BaseTest test =
                (BaseTest)
                result.getInstance();

        ScreenshotUtil.captureScreenshot(
                test.getDriver(),
                result.getName(),
                "PASS");

        System.out.println(
                "Success Screenshot Taken");
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        BaseTest test =
                (BaseTest)
                result.getInstance();

        ScreenshotUtil.captureScreenshot(
                test.getDriver(),
                result.getName(),
                "FAIL");

        System.out.println(
                "Failure Screenshot Taken");
    }
}