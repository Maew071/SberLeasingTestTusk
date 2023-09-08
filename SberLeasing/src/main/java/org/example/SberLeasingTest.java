package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SberLeasingTest {
    private WebDriver driver;

    @BeforeEach

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void testSberLeasing() {
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.open();
        googleHomePage.searchFor("СберЛизинг");

        GoogleSearchResultsPage searchResultsPage = new GoogleSearchResultsPage(driver);
        searchResultsPage.clickSearchResult("СберЛизинг - Официальный сайт");

        SberLeasingHomePage sberLeasingHomePage = new SberLeasingHomePage(driver);
        sberLeasingHomePage.open();

        CarSelectionPage carSelectionPage = sberLeasingHomePage.navigateToCarSelection();
        carSelectionPage.fillCarParameters("Toyota", "Camry", 2023);
        carSelectionPage.showAllOffers();


        String selectedCarMake = carSelectionPage.getSelectedCarMake();
        // Сравнение с ожидаемым значением.
        assertEquals("Toyota", selectedCarMake);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
