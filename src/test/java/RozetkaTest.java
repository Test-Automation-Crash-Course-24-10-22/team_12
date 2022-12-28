import Pages.AutorizationPage;
import Pages.HomePage;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaTest extends WebSettings{

    @Test(priority = 5)
    @Description("Website translation check")
    @Severity(SeverityLevel.MINOR)
    @Link(url = "https://github.com/Test-Automation-Crash-Course-24-10-22/team_12/issues/15#issue-1447091147")
    @Issue("15")
    public void websiteTranslation() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLanguageIcon();
        Assert.assertEquals("Найти", homePage.getTextFindButton());
    }

    @Test(priority = 3)
    @Description("Checking the correct operation of the Знайти button")
    @Severity(SeverityLevel.NORMAL)
    @Link(url = "https://github.com/Test-Automation-Crash-Course-24-10-22/team_12/issues/10#issue-1447081638")
    @Issue("10")
    public void checkingFindButton(){
        HomePage homePage = new HomePage(driver);
        homePage.enterDataInInput("asus");
        homePage.findButtonClick();
        homePage.sleepFewSecond(5);
        Assert.assertEquals("«asus»", homePage.getTextAsusTitle());
    }

    @Test(priority = 2)
    @Description("Checking the correct operation of the Catalog button")
    @Severity(SeverityLevel.CRITICAL)
    @Link(url = "https://github.com/Test-Automation-Crash-Course-24-10-22/team_12/issues/8#issue-1447075144")
    @Issue("8")
    public void checkingCatalogButton(){
        HomePage homePage = new HomePage(driver);
        homePage.catalogButtonClick();
        Assert.assertEquals("Ноутбуки", homePage.getTextCatalogTitle());
    }

    @Test(priority = 1)
    @Description("Authorization check")
    @Severity(SeverityLevel.NORMAL)
    @Link(url = "https://github.com/Test-Automation-Crash-Course-24-10-22/team_12/issues/14#issue-1447088745")
    @Issue("14")
    public void authorization(){
        HomePage homePage = new HomePage(driver);
        AutorizationPage autorizationPage = new AutorizationPage(driver);
        homePage.loginButtonClick();
        homePage.sleepFewSecond(1);
        autorizationPage.enterDataInEmailField();
        autorizationPage.enterDataInPasswordField();
        autorizationPage.enterButtonClick();
        homePage.sleepFewSecond(3);
        autorizationPage.iAmNotRobotClick();
//      pass the I'm not a robot check by selecting the correct photos and clicking the "Login" button manually
        homePage.sleepFewSecond(10);
        Assert.assertEquals("tiger38@gmail.com", homePage.getTextWrongMassage());
    }

    @Test(priority = 4)
    @Description("Checking the correct operation of the input field")
    @Severity(SeverityLevel.CRITICAL)
    @Link(url = "https://github.com/Test-Automation-Crash-Course-24-10-22/team_12/issues/13#issue-1447085257")
    @Issue("13")
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
        homePage.sleepFewSecond(3);
        Assert.assertEquals("За заданими параметрами не знайдено жодної моделі", homePage.getWrongInputMassage());
    }

}
