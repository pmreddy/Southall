package com.southall.tests;

import com.southall.pageobject.SouthAllPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SouthallTest {

    private SouthAllPage southAllPage;

    @Before
    public void setup() {
        southAllPage = new SouthAllPage();

    }

    @Test
    public void testSouthallSearch() throws InterruptedException {
        southAllPage.navigateToUrl("https://www.southalltravel.co.uk");
        //southAllPage.navigateToUrl1("https://www.southalltravel.co.uk/flightresult.aspx");
        southAllPage.enterDestintionFromAndTo("London", "Mumbai");
        southAllPage.selectDepartureAndReturnDates();
        southAllPage.selectPassengerInformation(1, 1, 1);
        southAllPage.selectAirlineAndClass("Air India", "Business");
        southAllPage.clickSearchButton();
        southAllPage.expectedPage();
        southAllPage.callUsNow();
        //southAllPage.backToSearchResults();
        //southAllPage.clickToCallUs();

    }

    @After
    public void cleanUp() {
        southAllPage.closeBrowser();
    }

}
