package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarSelectionPage {
    private WebDriver driver;
    private By carMakeField = By.id("carMake");
    private By carModelField = By.id("carModel");
    private By carYearField = By.id("carYear");
    private By showAllOffersButton = By.id("showAllOffers");
    private By selectedCarMake = By.id("selectedCarMake");

    public CarSelectionPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillCarParameters(String make, String model, int year) {
        WebElement makeField = driver.findElement(carMakeField);
        WebElement modelField = driver.findElement(carModelField);
        WebElement yearField = driver.findElement(carYearField);

        makeField.sendKeys(make);
        modelField.sendKeys(model);
        yearField.sendKeys(String.valueOf(year));
    }
    public void showAllOffers(){
        WebElement showAllButton = driver.findElement(showAllOffersButton);
        showAllButton.click();
    }
    public String getSelectedCarMake(){
        WebElement selectedMakeElement = driver.findElement(selectedCarMake);
        return selectedMakeElement.getText();
    }





}
