package br.com.liandro.steps;

import br.com.liandro.page.PageObjectFactory;
import br.com.liandro.page.object.LoginPageObject;
import br.com.liandro.page.object.ProductsPageObject;
import br.com.liandro.utils.Utils;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSteps {


    protected WebDriver driver;
    protected WebDriverWait wait;

    protected PageObjectFactory pageObjectFactory;
    protected LoginPageObject fromLoginPO;
    protected ProductsPageObject fromProductsPO;

    public BaseSteps() {
        driver = Utils.getDriver();
        wait = Utils.getWait();
        this.pageObjectFactory = new PageObjectFactory(driver, wait);
        this.fromLoginPO = pageObjectFactory.getLoginPageObject();
        this.fromProductsPO = pageObjectFactory.getProductsPageObject();
    }



}
