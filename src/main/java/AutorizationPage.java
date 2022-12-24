import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutorizationPage {
    WebDriver driver;

    public AutorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final String SEARCH_EMAIL_FIELD = "//input[@id = 'auth_email']";
    public static final String SEARCH_PASSWORD_FIELD = "//input[@id = 'auth_pass']";
    public static final String SEARCH_ENTER_BUTTON = "//button[@class = 'button button--large button--green auth-modal__submit ng-star-inserted']";
    public static final String SEARCH_ICON_I_AM_NOT_ROBOT = "ngrecaptcha-0";
    @Step("Enter data in email field")
    public void enterDataInEmailField(){
        driver.findElement(By.xpath(SEARCH_EMAIL_FIELD)).sendKeys("tiger38@gmail.com");
    }
    @Step("Enter data in password field")
    public void enterDataInPasswordField(){
        driver.findElement(By.xpath(SEARCH_PASSWORD_FIELD)).sendKeys("11111111");
    }
    @Step("Button Увійти click")
    public void enterButtonClick(){
        driver.findElement(By.xpath(SEARCH_ENTER_BUTTON)).click();
    }
    @Step("Click icon Я не робот and after that click Увійти button manually")
    public void iAmNotRobotClick() { driver.findElement(By.id(SEARCH_ICON_I_AM_NOT_ROBOT)).click();}

}
