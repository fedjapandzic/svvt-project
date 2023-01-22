import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindAndFilterJobs {
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
        driver.quit();
    }

    @Test
    public void findAndFilterJobs() throws InterruptedException{
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"nav-menu-item-2139\"]/a[2]")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/span")));
        driver.findElement(By.xpath("/html/body/div[3]/span")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"careers-banner\"]/div[3]/a")).click();
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"filters\"]/div/div[2]/span/select")));
        dropdown.selectByVisibleText("Slovenia");
    }
}
