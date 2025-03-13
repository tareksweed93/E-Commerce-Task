package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class HomePage extends PageBase
{
    public HomePage(WebDriver driver)
    {
        super(driver); //Refer to constructor of PageBase
    }

    WebElement SearchBar = driver.findElement(By.xpath("//input[@placeholder='What are you looking for?']"));

    public void EnterKeyword (String value)
    {
        wait.until(ExpectedConditions.visibilityOf(SearchBar));
        clickButton(SearchBar);
        setText(SearchBar, value);
    }

    // Simulate pressing the "Enter" key of keyboard
    public void ClickEnter ()
    {
        wait.until(ExpectedConditions.elementToBeClickable(SearchBar));
        SearchBar.sendKeys(Keys.RETURN);
    }

}


