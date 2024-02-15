package br.com.liandro.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectHelper extends PageObjectFactory {

    public PageObjectHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    protected void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void clearAndTypeInElement(WebElement element, String text) {
        element.isDisplayed();
        element.clear();
        element.sendKeys(text);
    }

    protected void waitUntilElementIsClickableAndClickOn(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void getTextFromElementAndCompare(WebElement element, String text) {
        waitUntilElementIsVisible(element);
        String textElement = element.getText();
        System.out.println("-----------------------------------------");
        System.out.println("Text obtained: " + textElement.toUpperCase());
        System.out.println("Text expected: " + text.toUpperCase());
        System.out.println("-----------------------------------------");
    }

}
