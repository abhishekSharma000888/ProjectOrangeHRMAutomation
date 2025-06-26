package tests.negativeTests;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.base.BaseTest;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class LoginTests extends BaseTest {

    @Description("Enter incorrect username with correct password → Should show \"Invalid credentials\" message")
    @Test
    public void incorrectUsername(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.invalidUsernameLoginSetup();

        WebElement invalidCredentials = driver.findElement(By.xpath("//*[@class=\"orangehrm-login-error\"]/div/div/p"));

        String expectedErrorMessage = "Invalid credentials";
        String actualErrorMessage = invalidCredentials.getText();

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Faield to verify the errors,");
    }

    @Description("Enter incorrect password with correct username → Should show \"Invalid credentials\" message")
    @Test
    public void incorrectPassword(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.invalidPasswordLoginSetup();

        WebElement invalidCredentials = driver.findElement(By.xpath("//*[@class=\"orangehrm-login-error\"]/div/div/p"));

        String expectedErrorMessage = "Invalid credentials";
        String actualErrorMessage = invalidCredentials.getText();

        new WebDriverWait(driver, Duration.ofSeconds(3))
        .until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Faield to verify the errors,");
    }

    @Description("Blank Username")
    @Test
    public void blankUsername(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.blankUsernameLoginSetup();

        WebElement requiredField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"));


        String expectedRequiredField = "Required";
        String actualRequiredField = requiredField.getText();

        Assert.assertTrue(requiredField.isDisplayed(), "The error message is not displayed!");
        Assert.assertEquals(actualRequiredField,expectedRequiredField, " Failed to match the errors!!");
}

    @Description("Blank Password with valid username")
    @Test
    public void blankPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.blankPasswordLoginSetup();

        WebElement requiredFieldValidator = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span"));

        String expectedRequiredField = "Required";
        String actualRequiredField = requiredFieldValidator.getText();

        Assert.assertTrue(requiredFieldValidator.isDisplayed());
        Assert.assertEquals(actualRequiredField,expectedRequiredField, "Invalid login check failed!");
    }
    }
