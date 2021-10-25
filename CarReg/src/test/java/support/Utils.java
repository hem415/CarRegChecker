package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class Utils {
    //Custom wait function
    public static void waitForElement(WebDriver driver, String xpath, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until((Function<? super WebDriver, Object>) webDriver -> webDriver.findElement(By.xpath(xpath)));
    }
}
