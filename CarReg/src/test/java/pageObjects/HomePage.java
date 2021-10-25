package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static support.Browser.driver;

//PageObjects and functions for homePage
public class HomePage {
    private static WebElement element = null;

    public static WebElement regInputBox(WebDriver driver) {
        element = driver.findElement(By.id("vrm-input"));
        return element;
    }

    public static WebElement freeCarCheck(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@class='jsx-1164392954 ']"));
        return element;
    }

    public void enterCarReg(String reg) {
        regInputBox(driver).sendKeys(reg);
    }

    public void freeCheck() {
        freeCarCheck(driver).click();
    }
}

