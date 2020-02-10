package cucumber.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class WebDriverFactory {
    //private String PATH_SAFARI_DRIVER = "/usr/bin/safaridriver";
    public static WebDriver createWebDriver() {
        String webdriver = System.getProperty("browser", "chrome");
        switch(webdriver) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fo = new FirefoxOptions();
                //fo.addArguments("--headless");
                return new FirefoxDriver(fo);
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions co = new ChromeOptions();
                //co.addArguments("--headless");
                co.addArguments("--start-maximized");
                co.addArguments("--ignore-certificate-errors");
                co.addArguments("--disable-popup-blocking");
                co.addArguments("--window-size=1920,1080");
                co.addArguments("--incognito");
                return new ChromeDriver(co);
            case "ie":
                //TODO: Arreglar método
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions ieo = new InternetExplorerOptions();
                return new InternetExplorerDriver(ieo);
            case "safari":
                //TODO: implement SafariDriver to factory
            default:
                throw new RuntimeException("Unsupported webdriver: " + webdriver);
        }
    }
}
