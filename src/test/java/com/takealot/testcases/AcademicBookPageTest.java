package com.takealot.testcases;

import com.takealot.base.BaseConfiguration;
import com.takealot.pages.AcademicBookPage;
import com.takealot.pages.LandingPage;
import com.takealot.pages.NMUBooks;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AcademicBookPageTest extends BaseConfiguration {

    LandingPage landingPage;
    AcademicBookPage academicBookPage;
    NMUBooks nmuBooks;

    public AcademicBookPageTest() {

        super();
    }

    @BeforeMethod
    public void setUp() {

        initialization();
        landingPage = new LandingPage();
        academicBookPage = new AcademicBookPage();
        academicBookPage = landingPage.setAcademicLink();
        nmuBooks = new NMUBooks();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void academicBookPageTitleTest() {

        String bookPageTitle = academicBookPage.getAcademicBooksTitle();
        Assert.assertEquals(bookPageTitle, "Buy Academic Books Online: UNISA & University Textbooks | takealot.com", "The Title does not Match");

    }

    @Test(priority = 2)
    public void academicBookPageTest() {

        boolean confirmText = academicBookPage.confirmAcademicBookLandingText();
        Assert.assertEquals(true, confirmText, "Academic Books");

    }

    @Test(priority = 3)
    public void goToNMUBooksTest() {

        nmuBooks = academicBookPage.goToNMUBooks();
    }
}
