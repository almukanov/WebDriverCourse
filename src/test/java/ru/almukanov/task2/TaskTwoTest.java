package ru.almukanov.task2;


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

import static org.testng.Assert.assertEquals;

public class TaskTwoTest {
    WebDriver driver = Driver.getDriver(1);
    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    MainPage pastebin = new MainPage(driver, webDriverWait);


    @Test
    public void shouldDoTaskTwo(){
        pastebin.openWebSite(Constans.PASTEBIN_URL);
        WebElement textArea = pastebin.getIdElement ("postform-text");
        WebElement exp = pastebin.getXpathElement("//*[@id='select2-postform-expiration-container']");

        textArea.sendKeys(Constans.TEST_TEXT_TASK_2);
        WebElement syntax = pastebin.getXpathElement("//*[@aria-labelledby='select2-postform-format-container']");
        syntax.click();
        WebElement list= pastebin.getIdElement("select2-postform-format-results");
        List<WebElement> elements=list.findElements(By.tagName("li"));
        for (WebElement li : elements) {
            if (li.getText().equals("Bash")) {
                li.click();
                break;
            }
        }
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

        WebElement btn = pastebin.getXpathElement("//*[@id='w0']/div[5]/div[1]/div[10]/button");
        btn.click();


        String actualTitle = driver.getTitle();
        String expectedTitle = "helloweb - Pastebin.com";
        assertEquals(actualTitle,expectedTitle,"Check title of page");

        String attr = pastebin.getXpathElement("//ol[@class]").getAttribute("class");
        assertEquals(attr, "bash","Check syntax type equality");

        WebElement code = pastebin.getXpathElement("//ol");
        List<WebElement> codes=code.findElements(By.tagName("li"));
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < codes.size(); i++) {
            if(i == codes.size()-1){
                text.append(codes.get(i).getText());
            } else
            text.append(codes.get(i).getText()).append("\n");
        }
        assertEquals(Constans.TEST_TEXT_TASK_2,text.toString(),"Equals texts");
        driver.close();
    }

}
