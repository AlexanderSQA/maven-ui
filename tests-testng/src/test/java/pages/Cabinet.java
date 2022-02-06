package pages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Cabinet extends AbstractPage {
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(Cabinet.class);
    private By firstName = By.id("id_fname");
    private By firstNameLatin = By.id("id_fname_latin");
    private By lastName = By.id("id_lname");
    private By lastNameLatin = By.id("id_lname_latin");
    private By blogName = By.id("id_blog_name");
    private By birthDate = By.cssSelector(".input-icon > input:nth-child(1)");
    private By saveButton = By.xpath("//form/div[2]/div/div/button[1]");
    private By addButton = By.xpath("//div[@class= 'js-formset']/button[contains(text(), Добавить)]");
    private By telegramNumberLocator = By.xpath("//div[contains(@class, 'lk-cv-block__select-options')]/div/button[@data-value='telegram']");
    private By whatsappNumberLocator = By.xpath("//div[contains(@class, 'lk-cv-block__select-options')]/div/button[@title='WhatsApp']");
    private By telegramPhoneArea = By.xpath("//*[@id=\"id_contact-0-value\"]");
    private By whatsappPhoneArea = By.xpath("//*[@id=\"id_contact-1-value\"]");


    public Cabinet(WebDriver driver) {
        super(driver);
    }

    public void clearSelfData() {
        driver.findElement(firstName).clear();
        driver.findElement(firstNameLatin).clear();
        driver.findElement(lastName).clear();
        driver.findElement(lastNameLatin).clear();
        driver.findElement(blogName).clear();
        driver.findElement(birthDate).clear();
        driver.findElement(telegramPhoneArea).clear();
    }

    public void fillSelfData(String userFirstName, String userFirstNameLatin, String userLastName,
                             String userLastNameLatin, String userBlogName, String userBirthDate) {
        driver.findElement(firstName).sendKeys(userFirstName);
        driver.findElement(firstNameLatin).sendKeys(userFirstNameLatin);
        driver.findElement(lastName).sendKeys(userLastName);
        driver.findElement(lastNameLatin).sendKeys(userLastNameLatin);
        driver.findElement(blogName).sendKeys(userBlogName);
        driver.findElement(birthDate).sendKeys(userBirthDate);
    }

    public void fillLocation() {
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
    }

    public void englishKnowledge() {
        if (!driver.findElement(By.cssSelector(".container__col_ssm-12 > div:nth-child(3) > div.container__col.container__col_9.container__col_md-8.container__col_middle > div > label > div")).getText().contains("Средний (Intermediate)")) {
            driver.findElement(By.cssSelector(".container__col_ssm-12 > div:nth-child(3) > div.container__col.container__col_9.container__col_md-8.container__col_middle > div > label > div")).click();
            driver.findElement(By.xpath("//div[3]/div[2]/div/div/div/button[5]")).click();
        }
    }


    public void communicationMethod(String telegramNumber, String whatsappNumber) {
        driver.findElement(By.xpath("//div[@data-num = '0']/div/div/div/div[contains(@class, container__col_12)]/div")).click();
        driver.findElement(telegramNumberLocator).click();
        driver.findElement(telegramPhoneArea).sendKeys(telegramNumber);
        driver.findElement(addButton).click();
        driver.findElement(By.xpath("//div[@data-num = '1']/div/div/div/div[contains(@class, container__col_12)]/div")).click();
        driver.findElement(whatsappNumberLocator).click();
        driver.findElement(whatsappPhoneArea).sendKeys(whatsappNumber);

    }

    public void saveAndExitChanges() {
        driver.findElement(saveButton).click();
        logger.info("Обновление данных завершено");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.quit();
    }
}
