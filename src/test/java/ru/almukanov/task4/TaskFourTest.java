package ru.almukanov.task4;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.almukanov.config.Constans;
import ru.almukanov.driver.Driver;
import ru.almukanov.page.MainPage;

import java.time.Duration;


public class TaskFourTest {
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
        /*
        total
         */
        String downloadFilepath = System.getProperty("user.dir");
        WebElement export = mainPage.getXpathElement("//button[@aria-label='Export Estimate']");
        export.click();

        /*
        Send email
         */
        mainPage.openWebSite(Constans.MAIL_URL);
        WebElement login = mainPage.getNameElement("username");
        login.sendKeys(Constans.EMAIL_ADDRESS_AUTH);
        WebElement btnNext = mainPage.getXpathElement("//button[@data-test-id='next-button']");
        btnNext.submit();
        WebElement password = mainPage.getXpathElement("//input[@name='password']");
        WebElement btnEnter = mainPage.getXpathElement("//button[@data-test-id='submit-button']");
        password.sendKeys(Constans.EMAIL_PASSWORD_AUTH);
        btnEnter.submit();
        mainPage.openWebSite("https://e.mail.ru/compose/");
        mainPage.openWebSite("https://e.mail.ru/compose/");
        WebElement address = mainPage.getXpathElement("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input");
        address.sendKeys(Constans.EMAIL_ADDRESS_TO);
        WebElement subject = mainPage.getNameElement("Subject");
        subject.sendKeys(Constans.EMAIL_SUBJECT);
        WebElement attachFile = mainPage.getXpathElement("//button[@class='container--2lPGK type_wide--2kyds color_base--hO-yz hoverable--2qtk5']//input[@type='file']");
        attachFile.sendKeys(downloadFilepath + "/ExportedEstimate.xlsx");
        WebElement sendBtn = mainPage.getXpathElement("//button[@data-test-id='send']");
        sendBtn.click();
        Driver.closeDriver();
    }
}
