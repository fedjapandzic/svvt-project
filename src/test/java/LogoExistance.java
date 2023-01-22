import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoExistance {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String baseUrl;

    @BeforeAll
    static void setUp() throws Exception{
        driver = new ChromeDriver();
        baseUrl = "https://www.comtrade.com/";
    }
    @AfterAll
    static void close() throws Exception{
//        driver.quit();
    }

    @Test
    public void LogoExists() throws InterruptedException{
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Thread.sleep(500);
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"masthead\"]/nav/div/div/a/img[1]"));
        Assert.assertEquals(true,logo.isDisplayed());
    }

}
