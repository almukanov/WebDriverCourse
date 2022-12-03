package ru.almukanov.task3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.almukanov.config.Constans;
import ru.almukanov.driver.Driver;
import ru.almukanov.page.MainPage;

import java.time.Duration;


public class TaskThreeTest {
    WebDriver driver = Driver.getDriver(1);
    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    MainPage mainPage = new MainPage(driver, webDriverWait);
    @Test
    public void shouldDoTaskThree(){


        mainPage.openWebSite(Constans.PRICE_URL);
        WebElement btn = mainPage.getXpathElement("//button[@title='Virtual Machines']");
        btn.click();
        WebElement reg = mainPage.getNameElement("region");
        Select region = new Select(reg);
        region.selectByValue("us-central");
        Select os = new Select(mainPage.getNameElement("operatingSystem"));
        os.selectByValue("linux");
        WebElement vm = mainPage.getXpathElement("//input[@name='count']");
        vm.clear();
        vm.sendKeys("5");
        WebElement compute = mainPage.getXpathElement("//input[@value='sv-three-year']");
        compute.click();
        driver.close();
    }
}
