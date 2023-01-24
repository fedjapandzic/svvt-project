import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CheckTermsAndPolicies {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String baseUrl;

    @BeforeAll
    static void setUp() throws Exception{
        driver = new ChromeDriver();
        baseUrl = "https://www.comtrade.com/";
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @AfterAll
    static void close() throws Exception{
//        driver.quit();
    }

    @Test
    public void checkLinks() throws InterruptedException{
        driver.get(baseUrl);
        driver.manage().window().maximize();
        WebElement termsofUse = driver.findElement(By.xpath("/html/body/footer/div[1]/div/ul/li[2]/a"));
        termsofUse.click();
        Thread.sleep(1000);
        assertEquals("https://www.comtrade.com/terms-of-use/",driver.getCurrentUrl());
        driver.navigate().back();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/span")));
        driver.findElement(By.xpath("/html/body/div[3]/span")).click();
        WebElement privacyPolicy = driver.findElement(By.xpath("/html/body/footer/div[1]/div/ul/li[3]/a"));
        privacyPolicy.click();
        Thread.sleep(1000);
        assertEquals("https://www.comtrade.com/privacy-policy/",driver.getCurrentUrl());
        driver.navigate().back();
        Thread.sleep(1000);
        WebElement cookiePolicy = driver.findElement(By.xpath("/html/body/footer/div[1]/div/ul/li[4]/a"));
        cookiePolicy.click();
        Thread.sleep(1000);
        assertEquals("https://www.comtrade.com/cookie-policy/",driver.getCurrentUrl());


    }
}
