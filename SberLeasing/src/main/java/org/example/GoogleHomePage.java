package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {
    private WebDriver driver;
    private String url = "https://www.google.com";

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void open(){
        driver.get(url);

    }
    public void searchFor(String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }
}
