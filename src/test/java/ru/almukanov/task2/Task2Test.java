package ru.almukanov.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.almukanov.config.Config;
import ru.almukanov.config.Constans;

import java.time.Duration;

public class Task2Test {
    public static void main(String[] args) {
        WebDriver driver = Config.getDriver("chrome");
        Config.openWebSite("https://github.com/login");
        Config.getNameElement("login").sendKeys(Constans.GIT_LOGIN);
        Config.getNameElement("password").sendKeys(Constans.GIT_PASS);
        Config.getNameElement("commit").click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Config.openWebSite(Constans.GIST_GIT);
        WebElement textArea = Config.getXpathElement("//*[@cm-text]");
        textArea.sendKeys(Constans.TEST_TEXT_TASK_2);
        WebElement title = Config.getXpathElement("//input[@class = 'form-control js-gist-filename js-blob-filename']");
        title.sendKeys("task 2");
        Select space = new Select(Config.getXpathElement("//select[@class='form-select select-sm js-code-indent-mode']"));
        space.selectByVisibleText("Tabs");
        WebElement create =  Config.getXpathElement("//div[@class='BtnGroup']//button");
        create.submit();

    }
}
