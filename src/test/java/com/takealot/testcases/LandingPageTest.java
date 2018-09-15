package com.takealot.testcases;

import com.takealot.base.BaseConfiguration;
import com.takealot.pages.AcademicBookPage;
import com.takealot.pages.LandingPage;
import com.takealot.takealotextentreport.TakeAlotExtentReport;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LandingPageTest extends BaseConfiguration {

    LandingPage landingPage;
    AcademicBookPage academicBookPage;
    TakeAlotExtentReport takeAlotExtentReport;

    public LandingPageTest() {

        super();
    }

    @BeforeMethod
    public void setUp() {

        initialization();
        landingPage = new LandingPage();
        academicBookPage = new AcademicBookPage();
        takeAlotExtentReport = new TakeAlotExtentReport();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        driver.quit();
    }

    @Test(priority = 1)
    public void setLandingPageTest() {
        String title = landingPage.landingPageTitle();
        Assert.assertEquals(title, "Takealot.com: Online Shopping | SA's leading online store", "Title not matched");

    }

    @Test(priority = 2)
    public void moveToAcademicBookPageTest() {

        academicBookPage = landingPage.setAcademicLink();


    }

}
