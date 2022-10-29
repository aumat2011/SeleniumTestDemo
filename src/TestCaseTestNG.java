import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestCaseTestNG
{
    WebDriver driver ;
    String SuccessURL = "https://www.mycompiler.io/";

    void setupChrome()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\necat\\Downloads\\chromedriver.exe\\");
        driver = new ChromeDriver();
        driver.get("https://www.mycompiler.io/login");

    }

    void setupFireFox()
    {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\necat\\Downloads\\geckodriver.exe\\");
        driver= new FirefoxDriver();
        driver.get("https://www.mycompiler.io/login");

    }

    @Test (priority = 1)
    void loginSuccesfullChrome() throws InterruptedException
    {
        setupChrome();

        driver.findElement(By.name("username_or_email")).sendKeys("Deneme123");
        driver.findElement(By.name("password")).sendKeys("Deneme123");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(), SuccessURL);
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    void loginFailedChrome() throws InterruptedException
    {
        setupChrome();

        driver.findElement(By.name("username_or_email")).sendKeys("Deneme123");
        driver.findElement(By.name("password")).sendKeys("DENEME123");
        driver.findElement(By.id("login-button")).click();
        Assert.assertNotEquals(driver.getCurrentUrl(), SuccessURL);
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    void loginSuccesfullFireFox() throws InterruptedException
    {
        setupFireFox();

        driver.findElement(By.name("username_or_email")).sendKeys("Deneme123");
        driver.findElement(By.name("password")).sendKeys("Deneme123");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(), SuccessURL);
        Thread.sleep(5000);
    }

    @Test (priority = 4)
    void loginFailedFireFox() throws InterruptedException
    {
        setupFireFox();

        driver.findElement(By.name("username_or_email")).sendKeys("Deneme123");
        driver.findElement(By.name("password")).sendKeys("DENEME123");
        driver.findElement(By.id("login-button")).click();
        Assert.assertNotEquals(driver.getCurrentUrl(), SuccessURL);
        Thread.sleep(5000);
    }

    @AfterMethod
    void closeDown()
    {
        driver.quit();
    }

}
