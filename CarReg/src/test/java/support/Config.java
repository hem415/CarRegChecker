package support;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static support.Constants.CONFIG_PATH;
import static support.Constants.Test_URL;

public class Config {
    public static String environment;
    public static String browser;

    //Environment selection and config creation
    public static void initParams() {
        Properties property = new Properties();
        try {
            try (FileInputStream fis = new FileInputStream(CONFIG_PATH)) {
                property.load(fis);
                switch (property.getProperty("environment").toLowerCase()) {
                    case "test":
                        environment = Test_URL;
                        System.out.println("Environment : " + environment);
                        break;
                    default:
                        System.out.println("no environments for test");
                        throw new AssertionError("No environments");
                }
                browser = property.getProperty("browser");
            }
        } catch (IOException e) {
            System.err.println("config.properties doesn't exist!");
        }
    }
}
