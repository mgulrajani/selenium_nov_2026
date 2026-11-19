package com.itm.listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.itm.base.BaseTest;
import com.itm.utils.ExtentManager;
import com.itm.utils.ScreenshotUtil;
public class ExtentListener implements ITestListener {

    private static ExtentReports extent =
            ExtentManager.getReport();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(
                        result.getMethod()
                              .getMethodName());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        BaseTest baseTest =
                (BaseTest) result.getInstance();

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        baseTest.getDriver(),
                        result.getName() , "_PASS");

        test.get().pass("Test Passed");

        try {

            test.get()
                    .addScreenCaptureFromPath(
                            screenshotPath);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        BaseTest baseTest =
                (BaseTest) result.getInstance();

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        baseTest.getDriver(),
                        result.getName() , "_FAIL");

        test.get().fail(result.getThrowable());

        try {

            test.get()
                    .addScreenCaptureFromPath(
                            screenshotPath);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}