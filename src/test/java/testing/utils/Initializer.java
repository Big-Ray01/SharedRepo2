package testing.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Initializer {
    public static WebDriver driver;
    Config config = new Config();
    String driverPath = "src/test/resources/drivers/chrome/chromedriver.exe";
    String websitePath;

    public WebDriver initializeDriver(String website, String Browser) throws Exception {
        config.loadConfig();

        try {
            switch (Browser) {
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver", driverPath);
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", driverPath);
                    driver = new FirefoxDriver();
                default:
                    System.setProperty("webdriver.edge.driver", driverPath);
                    driver = new EdgeDriver();
            }

        } catch (Exception e) {
            throw new Exception("UnSupported Browser: " + Browser);
        }
        if (website.equals("TestWebsite")) {
            websitePath = config.properties.getProperty(website);
            driver.get(websitePath);
        } else {
            System.out.println("Invalid website");
        }

        return driver;
    }

}
