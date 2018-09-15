package com.takealot.pages;

import com.takealot.base.BaseConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BaseConfiguration {


    @FindBy(xpath = "//a[@title='Login']")
    WebElement loginBtn;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signInBtn;

    @FindBy(linkText = "Academic")
    WebElement academicLink;

    @FindBy(linkText = "Books")
    WebElement booksLink;

    public LandingPage() {

        PageFactory.initElements(driver, this);
    }

    public String landingPageTitle() {

        return driver.getTitle();
    }

 /*   //<For security reasons the signin test will not be executed>//
    public void setLoginBtn(String username, String pswd) {

        loginBtn.click();
        email.sendKeys(username);
        password.sendKeys(pswd);
        signInBtn.click();

        //<This should return HomePage if correct credentials are used.>//
    }*/

    public AcademicBookPage setAcademicLink() {

        Actions mouseHover = new Actions(driver);

        mouseHover.moveToElement(booksLink).moveToElement(academicLink).build().perform();
        academicLink.click();

        return new AcademicBookPage();
    }


}
