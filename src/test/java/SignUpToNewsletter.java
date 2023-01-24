import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpToNewsletter {

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
    public void signUpToNewsletter(){
        driver.get(baseUrl);
        driver.manage().window().maximize();
        String podcastUrl = "https://www.comtrade.com/podcast/";
        String podcast = driver.findElement(By.xpath("//a[@href=\"" + podcastUrl + "\"]")).getAttribute("href");
        driver.get(podcast);
        WebElement firstName = driver.findElement(By.name("your-name"));
        WebElement lastName = driver.findElement(By.name("your-lastname"));
        WebElement email = driver.findElement(By.name("your-email"));
        WebElement job = driver.findElement(By.name("your-job"));
        WebElement checkbox = driver.findElement(By.name("acceptance-979"));
        WebElement subscribe = driver.findElement(By.xpath("//*[@id=\"wpcf7-f3438-o1\"]/form/p[1]/input"));

        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        email.sendKeys("johndoe@mail.com");
        job.sendKeys("QA Engineer");
        checkbox.click();
        subscribe.click();
    }
}
