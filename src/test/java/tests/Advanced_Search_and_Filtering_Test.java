package tests;

import pages.HomePage;
import pages.SearchResults_Page;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Advanced_Search_and_Filtering_Test extends TestBase
{
    @Test
    public void Search_with_Single_keyword () throws InterruptedException
    {
        HomePage home = new HomePage(driver);
        SearchResults_Page searchResults = new SearchResults_Page(driver);

        home.EnterKeyword("laptop");
        home.ClickEnter();
        String expectedResult = "laptop";
        String actualResult = searchResults.GetPanelTitle();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (dependsOnMethods = {"Search_with_Single_keyword"})
    public void Filtering () throws InterruptedException
    {
        SearchResults_Page searchResults = new SearchResults_Page(driver);

        searchResults.Expand_Brand_Section();
        searchResults.Select_Brand();

        String expectedResult = "DELL";
        String actualResult = searchResults.GetPanelTitle();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
