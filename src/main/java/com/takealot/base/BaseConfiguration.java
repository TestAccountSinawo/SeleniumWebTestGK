package com.takealot.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseConfiguration {

    public static Properties prop;
    public static WebDriver driver;
    public static FileInputStream input;

    int implicit_Wait_TimeOut = 55;
    int page_Load_TimeOut = 55;


    public BaseConfiguration() {

        prop = new Properties();

        try {

            input = new FileInputStream("C:\\Users\\Sinawo Jackson\\Selenium Framework\\GKSeleniumAssessment\\" +
                    "src\\main\\java\\com\\takealot\\utilities\\config.properties");
            prop.load(input);

        } catch (Exception e) {

        }
    }

    public void initialization() {


        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {

            driver = new ChromeDriver();

        } else if (browserName.equals("FireFox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(page_Load_TimeOut,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(implicit_Wait_TimeOut,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));

    }
}
