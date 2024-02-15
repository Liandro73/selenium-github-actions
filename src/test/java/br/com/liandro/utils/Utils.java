package br.com.liandro.utils;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    protected static WebDriver driver;
    protected static WebDriverWait wait;


    public static void setUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--ignore-certificate-errors");
//        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--headless");
//        chromeOptions.addArguments("--disable-gpu");
//        chromeOptions.addArguments("--disable-dev-shm-usage");
//        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        throw new RuntimeException("You must call Utils.setUp() before using the driver");
    }

    public static WebDriverWait getWait() {
        if (driver != null) {
            return wait;
        }
        throw new RuntimeException("You must call Utils.setUp() before using the driver");
    }

    public static void stop() {
        if(getDriver() != null) {
            getDriver().quit();
        }
        wait = null;
    }

}
