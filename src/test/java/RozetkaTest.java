import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class RozetkaTest extends WebSettings{

    @Test
    public void websiteTranslation() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLanguageIcon();
        Assert.assertEquals("Найти", homePage.getTextFindButton());
    }

    @Test
    public void checkingFindButton(){
        HomePage homePage = new HomePage(driver);
        homePage.enterDataInInput("asus");
        homePage.findButtonClick();
        homePage.sleepFewSecond(5);
        Assert.assertEquals("«asus»", homePage.getTextAsusTitle());
    }

    @Test
    public void checkingCatalogButton(){
        HomePage homePage = new HomePage(driver);
        homePage.catalogButtonClick();
        Assert.assertEquals("Ноутбуки", homePage.getTextCatalogTitle());
    }

    @Test
    public void authorization(){
        HomePage homePage = new HomePage(driver);
        AutorizationPage autorizationPage = new AutorizationPage(driver);
        homePage.loginButtonClick();
        homePage.sleepFewSecond(1);
        autorizationPage.enterDataInEmailField();
        autorizationPage.enterDataInPasswordField();
        autorizationPage.enterButtonClick();
        homePage.sleepThreeSeconds();
        autorizationPage.iAmNotRobotClick();
//      pass the I'm not a robot check by selecting the correct photos and clicking the "Login" button manually
        homePage.sleepFewSecond(40);
        Assert.assertEquals("tiger38@gmail.com", homePage.getTextWrongMassage());
    }

    @Test
    public void inputField(){
        HomePage homePage = new HomePage(driver);
        homePage.enterDataInInput2("asus");
        homePage.sleepFewSecond(4);
        homePage.deleteDataInInput();
        homePage.sleepFewSecond(1);
        homePage.enterDataInInput2("iphone");
        homePage.sleepFewSecond(4);
        homePage.deleteDataInInput();
        homePage.sleepFewSecond(4);
        homePage.enterDataInInput2("fs.'th;otht");
    }

}
