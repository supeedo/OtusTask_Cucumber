package pages;

import base.BaseStep;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс описывающий страницу сайта https://tsum.ru
 */

public class MainPage extends BaseStep {
    WebDriver driver;

    // Конструктор с инициализацией PageFactory
    public MainPage( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Поп-ап окно, выбора города. Появляется при первом заходе на сайт и при каждом тесте
    @FindBy(xpath = "//*[@class='header__module']//*[@class='geo-popup']//button[contains(text(), 'Подтвердить')]")
    WebElement geoPopup;

    // Кнопка выбора гендера вверху страницы
    @FindBy(xpath = "//div[contains(@class,'header__gender-switch_desktop')]")
    WebElement genderButtonContainer;

    // Центральный тайтл страницы, отображающий раздел меню
    @FindBy(css = "h1.italic")
    WebElement centerTitle;

    //____________________________________

    @Step("Закрываем geo-popup окно")
    public void closeGeopopupwindow() {
        new WebDriverWait(driver, 50000).until(ExpectedConditions.visibilityOf(geoPopup)).click();
    }

    @Step("Получаем кнопку выбора гендера по ее тексту")
    public WebElement getGenderButtonByText( String nameButton ) {
        return genderButtonContainer
                .findElement(By.xpath(".//span[contains(text(), '" + nameButton + "')]"));
    }

    @Step("Проверяем активность кнопки в гендер-меню")
    public boolean checkActiveGenderButton( String nameButton ) {
        return getGenderButtonByText(nameButton)
                .getAttribute("class")
                .contains("header__gender_active");
    }

    @Step("Получаем кнопку на странице по ее тексту")
    public WebElement getButtonByText( String nameButton ) {
        return driver
                .findElement(By
                        .xpath("//li[contains(@class, 'header__item')]//a[@title= '" + nameButton + "']"));
    }

    @Step("Получаем тест центрального тайтла страницы")
    public String getTextFromCentrePageTitle(){
        return centerTitle.getText();
    }
}
