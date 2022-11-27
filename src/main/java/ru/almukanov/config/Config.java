package ru.almukanov.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.almukanov.config.Browsers;

public class Config {
    private static WebDriver webDriver = null;
    public static WebDriver getDriver(int index){
        Browsers brow = Browsers.values()[index];
        switch (index){
            case 1:webDriver =new ChromeDriver(); break;
            case 2:webDriver =new FirefoxDriver(); break;
        }
        return webDriver;
    }

    public static void openWebSite(String site){
       webDriver.get(site);
    }

    public static WebElement getIdElement(String id){
        WebElement element = webDriver.findElement(By.id(id));
        return element;
    }
    public static WebElement getNameElement(String name){
        WebElement element = webDriver.findElement(By.name(name));
        return element;
    }
    public static WebElement getXpathElement(String xpath){
        WebElement element = webDriver.findElement(By.xpath(xpath));
        return element;
    }
}
