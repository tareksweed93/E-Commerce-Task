package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{
    WebDriver driver;

    @BeforeSuite
    public void setup ()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //driver.get("https://www.noon.com");
        driver.navigate().to("https://www.noon.com/egypt-en");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    @AfterSuite
    public void CloseBrowser ()
    {
        driver.quit();
    }
}
