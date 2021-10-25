package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;

public class Browser {
    public static WebDriver driver;

    //Broswer selection
    public static void initDriver() {
        System.out.println("browser: " + Config.browser);
        switch (Config.browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriverWindows.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "phantom":
                File src = new File("src/test/java/drivers/phantomjs.exe");
                System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
                driver = new PhantomJSDriver();
                break;
            default:
                System.out.println("Incorrect Browser used - please check your params");
                break;
        }
    }

    public static void start() {
        initDriver();
    }

    public static void close() {
        {
            try {
                driver.quit();
                if (driver != null) {
                    driver.close();
                }
            } catch (Exception e) {
                System.out.println("driver does not exist");
            }
        }
    }
}
