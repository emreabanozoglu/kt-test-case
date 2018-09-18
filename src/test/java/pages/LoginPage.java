package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {


    String usernameTextAreaId = "email";
    String passwordTextAreaId = "password";
    String singInButtonId = "loginButton";

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void login (String username , String password){
        writeText(By.id(usernameTextAreaId),username);
        writeText(By.id(passwordTextAreaId),password);
        click(By.id(singInButtonId));
    }

}
