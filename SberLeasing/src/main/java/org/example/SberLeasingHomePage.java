package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SberLeasingHomePage {
    private WebDriver driver;
    private By carSelectionLink = By.linkText("Car Selection");

    public SberLeasingHomePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void open (){
        driver.get("https://www.sberleasing.ru/");
    }

    public CarSelectionPage navigateToCarSelection (){
        driver.findElement(carSelectionLink).click();
        return new CarSelectionPage(driver);
    }


}
