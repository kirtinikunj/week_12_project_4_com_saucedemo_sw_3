package test_suite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Write down the following test into ‘LoginTest’
 * class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * <p>
 * <p>
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on page
 */
public class Login_Test extends Utility {

    String baseUrl = " https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        //* * Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");

        // * * Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");

        //* * Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));

        //* * Verify the text “PRODUCTS”
        String expText = "PRODUCTS";
        String actText = getTextFromElement(By.xpath("//span[text()='Products']"));
        Assert.assertEquals(expText, actText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //* * Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");

        //* * Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");

        //* * Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));

        //* * Verify that six products are displayed on page
        String expectedProduct1 = "Sauce Labs Backpack";
        String actaulProduct1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
        Assert.assertEquals(expectedProduct1, actaulProduct1);

        //product 2
        String expectedProduct2 = "Sauce Labs Bike Light";
        String actaulProduct2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).getText();
        Assert.assertEquals(expectedProduct2, actaulProduct2);

        //product 3
        String expectedProduct3 = "Sauce Labs Bolt T-Shirt";
        String actaulProduct3 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getText();
        Assert.assertEquals(expectedProduct3, actaulProduct3);

        //product 4
        String expectedProduct4 = "Sauce Labs Fleece Jacket";
        String actaulProduct4 = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).getText();
        Assert.assertEquals(expectedProduct4, actaulProduct4);

        //product 5
        String expectedProduct5 = "Sauce Labs Onesie";
        String actaulProduct5 = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).getText();
        Assert.assertEquals(expectedProduct5, actaulProduct5);

        //product 6
        String expectedProduct6 = "Test.allTheThings() T-Shirt (Red)";
        String actaulProduct6 = driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']")).getText();
        Assert.assertEquals(expectedProduct6, actaulProduct6);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
