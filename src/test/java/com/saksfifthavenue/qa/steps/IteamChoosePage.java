package com.saksfifthavenue.qa.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class IteamChoosePage extends StepBase {

        @Then("^user select activewear from Men Menu$")
        public void user_click_on_Men_Tabs() throws Throwable {
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(By.xpath("//span[contains(@class,'highlight')and text()='MEN']"))).perform();
            delayFor(3000);

           WebElement subElement= driver.findElement(By.xpath("//a[contains(@href, '/Men/Apparel/Activewear')]"));
            action.moveToElement(subElement).click().perform();
//            action.perform();/

        }

        @Then("^user choose lacoste$")
        public void user_choose_lacoste() throws Throwable {
            driver.findElement(By.xpath("//p[@productcode='0400097500294']/span[text() = 'Lacoste']")).click();
        }



        @Then("^user choose small size$")
        public void user_choose_medium_size() throws Throwable {
            driver.findElement(By.xpath("//span[text()='SMALL']")).click();
        }

    @Then("^user click on add to bag$")
    public void user_click_on_add_to_bag() throws Throwable {
        driver.findElement(By.xpath("//button[@data-reactid='64']")).click();
        delayFor(2000);
    }

    /*@Then("^Verify_the_error_message_if_user_does_not_select_color_or_size$")
    public void Verify_the_error_message_if_user_does_not_select_color_or_size() throws  Throwable {
        driver.findElement(By.xpath("//button[@data-reactid='64'")).click();
        String acutal_error = driver.findElement(By.xpath("//p[text()='Please select a color and/or size.']")).getText();
        String expected_error = "Please select a color and/or size.";
        Assert.assertEquals(expected_error, acutal_error);
    }*/
    @Then("^Verify whether user are able to add items to cart$")
    public void verify_whether_user_are_able_to_add_items_to_cart() throws Throwable {
        String Tittle= driver.getTitle();
        Assert.assertEquals("Saks.com",Tittle);
    }
    @Then("^user should click on checkout$")
    public void user_should_click_on_checkout () throws Throwable {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[contains(text(),'CHECKOUT')]")).click();
    }


    @Then("^verify that user is in checkout page$")
    public void verify_that_user_is_in_checkout_page(){
            String title= driver.getTitle();
                    Assert.assertTrue(title.toLowerCase().contains("saks.com"));
    }

    @Then("^check for edit delet or save option$")
    public void check_for_edit_delet_or_save_option() throws Throwable {
        driver.findElement(By.xpath("//span[text()='Edit']"));

    }
    @Then("^shopping cart should contain price of the product$")
    public void shopping_cart_should_contain_price_of_the_product() throws Throwable {
        driver.findElement(By.xpath("//span[contains(@class,'unit-price')]"));
    }


}

