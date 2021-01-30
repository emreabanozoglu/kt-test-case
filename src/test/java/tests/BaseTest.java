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
        wait=new WebDriverWait(driver,15);
        
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);

        driver.manage().window().maximize();
    }

    @AfterClass
    public void teatDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
