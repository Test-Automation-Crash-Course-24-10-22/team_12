import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class RozetkaTest {

    WebDriver driver;

    @BeforeTest
    public void start(){
     chromedriver().setup();
     driver = new ChromeDriver();
     driver.manage().window().maximize();
    }

    @Test
    public void openSite(){
        driver.get("https://rozetka.com.ua/ua/");
    }

   @AfterTest
   public void close(){
        driver.quit();
   }
}
