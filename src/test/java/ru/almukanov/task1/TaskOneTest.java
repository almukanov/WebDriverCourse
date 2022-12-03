package ru.almukanov.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.almukanov.config.Constans;
import ru.almukanov.driver.Driver;
import ru.almukanov.page.MainPage;
import java.time.Duration;
import java.util.List;

public class TaskOneTest {
    WebDriver driver = Driver.getDriver(1);
    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    MainPage pastebin = new MainPage(driver, webDriverWait);

    @Test
    public void shouldDoTaskOne(){
        pastebin.openWebSite(Constans.PASTEBIN_URL);

        WebElement textArea = pastebin.getIdElement ("postform-text");
        textArea.sendKeys(Constans.TEXT_FIRST_TASK);
        WebElement exp = pastebin.getXpathElement("//*[@id='select2-postform-expiration-container']");
        exp.click();
        WebElement listExpiration= pastebin.getIdElement("select2-postform-expiration-results");
        List<WebElement> expirationElements=listExpiration.findElements(By.tagName("li"));
        for (WebElement li : expirationElements) {
            if (li.getText().equals("10 Minutes")) {
                li.click();
                break;
            }
        }
        WebElement title = pastebin.getIdElement("postform-name");
        title.sendKeys("helloweb");
        driver.close();

    }

}
