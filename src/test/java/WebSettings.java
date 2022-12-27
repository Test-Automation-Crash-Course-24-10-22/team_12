import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
@Listeners({TestListener.class})
public class WebSettings {
    WebDriver driver;

    @BeforeMethod
    public void start() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/ua/");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
