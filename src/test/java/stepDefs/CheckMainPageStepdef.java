package stepDefs;

import base.BaseStep;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.MainPage;

/**
 * Класс с методами тестов главной страницы сайта tsum.ru
 */

public class CheckMainPageStepdef extends BaseStep {

    MainPage mainPage;

    @Given("^Открыть браузер$")
    public void open() {
        openBrowser();
    }

    @Then("^Перейти на '(.*)'$")
    public void goToPage( String url ) {
        driver.navigate().to(url);
        mainPage = new MainPage(driver);
        mainPage.closeGeopopupwindow();
    }

    @Then("^Убедиться что в title указано'(.*)'$")
    public void checkTitleonPage( String title ) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    @Then("Проверить что нажата кнопка {string} в gender меню")
    public void checkActiveGenderButton( String nameButton ) {
        mainPage.checkActiveGenderButton(nameButton);
    }

    @Then("Нажать на кнопку {string} в Главном меню")
    public void useButtonOnMainMenuByText( String nameButton ) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOf(mainPage.getButtonByText(nameButton))).click();
    }

    @Then("Убедиться что в центре страницы отобразилось {string}")
    public void checkTitleOnPage( String title ) {
        Assert.assertEquals(mainPage.getTextFromCentrePageTitle(), title);
    }

    @After
    @Then("Закрыть браузер")
    public void close() {
        closeBrowser();
    }


}
