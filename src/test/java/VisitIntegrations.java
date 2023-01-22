import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class VisitIntegrations {

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
    public void VisitIntegrations() throws  InterruptedException{
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Thread.sleep(500);
        Actions actions = new Actions(driver);
        WebElement integrationImg = driver.findElement(By.xpath("//*[@id=\"home-two-boxes\"]/div/div[1]/div"));
        actions.moveToElement(integrationImg).perform();
        WebElement integrationButton = driver.findElement(By.xpath("//*[@id=\"home-two-boxes\"]/div/div[1]/div/div[2]/p/a"));
        actions.moveToElement(integrationButton);
        actions.click().perform();
        Thread.sleep(500);
        ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wid.get(1));
        Assert.assertEquals("https://comtradeintegration.com/",driver.getCurrentUrl());
        driver.close();

    }
}
