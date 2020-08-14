package pages;

import base.BaseStep;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseStep {
    WebDriver driver;

    public MainPage( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'header__gender-switch_desktop')]")
    WebElement genderButtonContainer;

    @FindBy(css = "h1.italic")
    WebElement centerTitle;

    //____________________________________

    public WebElement getGenderButtonByText( String nameButton ) {
        return genderButtonContainer
                .findElement(By.xpath(".//span[contains(text(), '" + nameButton + "')]"));
    }

    public boolean checkActiveGenderButton( String nameButton ) {
        return getGenderButtonByText(nameButton)
                .getAttribute("class")
                .contains("header__gender_active");
    }

    public WebElement getButtonByText( String nameButton ) {
        return driver
                .findElement(By
                        .xpath("//li[contains(@class, 'header__item')]//a[@title= '" + nameButton + "']"));
    }
}
