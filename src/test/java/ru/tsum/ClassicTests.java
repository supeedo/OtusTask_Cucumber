package ru.tsum;

import base.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class ClassicTests extends BaseStep {
    public MainPage mainPage;

    @Test

    public void testTitle() {
        driver.navigate().to("https://tsum.ru");
        Assert.assertEquals(driver.getTitle()
                , "ЦУМ - интернет-магазин одежды, обуви и аксессуаров ведущих мировых брендов");
    }

    @Test
    public void test2() {
        mainPage = new MainPage(driver);
        driver.navigate().to("https://tsum.ru");
        WebElement wb = driver.findElement(By.xpath("//*[@class='header__module']//*[@class='geo-popup']"));
        wb.click();
        mainPage.checkActiveGenderButton("Женское");
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOf(mainPage.getButtonByText("Apple"))).click();
    }
}
