package stepDefs;

import base.BaseStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.MainPage;

public class CheckMainPageStepdef extends BaseStep {

    MainPage mainPage;

    @Given("^Открыть браузер$")
    public void open() {
        openBrowser();
    }

    @Then("^Перейти на '(.*)'$")
    public void goTo(String url) {
        driver.navigate().to(url);
        mainPage = new MainPage(driver);
        WebElement wb = driver.findElement(By.xpath("//*[@class='header__module']//*[@class='geo-popup']//button[contains(text(), 'Подтвердить')]"));
        wb.click();

    }

    @Then("^Убедиться что в title указано'(.*)'$")
    public void checkTitleonPage(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    @Then("Проверить что нажата кнопка {string} в gender меню")
    public void checkActiveGenderButton( ) {
        mainPage.checkActiveGenderButton("Женское");
    }

    @Then("Нажать на кнопку {string} в Главном меню")
    public void нажатьНаКнопкуАксессуарыВГлавномМеню(String nameButton) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOf(mainPage.getButtonByText(nameButton))).click();
    }

    @Then("Убедиться что в центре страницы отобразилось {string}")
    public void убедитьсяЧтоВЦентреСтраницыОтобразилосьЖенскиеАксессуары() {
    }

    @Then("Закрыть браузер")
    public void close() {
        closeBrowser();
    }


}
