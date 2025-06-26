package tests.positiveTests;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.base.BaseTest;

public class LoginTest extends BaseTest {

    //Contains login test scenarios
    @Test
    @Description("Positive login test")
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        //using xpath
        WebElement username = driver.findElement(By.xpath("//*[@name=\"username\"]"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//*[@name=\"password\"]"));
        password.sendKeys("admin123");

        implicitWaitApplied();

        WebElement loginButton = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
        loginButton.click();
        loginPage.waitForDashboardUrl();

        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL, "User failed to do the valid login!");

    }

    @Description("valid Login with 'Tab' Navigation")
    @Test
    public void validLoginWithTabNavigation(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginSetup();
        loginPage.waitForDashboardUrl();

        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL,"User failed to do a positive login!");

    }

    @Description("Enter correct username → Enter password with different casing (if allowed) → Should login successfully.")
    @Test
    public void loginAndLogout(){

        //Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginSetup();
        loginPage.waitForDashboardUrl();

        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL,"User failed to do a positive login!");

        //Logout
        loginPage.logoutSetup();

        //added wait to wait for the login page
        loginPage.waitForLoginUrl();

        String expectedLoginURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String actualLoginURL = driver.getCurrentUrl();

        Assert.assertEquals(actualLoginURL,expectedLoginURL, "Failed to get to the navogation page!!");

    }

    @Description("Login, Perform the Activity and then Logout.")
    @Test
    public void loginPerformActivityAndLogout(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginSetup();
        loginPage.validatePersonalDetails();

        loginPage.applyImplicitWait();

        String expectedPersonalDetailsUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7";
        String actualPersonalDetailsUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualPersonalDetailsUrl, expectedPersonalDetailsUrl, "Failed attempt to fetch the URL!");

        //Validate the personal details section
        WebElement personalDetails = driver.findElement(By.xpath("//*[@class=\"orangehrm-edit-employee-content\"]/div/h6"));

        String expectedPersonalDetails = "Personal Details";
        String actualPersonalDetails = personalDetails.getText(); // Fixed here

        Assert.assertEquals(actualPersonalDetails, expectedPersonalDetails, "Failed to find the details section!");

        //Perform the logout
        loginPage.logoutSetup();
    }

}