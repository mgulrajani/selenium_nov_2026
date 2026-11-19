package com.itm.utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "reports/ExtentReport.html");

            spark.config()
                 .setReportName("SauceDemo Automation");

            spark.config()
                 .setDocumentTitle(
                         "Automation Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo(
                    "Tester",
                    "Muskaan");

            extent.setSystemInfo(
                    "Environment",
                    "QA");
        }

        return extent;
    }
}