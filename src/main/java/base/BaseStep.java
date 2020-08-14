package base;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseStep {

    public WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeBrowser() {
        if(driver != null){
            driver.quit();
        }
    }
}

