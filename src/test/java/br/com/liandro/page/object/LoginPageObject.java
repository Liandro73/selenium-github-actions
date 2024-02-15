package br.com.liandro.page.object;

import br.com.liandro.page.PageObjectHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject extends PageObjectHelper {

    public LoginPageObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy( className = "login_logo" )
    private WebElement logoLoginPage;

    @FindBy( id = "user-name" )
    private WebElement inputUserName;

    @FindBy( id = "password" )
    private WebElement inputPassword;

    @FindBy( id = "login-button" )
    private WebElement btnLogin;

    /* Error handling messages */
    @FindBy( xpath = "//h3[@data-test='error']" )
    private WebElement labelErrorMessage;

    public void checkIfLogoLoginPageIsVisible() {
        waitUntilElementIsVisible(logoLoginPage);
    }

    public void fillInputUserName(String username) {
        clearAndTypeInElement(inputUserName, username);
    }

    public void fillInputPassword(String password) {
        clearAndTypeInElement(inputPassword, password);
    }

    public void clickOnBtnLogin() {
        waitUntilElementIsClickableAndClickOn(btnLogin);
    }

    public void gettingErrorMessages(String error_msg) {
        getTextFromElementAndCompare(labelErrorMessage, error_msg);
    }

}
