package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

  protected WebDriver driver;

  public void implicitWaitApplied() {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
  }

  @BeforeMethod
  public void setup() {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();

    driver.manage().window().maximize();
    implicitWaitApplied();

    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterMethod
  public void tearDown() {
    try {
      // Keep your test steps here if needed
    } finally {
      if (driver != null) {
        driver.quit();
      }
    }
  }
}
