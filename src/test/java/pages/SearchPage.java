package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends BasePage {

    String searchboxTextAreaId = "searchData";
    String searchButtonClass = "searchBtn";
    String searchItem = "Samsung";
    String itemTextCssSelector = ".resultText > h1:nth-child(1)";
    String secondPage = ".pagination > a:nth-child(2)";
    String favIconClassname = "followBtn";
    String myAccountDropDownClassName = "myAccount";
    String favoritePageLinkXpath = "/html/body/div[1]/header/div/div/div[2]/div[2]/div[2]/div[2]/div/a[2]";
    String productidWE = null;
    String deleteFavLinkClassName= "deleteProFromFavorites";
    String deleteFavOkeyButtonClassName= "btnHolder";


    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void search() {
        writeText(By.id(searchboxTextAreaId), searchItem);
        click(By.className(searchButtonClass));
    }

    public void verifyItemText() {
        Assert.assertEquals(searchItem, readText(By.cssSelector(itemTextCssSelector)));
    }

    public void clickSecondPage() {
        click(By.cssSelector(secondPage));
    }

    public void verifySecondPage() {
        Assert.assertEquals("2", driver.findElement(By.className("currentPage")).getAttribute("value"));
    }

    public void clickFavoriteIcon() {
        By element = By.className(favIconClassname);
        List<WebElement> elements = driver.findElements(element);
        productidWE = elements.get(2).getAttribute("data-productid");
        elements.get(2).click();
    }

    public void goToFavoritePage() throws InterruptedException {
        WebElement menu = driver.findElement(By.className(myAccountDropDownClassName));
        Actions builder = new Actions(driver);
        builder.moveToElement(menu).moveToElement(menu).build().perform();
        Thread.sleep(2000);
        click(By.xpath(favoritePageLinkXpath));
        Thread.sleep(1000);
        click(By.className("listItemTitle"));
    }
    public void verifyFavItem(){
        List<WebElement> products = driver.findElements(By.className("plink"));
        boolean isExist = false;
        for (WebElement webElement : products) {
            String productId = webElement.getAttribute("data-id");
            if (productidWE.equals(productId)) {
                isExist = true;
                break;
            }
        }
        Assert.assertTrue(isExist);
    }

    public void deleteFavItem() throws InterruptedException {
        click(By.className(deleteFavLinkClassName));
        Thread.sleep(500);
        click(By.className(deleteFavOkeyButtonClassName));
    }

    public void verifyDeletedFavItem(){
        List<WebElement> products = driver.findElements(By.className("plink"));
        boolean isExistDeletedItem = true;
        for (WebElement webElement : products) {
            String productId = webElement.getAttribute("data-id");
            if (productidWE.equals(productId)) {
                isExistDeletedItem = false;
                break;
            }
        }
        Assert.assertTrue(isExistDeletedItem);
    }
}

