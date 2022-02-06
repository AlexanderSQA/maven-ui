import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import webDriverFactory.WDFactory;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseTest.class);
    String driverName = System.getProperty("browser");

    @BeforeMethod
    public void startUp() {
        driver = WDFactory.getDriver(driverName);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Драйвер поднят");
    }

    @AfterMethod
    public void end() {
        if (driver != null)
            driver.quit();
    }
}
