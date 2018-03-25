package com.saksfifthavenue.qa.steps;

import com.google.common.base.Function;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static sun.awt.SunToolkit.DEFAULT_WAIT_TIME;

public class LoginPageSteps extends StepBase {


    @Then("^Browser display Sign In page$")
    public void browser_display_Sign_In_page() throws Throwable {
        String title = driver.getTitle();
        Assert.assertEquals("Saks.com", title);
    }

    @When("^User click Sign In link$")
    public void user_click_Sign_In_link() throws Throwable {
        click(By.xpath(".//*[@id='toolbar']/li[1]/a/span"));
    }

    @When("^User enter user email as \"([^\"]*)\"$")
    public void user_enter_user_email_as(String email) throws Throwable {
        typeText(By.id("sign-into-account-email-field"), email);
    }

    @When("^User enter user password as \"([^\"]*)\"$")
    public void user_enter_user_password_as(String password) throws Throwable {
        typeText(By.id("sign-into-account-password-field"), password);
    }

    @And("^user click SIGN IN button$")
    public void user_click_SIGN_IN_button() throws Throwable {
        click(By.xpath("//button[contains(@class,'sign-into-account')]"));
    }
}




