import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class partnersDisplayed {
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
    public void partnersDisplayed() throws InterruptedException{
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Thread.sleep(500);
        int click;
        WebElement arrowRight = driver.findElement(By.xpath("//*[@id=\"partners-slider\"]/div[2]/div/div[2]"));
        for (int i = 1;i<=5;i++){
            WebElement partner = driver.findElement(By.xpath("//*[@id=\"partners-slider\"]/div[1]/div/div[" + i + "]/div/img"));
            Assert.assertEquals(true,partner.isDisplayed());
        }
        for (click = 0; click <5;click++){
            arrowRight.click();
            Thread.sleep(100);
        }
        for (int j = 6;j<=10;j++){
            WebElement partner = driver.findElement(By.xpath("//*[@id=\"partners-slider\"]/div[1]/div/div[" + j + "]/div/img"));
            Assert.assertEquals(true,partner.isDisplayed());
        }
        for (click = 0; click <4;click++){
            arrowRight.click();
            Thread.sleep(100);
        }
        for (int j = 11;j<=14;j++){
            WebElement partner = driver.findElement(By.xpath("//*[@id=\"partners-slider\"]/div[1]/div/div[" + j + "]/div/img"));
            Assert.assertEquals(true,partner.isDisplayed());
        }


    }
}
