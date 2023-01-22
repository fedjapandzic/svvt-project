import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplyForJob {
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
    public void applyForJob() throws InterruptedException{
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"nav-menu-item-2139\"]/a[2]")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/span")));
        driver.findElement(By.xpath("/html/body/div[3]/span")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"careers-banner\"]/div[3]/a")).click();
        WebElement generalApplication = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div/div/a"));
        generalApplication.click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/div[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/div[2]/a")).click();
        Thread.sleep(1000);
        WebElement firstname = driver.findElement(By.id("first_name"));
        WebElement lastname = driver.findElement(By.id("last_name"));
        WebElement phone = driver.findElement(By.id("phone"));
        WebElement email = driver.findElement(By.id("email"));
        Select DoB = new Select(driver.findElement(By.id("date_of_birth")));
        Select gender = new Select(driver.findElement(By.id("salutation")));
        WebElement address = driver.findElement(By.id("current_address"));
        WebElement city = driver.findElement(By.id("locality"));
        WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div/form/div/div/div[2]/div/div/div/section[1]/div[3]/div/div/div[3]/div[10]/div/label/i"));
        Select findOut = new Select(driver.findElement(By.id("position_source_id")));
        WebElement termsOfUse = driver.findElement(By.xpath("/html/body/div[2]/div/form/div/div/div[2]/div/div/div/section[1]/div[6]/div/div/div/div/label/i"));
        firstname.sendKeys("Fedja");
        Thread.sleep(75);
        lastname.sendKeys("Pandzic");
        Thread.sleep(75);
        phone.sendKeys("0603286013");
        Thread.sleep(75);
        email.sendKeys("feda.pandzic@stu.ibu.edu.ba");
        Thread.sleep(75);
        DoB.selectByVisibleText("2001");
        Thread.sleep(75);
        gender.selectByVisibleText("Male");
        Thread.sleep(75);
        address.sendKeys("Grada Kalgarija 8");
        Thread.sleep(75);
        city.sendKeys("Sarajevo");
        Thread.sleep(75);
        button.click();
        Thread.sleep(75);
        findOut.selectByVisibleText("Friend");
        Thread.sleep(75);
        termsOfUse.click();
    }
}
