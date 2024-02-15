package br.com.liandro.page.object;

import br.com.liandro.page.PageObjectHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPageObject extends PageObjectHelper {

    public ProductsPageObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy( className = "app_logo" )
    private WebElement logoProductsPage;

    public void checkIfLogoProductsPageIsVisible() {
        waitUntilElementIsVisible(logoProductsPage);
    }

}
