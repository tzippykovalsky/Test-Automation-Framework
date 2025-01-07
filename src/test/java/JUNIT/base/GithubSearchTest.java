package JUNIT.base;

import enums.BrowserType;
import enums.LocatorType;
import org.junit.jupiter.api.Test;
import pageObject.githubSerach.SearchFilterPage;
import pageObject.githubSerach.SidebarPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GithubSearchTest extends BaseTest{
    public void setBrowserName(){
        this.browserName= BrowserType.CHROME;
    }

    @Test
    public void searchTestBase(){
        SearchFilterPage searchFilterPage = new SearchFilterPage(driver.getWebDriver());
        driver.navigateTo("https://github.com/search");
        searchFilterPage.searchAction("kovalsky");
        assertEquals("https://github.com/search?q=kovalsky&type=repositories",driver.getWebDriver().getCurrentUrl());
    }
    @Test
    public void checkNumUsersAfterSearch(){
        SearchFilterPage searchFilterPage = new SearchFilterPage(driver.getWebDriver());
        SidebarPage sidebarPage = new SidebarPage(driver.getWebDriver());
        driver.navigateTo("https://github.com/search");
        searchFilterPage.searchAction("tzippykovalsky");
        sidebarPage.clickOnUsers();
        assertEquals(1,sidebarPage.getNumUsers());
    }
}
