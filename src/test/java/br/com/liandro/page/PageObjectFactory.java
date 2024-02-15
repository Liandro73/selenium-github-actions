package br.com.liandro.page;

import br.com.liandro.page.object.LoginPageObject;
import br.com.liandro.page.object.ProductsPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectFactory {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private LoginPageObject loginPageObject;
    private ProductsPageObject productsPageObject;


    public PageObjectFactory(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public LoginPageObject getLoginPageObject() {
        if(this.loginPageObject == null) {
            this.loginPageObject = new LoginPageObject(driver, wait);
        }
        return this.loginPageObject;
    }

    public ProductsPageObject getProductsPageObject() {
        if(this.productsPageObject == null) {
            this.productsPageObject = new ProductsPageObject(driver, wait);
        }
        return this.productsPageObject;
    }

}
