package pages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(MainPage.class);
    private By authButton = By.xpath("//header[2]/div/div[3]/div/div[1]/button");
    private By loginField = By.xpath("//div[2]/form/div[2]/input");
    private By passwordField = By.xpath("//div[2]/form/div[3]/input");
    private By enterButton = By.xpath("//div[2]/form/div[4]/button");
    private By userMenu = By.xpath("//div[3]/div/div/div[1]/div[3]/p");
    private By userCabinet = By.xpath("//div[3]/div/div/div[1]/div[2]/a[2]");
    private By aboutMyself = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/a[3]");
    String login = System.getProperty("login");     //"coyihev466@pyrelle.com";
    String password = System.getProperty("pass");   //"Qazwsx123";


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        driver.get("https://otus.ru/");
        logger.info("Сайт открыт");
    }

    public void auth() {
        driver.findElement(authButton).click();
        logger.info("Форма авторизации открыта");
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(enterButton).submit();
        logger.info("Авторизация прошла успешно");
    }
    public void enterUserCabinet(){
        driver.findElement(userMenu).click();
        driver.findElement(userCabinet).click();
        driver.findElement(aboutMyself).click();
    }

}
