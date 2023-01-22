import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CheckLinks {
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
        driver.quit();
    }

    @Test
    public void checkLinks() throws InterruptedException{
        driver.get(baseUrl);
        driver.manage().window().maximize();
        WebElement linkedIn = driver.findElement(By.xpath("/html/body/footer/div[2]/div/a[1]"));
        linkedIn.click();
        Thread.sleep(1000);
        ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wid.get(1));
        assertEquals("https://www.linkedin.com/company/comtrade-group",driver.getCurrentUrl());
        driver.switchTo().window(wid.get(0));
        WebElement facebook = driver.findElement(By.xpath("/html/body/footer/div[2]/div/a[2]"));
        facebook.click();
        wid = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wid.get(2));
        assertEquals("https://www.facebook.com/Comtrade/",driver.getCurrentUrl());
        driver.switchTo().window(wid.get(0));
        WebElement twitter = driver.findElement(By.xpath("/html/body/footer/div[2]/div/a[3]"));
        twitter.click();
        wid = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wid.get(3));
        assertEquals("https://twitter.com/comtradegroup",driver.getCurrentUrl());
        driver.switchTo().window(wid.get(0));
        WebElement youtube = driver.findElement(By.xpath("/html/body/footer/div[2]/div/a[4]"));
        youtube.click();
        wid = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wid.get(4));
//        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/form[1]/div/div/button")).click();
        assertEquals("https://www.youtube.com/user/ComTradeGroup",driver.getCurrentUrl());
        Thread.sleep(100);
        driver.switchTo().window(wid.get(0));
        WebElement instagram = driver.findElement(By.xpath("/html/body/footer/div[2]/div/a[5]"));
        instagram.click();
        wid = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wid.get(5));
        assertEquals("https://www.instagram.com/comtrade/",driver.getCurrentUrl());

    }
}

