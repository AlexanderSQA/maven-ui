import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Otus {
    WebDriver driver;
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(Otus.class);

    @BeforeMethod
    public void startUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        logger.info("Драйвер поднят");
    }

    @AfterMethod
    public void end() {
        if (driver != null)
            driver.quit();
    }

    @Test
    public void openPage() throws InterruptedException {
        driver.get("https://otus.ru/");
        logger.info("Сайт открыт");
        Thread.sleep(3000);
        auth();
        enterLk();
        //чистим
        driver.findElement(By.id("id_fname")).clear();
        driver.findElement(By.id("id_fname_latin")).clear();
        driver.findElement(By.id("id_lname")).clear();
        driver.findElement(By.id("id_lname_latin")).clear();
        driver.findElement(By.id("id_blog_name")).clear();
        driver.findElement(By.cssSelector(".input-icon > input:nth-child(1)")).clear();
        //заполняем
        driver.findElement(By.id("id_fname")).sendKeys("Александр");
        driver.findElement(By.id("id_fname_latin")).sendKeys("Alexander");
        driver.findElement(By.id("id_lname")).sendKeys("Шаталов");
        driver.findElement(By.id("id_lname_latin")).sendKeys("Shatalov");
        driver.findElement(By.id("id_blog_name")).sendKeys("Александр");
        driver.findElement(By.cssSelector(".input-icon > input:nth-child(1)")).sendKeys("25.11.1987");
        //Страна
        if (!driver.findElement(By.cssSelector(".js-lk-cv-dependent-master > label:nth-child(1)>div:nth-child(2)")).getText().contains("Россия")) {
            driver.findElement(By.cssSelector(".js-lk-cv-dependent-master > label:nth-child(1)>div:nth-child(2)")).click();
            driver.findElement(By.xpath("//div[1]/div[2]/div/div/div/button[2]")).click();
        }
        //Город
        if (!driver.findElement(By.cssSelector(".js-lk-cv-dependent-slave-city > label:nth-child(1)>div:nth-child(2)")).getText().contains("Ростов-на-Дону")) {
            driver.findElement(By.cssSelector(".js-lk-cv-dependent-slave-city > label:nth-child(1)>div:nth-child(2)")).click();
            driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/button[236]")).click();
        }
        //Уровень английского
        if (!driver.findElement(By.cssSelector(".container__col_ssm-12 > div:nth-child(3) > div.container__col.container__col_9.container__col_md-8.container__col_middle > div > label > div")).getText().contains("Средний (Intermediate)")) {
            driver.findElement(By.cssSelector(".container__col_ssm-12 > div:nth-child(3) > div.container__col.container__col_9.container__col_md-8.container__col_middle > div > label > div")).click();
            driver.findElement(By.xpath("//div[3]/div[2]/div/div/div/button[5]")).click();
        }
        //Сохранение
        driver.findElement(By.xpath("//form/div[2]/div/div/button[1]")).submit();
        logger.info("Обновление данных завершено");
        Thread.sleep(3000);
        //открыть в новом браузере
        driver.quit();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Драйвер поднят");
        driver.get("https://otus.ru/");
        auth();
        enterLk();
        Assert.assertEquals(driver.findElement(By.id("id_fname")).getAttribute("value"), "Александр");
        Assert.assertEquals(driver.findElement(By.id("id_fname_latin")).getAttribute("value"), "Alexander");
        Assert.assertEquals(driver.findElement(By.id("id_lname")).getAttribute("value"), "Шаталов");
        Assert.assertEquals(driver.findElement(By.id("id_lname_latin")).getAttribute("value"), "Shatalov");
        Assert.assertEquals(driver.findElement(By.id("id_blog_name")).getAttribute("value"), "Александр");
        Assert.assertEquals(driver.findElement(By.cssSelector(".input-icon > input:nth-child(1)")).getAttribute("value"), "25.11.1987");
        Assert.assertEquals(driver.findElement(By.cssSelector(".js-lk-cv-dependent-master > label:nth-child(1)>div:nth-child(2)")).getText(), "Россия");
        Assert.assertEquals(driver.findElement(By.cssSelector(".js-lk-cv-dependent-slave-city > label:nth-child(1)>div:nth-child(2)")).getText(), "Ростов-на-Дону");
        Assert.assertEquals(driver.findElement(By.cssSelector(".container__col_ssm-12 > div:nth-child(3) > div.container__col.container__col_9.container__col_md-8.container__col_middle > div > label > div")).getText(), "Средний (Intermediate)");

    }

    private void auth() throws InterruptedException {
        String login = "coyihev466@pyrelle.com";
        String password = "Qazwsx123";
        String locator = "/html/body/div[1]/div/header[2]/div/div[3]/div[1]/button";
        driver.findElement(By.xpath(locator)).click();
        logger.info("Форма авторизации открыта");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[2]/form/div[2]/input")).sendKeys(login);
        driver.findElement(By.xpath("//div[2]/form/div[3]/input")).sendKeys(password);
        driver.findElement(By.xpath("//div[2]/form/div[4]/button")).submit();
        logger.info("Авторизация прошла успешно");
    }

    private void enterLk() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("https://otus.ru/lk/biography/personal/");
        logger.info("Вход в ЛК");
    }


}
