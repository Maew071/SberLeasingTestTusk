package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchResultsPage {
    private WebDriver driver;

    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSearchResult (String resultLinkText){
        WebElement searchResult = driver.findElement(By.partialLinkText(resultLinkText));
        searchResult.click();
    }
}
