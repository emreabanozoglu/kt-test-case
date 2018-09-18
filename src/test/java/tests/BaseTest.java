package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver=new ChromeDriver();
        wait=new WebDriverWait(driver,15);

        driver.manage().window().maximize();
    }

    @AfterClass
    public void teatDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
