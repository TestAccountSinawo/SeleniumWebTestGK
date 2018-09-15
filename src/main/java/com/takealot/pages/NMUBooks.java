package com.takealot.pages;

import com.takealot.base.BaseConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class NMUBooks extends BaseConfiguration {


    @FindBy(xpath = "//a[contains(text(),'Auditing Notes For South African Students')]")
    WebElement selectBook;



    public NMUBooks() {

        PageFactory.initElements(driver, this);
    }

    public String getNMUBooksPageTitle(){

        return driver.getTitle();
    }

    //<This method returns the cart page>\\
    public AddToCart clickABook() {

        selectBook.click();

        return new AddToCart();

    }


}
