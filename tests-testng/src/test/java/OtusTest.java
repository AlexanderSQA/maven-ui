import Users.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Cabinet;
import pages.MainPage;

import java.time.Duration;


public class OtusTest extends BaseTest{

    @Test
    public void openPage() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        mainPage.auth();
        mainPage.enterUserCabinet();

        Cabinet cabinet = new Cabinet(driver);
        cabinet.clearSelfData();
        Student student = Student.newBuilder().withFirstName("Александр").withFirstNameLatin("Alexander").withLastName("Шаталов").
                withLastNameLatin("Shatalov").withBlogName("Александр").withBirthDate("25.11.1987").withCountry("Россия").withCity("Ростов-на-Дону").
                withEnglishKnowledge("Средний (Intermediate)").withTelegramNumber("123").withTelegramNumber("456").build();

        cabinet.fillSelfData("Александр", "Alexander", "Шаталов", "Shatalov",
                "Александр", "25.11.1987");

        cabinet.fillLocation();
        cabinet.englishKnowledge();
        cabinet.communicationMethod("123", "456");


        cabinet.saveAndExitChanges();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        MainPage mainPage1 = new MainPage(driver);
        mainPage1.openMainPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        mainPage1.auth();
        mainPage1.enterUserCabinet();


        Assert.assertEquals(driver.findElement(By.id("id_fname")).getAttribute("value"), student.getFirstName());
        Assert.assertEquals(driver.findElement(By.id("id_fname_latin")).getAttribute("value"), student.getFirstNameLatin());
        Assert.assertEquals(driver.findElement(By.id("id_lname")).getAttribute("value"), student.getLastName());
        Assert.assertEquals(driver.findElement(By.id("id_lname_latin")).getAttribute("value"), student.getLastNameLatin());
        Assert.assertEquals(driver.findElement(By.id("id_blog_name")).getAttribute("value"), student.getBlogName());
        Assert.assertEquals(driver.findElement(By.cssSelector(".input-icon > input:nth-child(1)")).getAttribute("value"), student.getBirthDate());
        Assert.assertEquals(driver.findElement(By.cssSelector(".js-lk-cv-dependent-master > label:nth-child(1)>div:nth-child(2)")).getText(), student.getCountry());
        Assert.assertEquals(driver.findElement(By.cssSelector(".js-lk-cv-dependent-slave-city > label:nth-child(1)>div:nth-child(2)")).getText(), student.getCity());
        Assert.assertEquals(driver.findElement(By.cssSelector(".container__col_ssm-12 > div:nth-child(3) > div.container__col.container__col_9.container__col_md-8.container__col_middle > div > label > div")).getText(), student.getEnglishKnowledge());
        Assert.assertNotNull(driver.findElement(By.xpath("//*[@id=\"id_contact-0-value\"]")));
        Assert.assertNotNull(driver.findElement(By.xpath("//*[@id=\"id_contact-1-value\"]")));
    }

}
