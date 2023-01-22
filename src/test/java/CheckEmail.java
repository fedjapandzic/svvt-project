import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;


public class CheckEmail {

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
    public void checkEmail(){
        driver.get(baseUrl);
        driver.manage().window().maximize();
        String aboutUrl = "https://www.comtrade.com/about-us/";
        String aboutUs = driver.findElement(By.xpath("//a[@href=\"" + aboutUrl + "\"]")).getAttribute("href");
        driver.get(aboutUs);
        WebElement email = driver.findElement(By.xpath("//*[@id=\"about-us-page\"]/div[5]/div/div[2]/div/p/a"));
        assertEquals("info.rs@comtrade.com",email.getText());

    }
}
