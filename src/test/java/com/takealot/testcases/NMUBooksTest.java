package com.takealot.testcases;

import com.takealot.base.BaseConfiguration;
import com.takealot.pages.AcademicBookPage;
import com.takealot.pages.AddToCart;
import com.takealot.pages.LandingPage;
import com.takealot.pages.NMUBooks;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NMUBooksTest extends BaseConfiguration {

    LandingPage landingPage;
    AcademicBookPage academicBookPage;
    NMUBooks nmuBooksPage;
    AddToCart addToCart;


    public NMUBooksTest() {

        super();
    }

    @BeforeMethod
    public void setUp() {

        initialization();
        landingPage = new LandingPage();
        academicBookPage = new AcademicBookPage();
        academicBookPage = landingPage.setAcademicLink();
        nmuBooksPage = academicBookPage.goToNMUBooks();
        nmuBooksPage = new NMUBooks();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void NMUBooksPageTitle() {
        String titleText = nmuBooksPage.getNMUBooksPageTitle();
        Assert.assertEquals(titleText, "NMU Books | Academic Books | Buy online at takealot.com(123Fail)", "Title not Matched");
    }

    @Test(priority = 2)
    public void selectBook() {

        addToCart = nmuBooksPage.clickABook();

    }
}
