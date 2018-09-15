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

public class AddToCartTest extends BaseConfiguration {


    LandingPage landingPage;
    AcademicBookPage academicBookPage;
    NMUBooks nmuBooks;
    AddToCart addToCart;


    public AddToCartTest() {


        super();
    }

    @BeforeMethod
    public void setUp() {

        initialization();
        landingPage = new LandingPage();
        academicBookPage = new AcademicBookPage();
        academicBookPage = landingPage.setAcademicLink();
        nmuBooks = new NMUBooks();
        nmuBooks = academicBookPage.goToNMUBooks();
        addToCart = new AddToCart();
        addToCart = nmuBooks.clickABook();

    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }


    @Test(priority = 1)
    public void confirmPageTitleTest() {

        String title = addToCart.addToCartTitle();

        Assert.assertEquals(title,"Auditing Notes For South African Students | Buy Online in South Africa | takealot.com","The Title does not Match");

    }

    @Test(priority = 2)
    public void selectBookConfirmationTest(){

        String book = addToCart.confirmTheBook();
        Assert.assertEquals(book,addToCart.confirmTheBook(),"The Title does not Match");
    }
    @Test(priority = 3)
    public void addToCartBtnTest(){
        addToCart.addToCart();


        boolean itemAddedText = addToCart.addToCart();
        Assert.assertEquals(itemAddedText,true,"Item not added");
    }

}
