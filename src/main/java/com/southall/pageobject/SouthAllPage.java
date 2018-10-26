package com.southall.pageobject;

import com.southall.driver.SharedDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SouthAllPage {

    private static WebDriver driver;

    public SouthAllPage() {
        driver = SharedDriver.getDriver();
    }

    public void navigateToUrl(String websiteUrl) {
        driver.get(websiteUrl);
    }
    //public void navigateToUrl1(String websiteUrl1){driver.get(websiteUrl1);}

    public void enterDestintionFromAndTo(String destinationFrom, String destiontioTo)  throws InterruptedException {
        Thread.sleep(3000);
        getElement("DestinationFrom1").sendKeys(destinationFrom);
        Thread.sleep(3000);
        getElement("DestinationFrom1").sendKeys(Keys.ARROW_DOWN);
        getElement("DestinationFrom1").sendKeys(Keys.TAB);
        Thread.sleep(3000);
        getElement("DestinationTo").sendKeys(destiontioTo);
        Thread.sleep(3000);
        getElement("DestinationTo").sendKeys(Keys.ARROW_DOWN);
        getElement("DestinationTo").sendKeys(Keys.TAB);
    }

    public void selectDepartureAndReturnDates() {
        getElement("deptdt").click();
        getElement("rtndt").click();
    }


    public void selectPassengerInformation(Integer adult, Integer child, Integer infant) {
        getSelect("AdultCnt").selectByIndex(adult);
        if (child > 0) {
            getSelect("Childcnt").selectByIndex(child);
        }
        if (infant > 0) {
            getSelect("InfantCnt").selectByIndex(infant);
        }


    }

    public void selectAirlineAndClass(String airlineType,String airlineClass) {
        getSelect("AirLineCode1").selectByVisibleText(airlineType);
        getSelect("Flightclass").selectByVisibleText(airlineClass);
    }

    public void clickSearchButton() throws InterruptedException {
        getElement("button_flight_search").click();
        Thread.sleep(10000);
    }

   // public void callUsNow() throws InterruptedException {


   // }

    public void expectedPage() throws InterruptedException {
        String expectedUrl = "https://www.southalltravel.co.uk/flightresult.aspx";
        driver.get(expectedUrl);
        try {
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());

            System.out.println("Navigated to correct webpage .as per ");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }



    }

    public void callUsNow() throws InterruptedException {
getElement("GrdEco_ctl00_pcallnow").click();
Thread.sleep(20000);

    }

   // public void backToSearchResults() throws InterruptedException{

     //   getElement(" //*[("//span[@class='title']").click()];
       // Thread.sleep(10000);
   // }


   // public void clickToCallUs() throws InterruptedException{

       //driver.findElement(By.xpath("//span[@class='requestacall']"));

       // getElement("//span[@class='requestacall']");


        //getElement().click();
               // Thread.sleep(50000);
   // }

    public void closeBrowser() {
        driver.quit();
    }

    private WebElement getElement(String locator) {
        return driver.findElement(By.id(locator));
    }

    private Select getSelect(String locator) {
        return new Select(getElement(locator));
    }
}
