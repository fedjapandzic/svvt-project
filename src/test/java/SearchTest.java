import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest {
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
    public void searchBar(){
        driver.get(baseUrl);
        driver.manage().window().maximize();
        WebElement searchBar = driver.findElement(By.id("searchli"));
        searchBar.click();
        WebElement search = driver.findElement(By.className("search-field"));
        search.sendKeys("Samsung");
        search.submit();
        String result = driver.findElement(By.className("page-title")).getText();
        Assert.assertEquals("SEARCH RESULTS FOR:\n" +
                "SAMSUNG", result);
    }
}