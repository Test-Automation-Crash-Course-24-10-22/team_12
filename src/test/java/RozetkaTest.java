import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class RozetkaTest {

    WebDriver driver;

    @BeforeTest
    public void start() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void websiteTranslation() {
        driver.get("https://rozetka.com.ua/ua/");

        WebElement languageIcon = driver.findElement(By.xpath("//a[@class = 'lang__link ng-star-inserted']"));
        languageIcon.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    @Test
    public void checkingFindButton(){
        driver.get("https://rozetka.com.ua/ua/");
        WebElement input = driver.findElement(By.xpath("//input[@class = 'search-form__input ng-untouched ng-pristine ng-valid']"));
        WebElement findButton = driver.findElement(By.xpath("//button[@class = 'button button_color_green button_size_medium search-form__submit ng-star-inserted']"));
        input.sendKeys("asus");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        findButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    @Test
    public void checkingCatalogButton(){
        driver.get("https://rozetka.com.ua/ua/");
        WebElement catalogButton = driver.findElement(By.xpath("//button[@class = 'button button--medium button--with-icon menu__toggle ng-star-inserted']"));
        catalogButton.click();
    }

//    @Test
//    public void authorization(){
//        driver.get("https://rozetka.com.ua/ua/");
//        WebElement loginButton = driver.findElement(By.xpath("//rz-user//button[@class = 'header__button ng-star-inserted']"));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//        WebElement emailField = driver.findElement(By.xpath("//input[@id = 'auth_email']"));
//        WebElement passwordField = driver.findElement(By.xpath("//input[@id = 'auth_pass']"));
//        WebElement buttonEnter = driver.findElement(By.xpath("//button[@class = 'button button--large button--green auth-modal__submit ng-star-inserted']"));
//
//        loginButton.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//        emailField.sendKeys("tiger38@gmail.com");
//        passwordField.sendKeys("11111111");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//        buttonEnter.click();
//    }
//
//    @Test
//    public void inputField(){
//        driver.get("https://rozetka.com.ua/ua/");
//        WebElement input = driver.findElement(By.xpath("//input[@class = 'search-form__input ng-untouched ng-pristine ng-valid']"));
//
//        input.sendKeys("asus", Keys.ENTER, Keys.CLEAR);
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
//
//        input.sendKeys("iphone", Keys.ENTER, Keys.CLEAR);
//
//        input.sendKeys("fs.'th;otht", Keys.ENTER, Keys.CLEAR);
//
//    }



    @AfterTest
    public void close() {
        driver.quit();
    }
}
