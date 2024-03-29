import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisitCareers {

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
    public void visitCareers(){
        driver.get(baseUrl);
        driver.manage().window().maximize();
        String careersUrl = "https://www.comtrade.com/careers/";
        String career = driver.findElement(By.xpath("//a[@href=\"" + careersUrl + "\"]")).getAttribute("href");
        driver.get(career);
        Assert.assertEquals("https://www.comtrade.com/careers/",driver.getCurrentUrl());
    }
}
