package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {

  public void implicitWaitApplied(){

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
  }

    protected WebDriver driver;

  @BeforeMethod
    public void setup(){

      driver = new FirefoxDriver();
      driver.manage().window().maximize();

    implicitWaitApplied();

      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

    @AfterMethod
    public void tearDown() {
        // Close the browser
      try {
        // your test steps
      } finally {
        if (driver != null) {
          driver.quit();
        }
      }
    }
    }


