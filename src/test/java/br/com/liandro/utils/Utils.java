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

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
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
