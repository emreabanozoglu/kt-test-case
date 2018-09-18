package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {

    String baseURL = "https://www.n11.com/";
    String signInButtonClass = "btnSignIn";

    public HomePage(WebDriver driver, WebDriverWait wait) { super(driver,wait); }

    public void goToN11 (){
        driver.get(baseURL);
    }

    public void goToLoginPage (){
        click(By.className(signInButtonClass));
    }

    public void verifyHomePage (){
        Assert.assertEquals(baseURL,driver.getCurrentUrl());
    }
}
