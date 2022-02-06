package webDriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class WDFactory {

    public static WebDriver getDriver(Browsers driverName) {

        switch (driverName) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case OPERA:
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            case IE:
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }

    }

    public static WebDriver getDriver(Browsers driverName, MutableCapabilities options) {

        switch (driverName) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver((ChromeOptions) options);
            case OPERA:
                WebDriverManager.operadriver().setup();
                return new OperaDriver((OperaOptions) options);
            case IE:
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver((InternetExplorerOptions) options);
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver((ChromeOptions) options);
        }

    }

    public static WebDriver getDriver(String driverName) {
        driverName = driverName.toUpperCase();
        switch (driverName) {
            case "CHROME":
                return getDriver(Browsers.CHROME);
            case "OPERA":
                return getDriver(Browsers.OPERA);
            case "IE":
                return getDriver(Browsers.IE);
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }

    }
}
