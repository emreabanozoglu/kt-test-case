package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

public class MainTest extends BaseTest {
    String userName="xwz00718@awsoo.com";
    String password="123456qwerty";

    private HomePage homePage;
    private LoginPage loginPage;
    private SearchPage searchPage;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        searchPage = new SearchPage(driver, wait);
    }

    @Test(priority = 0)
    public void goToN11AndVerify() {
        homePage.goToN11();
        homePage.verifyHomePage();
    }

    @Test(priority = 1)
    public void login() {
        homePage.goToLoginPage();
        loginPage.login(userName, password);
    }

    @Test(priority = 2)
    public void searchItemAndVerify() {
        searchPage.search();
        searchPage.verifyItemText();
    }

    @Test(priority = 3)
    public void goSecondPageAndVerify() throws InterruptedException {
        searchPage.clickSecondPage();
        Thread.sleep(1000);
        searchPage.verifySecondPage();
    }

    @Test (priority = 4)
    public void clickFavIconGoToFavPageAndVerify() throws InterruptedException {
        searchPage.clickFavoriteIcon();
        Thread.sleep(1500);
        searchPage.goToFavoritePage();
        searchPage.verifyFavItem();
    }

    @Test (priority = 5)
    public void deleteFavItemAndVerify() throws InterruptedException {
        searchPage.deleteFavItem();
        Thread.sleep(1000);
        searchPage.verifyDeletedFavItem();
    }

}
