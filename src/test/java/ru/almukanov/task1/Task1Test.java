package ru.almukanov.task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.almukanov.config.Config;
import ru.almukanov.config.Constans;

import java.time.Duration;

public class Task1Test {
    public static void main(String[] args) {
        WebDriver driver = Config.getDriver("chrome");
        Config.openWebSite(Constans.KRISHA);
        WebElement sincePrice = Config.getXpathElement("//input[@type='text' and @placeholder='От']");
        WebElement endPrice = Config.getXpathElement("//input[@type='text' and @placeholder='До']");
        sincePrice.sendKeys("5000");
        endPrice.sendKeys("10000");
        Select realtyType = new Select(Config.getXpathElement("//div[@class = 'search-element-wrap categories-for-sell']//select"));
        realtyType.selectByVisibleText("офис");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Config.getXpathElement("//button[@class='search-btn-main']").submit();

    }
}
