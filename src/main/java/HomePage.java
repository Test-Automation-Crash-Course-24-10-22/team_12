import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public static final String SEARCH_LANGUAGE_ICON = "//a[@class = 'lang__link ng-star-inserted']";
    public static final String SEARCH_FIND_BUTTON = "//button[@class = 'button button_color_green button_size_medium search-form__submit ng-star-inserted']";
    public static final String SEARCH_INPUT = "//input[contains(@name, 'search')]";
    public static final String SEARCH_ASUS_TITLE = "//h1[@class = 'catalog-heading ng-star-inserted']";
    public static final String SEARCH_CATALOG_BUTTON = "//button[@class = 'button button--medium button--with-icon menu__toggle ng-star-inserted']";
    public static final String SEARCH_CATALOG_TITLE = "//a[@class = 'menu__hidden-title']";
    public static final String SEARCH_LOGIN_BUTTON = "//rz-user//button[@class = 'header__button ng-star-inserted']";
    public static final String SEARCH_WRONG_MASSAGE = "//strong";

    @Step("Click the Change language button UA/RU")
    public void clickLanguageIcon(){
        driver.findElement(By.xpath(SEARCH_LANGUAGE_ICON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }
    @Step("Take the text from the Знайти button to check")
    public String getTextFindButton(){
        WebElement findButton = driver.findElement(By.xpath(SEARCH_FIND_BUTTON));
        String textFindButton = findButton.getText();
        return textFindButton;
    }
    @Step("Еnter the data in the input field")
    public void enterDataInInput(String find){
        driver.findElement(By.xpath(SEARCH_INPUT)).sendKeys("asus");
    }
    @Step("Click Знайти button")
    public void findButtonClick(){
        driver.findElement(By.xpath(SEARCH_FIND_BUTTON)).click();
    }
    @Step("Take the text from the Asus title to check")
    public String getTextAsusTitle(){
        WebElement asusTitle = driver.findElement(By.xpath(SEARCH_ASUS_TITLE));
        String textAsusTitle = asusTitle.getText();
        return textAsusTitle;
    }
    @Step("Click Каталог button")
    public void catalogButtonClick(){
        driver.findElement(By.xpath(SEARCH_CATALOG_BUTTON)).click();
    }
    @Step("Take the text from the Catalog title to check")
    public String getTextCatalogTitle(){
        WebElement catalogTitle = driver.findElement(By.xpath(SEARCH_CATALOG_TITLE));
        String textCatalogTitle = catalogTitle.getText();
        return textCatalogTitle;
    }
    @Step("Click Login button")
    public void loginButtonClick(){
        driver.findElement(By.xpath(SEARCH_LOGIN_BUTTON)).click();
    }
    @Step("Wait a few seconds")
    public void sleepFewSecond(int second){
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Take the text from the Wrong Message to check")
    public String getTextWrongMassage(){
        WebElement wrongMassage = driver.findElement(By.xpath(SEARCH_WRONG_MASSAGE));
        String textWrongMassage = wrongMassage.getText();
        return textWrongMassage;
    }
    @Step("Еnter the data in the input field")
    public void enterDataInInput2(String text){
        driver.findElement(By.xpath(SEARCH_INPUT)).sendKeys(text, Keys.ENTER);
    }
    @Step("Clear the input field")
    public void deleteDataInInput(){
        driver.findElement(By.xpath(SEARCH_INPUT)).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
    }

}
