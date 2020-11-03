package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import runnerTest.webPages.LoginPage;

public class LoginPageSD {

    private final LoginPage loginPage = new LoginPage();

    @Given("^I am on admin login page$")
    public void iAmOnAdminLoginPage(){
        Assert.assertEquals(loginPage.getAdminHeader(), "Admin area demo");
    }

    @When("^I enter (.+) into (username|password) field on the login page$")
    public void enterDataUserAndPasswordFiled(String anyText, String textField){
        switch (textField){
            case "username":
                loginPage.enterEmail(anyText);
                break;
            case "password":
                loginPage.enterPassword(anyText);
                break;
        }
    }

    @And("^I click on (login button|create account) on login page$")
    public void clickOnButton(String button){
        switch (button){
            case "login button":
                loginPage.clickOnLogin();
            case "create account":
                //
                break;
        }
    }

    @Then("^I verify valid login message on sign in page$")
    public void verifyValidLogin(){
        Assert.assertEquals(loginPage.getHomeHeader(), "Dashboard");
        loginPage.clickOnLogout();
    }
}
