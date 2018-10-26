package com.southall.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SharedDriver {

    public static WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }


}
