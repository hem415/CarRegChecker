package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static support.Browser.driver;
import static support.Constants.*;
import static support.Utils.waitForElement;

//PageObjects and functions for ResultsPage
public class ResultsPage {
    private static WebElement element = null;

    public static WebElement registration(WebDriver driver) {
        element = driver.findElement(By.xpath(regInput));
        return element;
    }

    public static WebElement make(WebDriver driver) {
        element = driver.findElement(By.xpath(make));
        return element;
    }

    public static WebElement model(WebDriver driver) {
        element = driver.findElement(By.xpath(model));
        return element;
    }

    public static WebElement colour(WebDriver driver) {
        element = driver.findElement(By.xpath(colour));
        return element;
    }

    public static WebElement year(WebDriver driver) {
        element = driver.findElement(By.xpath(year));
        return element;
    }

    public String getReg() {
        waitForElement(driver, regInput, 5000);
        String registration = registration(driver).getText();
        return registration;
    }

    public String getMake() {
        waitForElement(driver, make, 5000);
        String makeOfCar = make(driver).getText();
        return makeOfCar;
    }

    public String getModel() {
        waitForElement(driver, model, 5000);
        String modelOfCar = model(driver).getText();
        return modelOfCar;
    }

    public String getColour() {
        waitForElement(driver, colour, 5000);
        String colourOfCar = colour(driver).getText();
        return colourOfCar;
    }

    public String getYear() {
        waitForElement(driver, year, 5000);
        String yearOfCar = year(driver).getText();
        return yearOfCar;
    }

}
