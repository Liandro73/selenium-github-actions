package br.com.liandro.steps;

import br.com.liandro.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsTest extends BaseSteps {

    public LoginStepsTest() {
    }

    @Given("that I go to the do Swag Labs login page")
    public void that_i_go_to_the_do_swag_labs_login_page() {
        Utils.getDriver().get("https://www.saucedemo.com/");
        fromLoginPO.checkIfLogoLoginPageIsVisible();
    }

    @When("fill user and password fields {} {}")
    public void fill_user_and_password_fields_$_$(String username, String password) {
        fromLoginPO.fillInputUserName(username);
        fromLoginPO.fillInputPassword(password);
    }

    @And("click on Login button")
    public void click_on_login_button() {
        fromLoginPO.clickOnBtnLogin();
    }

    @Then("I should be redirected to Swag Labs products page")
    public void then_i_should_be_redirected_to_swag_labs_products_page() {
        fromProductsPO.checkIfLogoProductsPageIsVisible();
    }

    @Then("I should see the following error msg: {}")
    public void iShouldSeeTheFollowingErrorMsg(String error_msg) {
        fromLoginPO.gettingErrorMessages(error_msg);
    }

}
