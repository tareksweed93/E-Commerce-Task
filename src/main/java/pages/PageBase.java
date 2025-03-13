package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase
{
    static WebDriver driver;

    protected static WebDriverWait wait ;
    protected static Actions Act;
    protected static JavascriptExecutor js;

    public PageBase (WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        Act = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    protected static void clickButton(WebElement button)
    {
        try
        {  	wait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    protected static void setText(WebElement textArea, String text)
    {
        wait.until(ExpectedConditions.visibilityOf(textArea));
        textArea.sendKeys(text);
    }

    public void clearText(WebElement textArea)
    {
        wait.until(ExpectedConditions.visibilityOf(textArea));
        textArea.clear();
    }

    public void Check_checkbox(WebElement checkbox)
    {
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        checkbox.click();
    }

    public String Get_Text (WebElement El)
    {
        //wait.until(ExpectedConditions.textToBePresentInElement(El, El.getText()));
        wait.until(ExpectedConditions.visibilityOf(El));
        return El.getText();
    }

    public static void Click_with_Actions (WebElement element)
    {
        Act.moveToElement(element).click().build().perform();
    }

    public static void ScrollDown (WebElement element)
    {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
