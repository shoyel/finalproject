package com.saksfifthavenue.qa.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApplicationSteps extends StepBase {
    @Given("^Not a validated user$")
    public void not_a_validated_user() throws Throwable {
        driver.manage().deleteAllCookies();
    }

    @When("^user borwse to the site$")
    public void user_borwse_to_the_site() throws Throwable {
        driver.navigate().to("https://www.saksfifthavenue.com/Entry.jsp");
    }

    @Then("^user close pop up$")
    public void user_close_pop_up() throws Throwable {
        poplupHandle();
        delayFor(30);
    }
}
