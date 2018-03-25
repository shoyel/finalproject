package com.saksfifthavenue.qa.runner;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Demo {

    WebDriver driver;
    @Before
    public void setup() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.get("https://www.saksfifthavenue.com/Men/Apparel/Activewear/shop/_/N-52flsh/Ne-6lvnb5");
        driver.get("https://www.saksfifthavenue.com/main/ProductDetail.jsp?FOLDER%3C%3Efolder_id=2534374306418193&PRODUCT%3C%3Eprd_id=845524447209432&R=190391772119&P_name=Lacoste&N=306418193&bmUID=m9hlNIc");
        poplupHandle();
    }

    @Test
    public void test(){
        driver.findElement(By.xpath("//p[@productcode='0400097500294']/span[text() = 'Lacoste']")).click();
        Assert.assertEquals(driver.getTitle(), "Lacoste");
    }


    @Test
    public void test2() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[contains(@class,'highlight')and text()='MEN']"))).perform();
        Thread.sleep(3000);
        WebElement subElement = driver.findElement(By.xpath("//a[contains(@href, '/Men/Apparel/Activewear')]"));
        action.moveToElement(subElement).click().perform();
        driver.findElement(By.xpath("//p[@productcode='0400097500294']/span[text() = 'Lacoste']")).click();
        Assert.assertEquals(driver.getTitle(), "Lacoste");
    }
    @Test
    public void user_click_on_add_to_bag() throws Throwable {
        driver.findElement(By.xpath("//button[@data-reactid='64']")).click();
    }
    @Test
    public void user_should_click_on_checkout () throws Throwable {
        driver.findElement(By.xpath("//span[text()='CHECKOUT']"));
    }



    @After
    public void tearDown() {
//        driver.close();
//        driver.quit();
    }

    public void poplupHandle() {

        WebElement popupDialougeBox = null;

        try {

            popupDialougeBox = driver.findElement(By.xpath(".//*[@id='generic-modal']"));
            System.out.println("Found");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (popupDialougeBox != null) {

            WebElement emailPopUpContainerIframe = popupDialougeBox.findElement(By.xpath("./iframe"));
            driver.switchTo().frame(emailPopUpContainerIframe);
            System.out.println("Switched");

            WebElement closeButton = driver.findElement(By.xpath("//div[@id='close-button']"));
            closeButton.click();
        }
    }
}
