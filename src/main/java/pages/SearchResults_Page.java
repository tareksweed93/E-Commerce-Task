package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class SearchResults_Page extends PageBase
{
    public SearchResults_Page(WebDriver driver)
    {
        super(driver); //Refer to constructor of PageBase
    }

    WebElement PanelTitle = driver.findElement(By.cssSelector("h1"));

    WebElement Brand_Filter = driver.findElement(By.xpath("(//img[@alt='chevronUp'])[2]"));

    WebElement Dell_Checkbox = driver.findElement(By.xpath("//div/a/label/span"));

    public String GetPanelTitle ()
    {
        return  Get_Text(PanelTitle);
    }

    public void Expand_Brand_Section ()
    {
        wait.until(ExpectedConditions.elementToBeClickable(Brand_Filter));
        clickButton(Brand_Filter);
    }

    public void Select_Brand ()
    {
        wait.until(ExpectedConditions.elementToBeClickable(Dell_Checkbox));
        clickButton(Dell_Checkbox);
    }

}
