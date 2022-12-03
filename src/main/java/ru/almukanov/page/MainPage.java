package ru.almukanov.page;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.almukanov.driver.Driver;

import java.time.Duration;

public class MainPage {
    protected WebDriver webDriver ;

    public MainPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    public WebDriverWait webDriverWait;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void openWebSite(String site){
       webDriver.get(site);
    }

    public WebElement getIdElement(String id){

        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }
    public WebElement getNameElement(String name){
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
    }
    public WebElement getXpathElement(String xpath){
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
}
