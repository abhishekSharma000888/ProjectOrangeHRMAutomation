package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Explicit wait added
    public void waitForDashboardUrl() {
        new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
    }

    //WaitForLogin Page
    public void waitForLoginUrl() {
        new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }

    // Implicit Wait
    public void applyImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    public void loginSetup(){

        WebElement username = driver.findElement(By.xpath("//*[@name=\"username\"]"));
        username.sendKeys("Admin");

        username.sendKeys(Keys.TAB);
        WebElement password = driver.switchTo().activeElement();
        password.sendKeys("admin123");

        applyImplicitWait();

        WebElement loginButton = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
        loginButton.click();
    }

    public void validatePersonalDetails(){

        WebElement myInfo = driver.findElement(By.xpath("//span[text()=\"My Info\"]"));
        myInfo.click();

    }

    public void logoutSetup(){

        WebElement userLogoutDropdown = driver.findElement(By.xpath("//*[@class=\"oxd-userdropdown-tab\"]"));
        userLogoutDropdown.click();

        WebElement logoutTab = driver.findElement(By.xpath("//*[@href=\"/web/index.php/auth/logout\"]"));
        logoutTab.click();


    }

}
