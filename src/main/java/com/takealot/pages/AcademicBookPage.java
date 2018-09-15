package com.takealot.pages;

import com.takealot.base.BaseConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcademicBookPage extends BaseConfiguration {


    @FindBy(xpath = "//span[contains(text(),'NMU')]")
    WebElement academicLink;

    @FindBy(xpath = "//span[contains(text(),'Academic Books')]")
    WebElement academicBookPage;


    public AcademicBookPage() {

        PageFactory.initElements(driver, this);
    }

    public String getAcademicBooksTitle() {

       return driver.getTitle();
    }

    public boolean confirmAcademicBookLandingText(){
         return academicBookPage.isDisplayed();
    }

    public NMUBooks goToNMUBooks(){
        academicLink.click();
        return new NMUBooks();
    }
}
