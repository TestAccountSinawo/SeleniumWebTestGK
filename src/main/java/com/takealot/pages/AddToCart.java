package com.takealot.pages;

import com.takealot.base.BaseConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart extends BaseConfiguration {


    @FindBy(xpath = "//h1[contains(text(),'Auditing Notes For South African Students ')]")
    WebElement bookTitle;

    @FindBy(xpath = "//input[@type='submit' and @value='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//div[contains(text(),'Item added to your cart')]")
    WebElement itemAdded;


    public AddToCart(){

        PageFactory.initElements(driver,this);
    }

    public String addToCartTitle(){

        return driver.getTitle();
    }

    public String confirmTheBook(){

      return bookTitle.getText();
    }

    public boolean addToCart(){

        addToCartBtn.click();
        return itemAdded.isDisplayed();
    }







}
